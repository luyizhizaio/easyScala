package com.kyrie.akka.yellowchicken.client

import akka.actor.{Props, ActorSelection, ActorSystem, Actor}
import akka.actor.Actor.Receive
import com.kyrie.akka.yellowchicken.common.{ServerMessage, ClientMessage}
import com.typesafe.config.ConfigFactory

import scala.io.StdIn

/**
 * Created by Kyrie on 2019/1/23.
 */
class CustomerActor(serverHost:String,serverPort:String) extends Actor {


  var serverActorRef:ActorSelection=_

  //prestart方法，在actor运行前执行。初始化工作放在此方法中。
  override
  def preStart():Unit={
    //根据地址找到server
    serverActorRef = context.
      actorSelection(s"akka.tcp://server@${serverHost}:${serverPort}/user/YellowChickenServer")

    println("serverActorRef" + serverActorRef)
  }

  override
  def receive: Receive = {
    case "start" =>println("client start")

      //发现是字符串类型的数据
    case mes:String=>{
      //发给小黄鸡客服
      serverActorRef ! ClientMessage(mes)
    }

    case ServerMessage(mes)=>{
      println(s"收到小黄鸡客服（server）：$mes")
    }
  }
}



object CustomerActor extends  App{

  val (clienthost,clientport,serverHost,serverPort) =("172.25.126.121","9990",
    "172.25.126.121","9999")

  //创建config对象，指定协议类型，监听ip和端口
  val conf = ConfigFactory.parseString(
    s"""
       |akka.actor.provider="akka.remote.RemoteActorRefProvider"
       |akk.remote.netty.tcp.hostname=$clienthost
       |akka.remote.netty.tcp.port=$clientport
   """.stripMargin
  )

  //
  val clientAS = ActorSystem("client",conf)

  //创建CustomerActor的实例和引用

  val customerActorRef = clientAS.actorOf(Props(new CustomerActor(serverHost,serverPort)))


  customerActorRef ! "start"


  //客户端 发送消息

  while(true){
    println("请输入要咨询的问题")
    val mes = StdIn.readLine()
    customerActorRef ! mes


  }

}