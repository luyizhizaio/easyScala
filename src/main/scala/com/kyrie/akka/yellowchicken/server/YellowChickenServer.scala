package com.kyrie.akka.yellowchicken.server

import akka.actor.{ActorRef, Props, ActorSystem, Actor}
import akka.actor.Actor.Receive
import com.kyrie.akka.yellowchicken.common.{ServerMessage, ClientMessage}
import com.typesafe.config.ConfigFactory

/**
 * Created by Kyrie on 2019/1/23.
 */
class YellowChickenServer extends Actor {
  override def receive: Receive = {
    case "start"=>println("start yellow chicken is working")
    case ClientMessage(mes) => {
      println(s"mes:$mes")
      //使用match -case 匹配
      mes match {
        case "大数据学费" => sender() ! ServerMessage("1000RMB")
        case "地址" => sender() ! ServerMessage("北京")
        case "学习什么技术" => sender() ! ServerMessage("大数据，前端 ")
        case _ => sender() ! ServerMessage("你说的啥子")
      }
    }

  }
}



object YellowChickenServer extends App{

  val host = "172.25.126.121"
  val port = "9999"
  //创建config对象，指定协议类型，监听ip和端口
  val conf = ConfigFactory.parseString(
  s"""
     |akka.actor.provider="akka.remote.RemoteActorRefProvider"
     |akk.remote.netty.tcp.hostname=$host
     |akka.remote.netty.tcp.port=$port
   """.stripMargin
  )
  val as = ActorSystem("server",conf)
  val YellowChickenServerRef:ActorRef= as.actorOf(
    Props[YellowChickenServer],"YellowChickenServer")

  //启动监听
  YellowChickenServerRef ! "start"

}