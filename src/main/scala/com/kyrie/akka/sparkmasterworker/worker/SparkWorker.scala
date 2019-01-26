package com.kyrie.akka.sparkmasterworker.worker

import java.util.UUID

import akka.actor.{Props, ActorSelection, ActorSystem, Actor}
import akka.actor.Actor.Receive
import com.kyrie.akka.sparkmasterworker.common.{HeartBeat, SendHeartBeat, RegisterWorkerInfo, RegisteredWorkerInfo}
import com.typesafe.config.ConfigFactory
import scala.concurrent.duration._

/**
 * Created by Kyrie on 2019/1/26.
 */
class SparkWorker(masterHost:String,masterPort:Int) extends Actor {

  //masterProxy 是Master ref 代理
  var masterProxy:ActorSelection= _

  //worker Id
  val id = UUID.randomUUID().toString

  @throws[Exception](classOf[Exception])
  override def preStart(): Unit ={
    //初始化masterProxy
    masterProxy = context.actorSelection(s"akka.tcp://SparkMaster@${masterHost}:${masterPort}/user/SparkMaster-01")

    println("masterProxy:"+ masterProxy)

  }

  override def receive: Receive = {

    case "start" =>{
      println("worker 启动了.......")
      //发出注册消息
      masterProxy ! RegisterWorkerInfo(id,16,10240)
    }
    case RegisteredWorkerInfo =>{

      println(s"workerId = $id 注册成功....")

      //发送心跳：注册成功后，就定义一个定时器，每隔一段时间，发送sendHeartBeat给自己。

      import context.dispatcher
      // 0 立即执行
      //3000 每隔3秒发送一次
      //self 发给self
      //SendHeartBeat
      context.system.scheduler.schedule(0 millis,3000 millis,self,SendHeartBeat)



    }

    case SendHeartBeat => {
      println(s"worker=${id} 给master发送心跳")
      masterProxy ! HeartBeat(id)
    }
  }
}


object SparkWorker{

  def main(args: Array[String]) {


    val (clienthost,clientport,masterHost,masterPort) =("192.168.112.1","10001",
      "192.168.112.1",10005)

    //创建config对象，指定协议类型，监听ip和端口
    val conf = ConfigFactory.parseString(
      s"""
         |akka.actor.provider="akka.remote.RemoteActorRefProvider"
         |akk.remote.netty.tcp.hostname=$clienthost
         |akka.remote.netty.tcp.port=$clientport
   """.stripMargin
    )

    //
    val sparkWorkSystem = ActorSystem("SparkWorker",conf)


    val sparkWorkerRef = sparkWorkSystem.actorOf(Props(new SparkWorker(masterHost,masterPort)),"SparkWorker-01")

    //启动actor

    sparkWorkerRef ! "start"


  }


}