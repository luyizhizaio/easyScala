package com.kyrie.akka.sparkmasterworker.master

import akka.actor.{Props, ActorSystem, Actor}
import akka.actor.Actor.Receive
import com.kyrie.akka.sparkmasterworker.common.{RegisteredWorkerInfo, WorkerInfo, RegisterWorkerInfo}
import com.typesafe.config.ConfigFactory

import scala.collection.mutable
import scala.sys.Prop

/**
 * Created by Kyrie on 2019/1/26.
 */
class SparkMaster extends Actor {

  val workers = mutable.Map[String,WorkerInfo]()


  override def receive: Receive = {

    case "start" => println("master服务器启动了.......")

    case RegisterWorkerInfo(id,cpu,ram) =>{
      //接受worker注册信息
      if (!workers.contains(id)){
        val workerInfo = new WorkerInfo(id,cpu,ram)
        //加入到workers中
        workers.+=(id -> workerInfo)

        println("服务端 workers=" +workers)
        //回复消息，注册成功
        sender() ! RegisteredWorkerInfo
      }


    }

  }
}



object SparkMaster{

  def main(args: Array[String]) {

    val host = "192.168.112.1"
    val port = "10005"
    //创建config对象，指定协议类型，监听ip和端口
    val conf = ConfigFactory.parseString(
      s"""
         |akka.actor.provider="akka.remote.RemoteActorRefProvider"
         |akk.remote.netty.tcp.hostname=$host
         |akka.remote.netty.tcp.port=$port
   """.stripMargin
    )
    val as = ActorSystem("SparkMaster",conf)

    val sparkMasterRef = as.actorOf(Props[SparkMaster],"SparkMaster-01")

    sparkMasterRef ! "start"

  }

}