package com.kyrie.akka.sparkmasterworker.master

import akka.actor.{Props, ActorSystem, Actor}
import akka.actor.Actor.Receive
import com.kyrie.akka.sparkmasterworker.common._
import com.typesafe.config.ConfigFactory

import scala.collection.mutable
import scala.concurrent.duration._
/**
 * Created by Kyrie on 2019/1/26.
 */
class SparkMaster extends Actor {

  val workers = mutable.Map[String,WorkerInfo]()


  override def receive: Receive = {

    case "start" =>{
      println("master服务器启动了.......")
      //发送定时检测worker消息
      self ! StartTimeOutWorker
    }

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

    case HeartBeat(id) => {
      //更新对应的worker的心跳时间
      val workerInfo = workers(id)
      workerInfo.lastHeartBeat = System.currentTimeMillis()
      println(s"master 更新了${id} 心跳时间")


    }

    case StartTimeOutWorker =>{
      println("开始定时检测worker心跳的任务")

      import context.dispatcher
      // 0 立即执行
      //3000 每隔3秒发送一次
      //self 发给self
      //SendHeartBeat
      context.system.scheduler.schedule(0 millis,9000 millis,self,RemoveTimeOutWorker)
    }

    //检测哪些worker心跳超时（当前时间-heartbeat >6），并从map中删除
    case RemoveTimeOutWorker =>{
      //
      val workInfos = workers.values

      val nowTime = System.currentTimeMillis()

      workInfos.filter{workerInfo =>
        nowTime - workerInfo.lastHeartBeat >6000 }
        .foreach{workerInfo =>
          println(s"worker ${workerInfo.id} 超时，删除该worker")
          workers.remove(workerInfo.id)
        }

      println(s"当前有${workers.size} 个worker存活")

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