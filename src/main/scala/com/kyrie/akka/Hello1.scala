package com.kyrie.akka


import akka.actor.{Actor, Props, ActorSystem}

/**
 * Created by Kyrie on 2017/7/2.
 */
object Hello1 extends App {

  //创建 actor 系统
  val system = ActorSystem("actor-demo")

  //创建actor,返回actor引用
  val hello = system.actorOf(Props[Hello])
  hello ! "Bob"  //使用 actor 引用向 actor 发送消息,! 运算符是 Akka 中表示将一条消息发送到 actor 的便捷方式，与tell相同
  Thread sleep 1000
  system shutdown


  class Hello extends Actor{
    override def receive: Receive = {
      case name:String => println(s"Hello $name")
    }
  }

}
