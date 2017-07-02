package com.kyrie.akka

import akka.actor.{Actor, Props, ActorSystem}

/**
 * Created by Kyrie on 2017/7/2.
 *  actor 处理两种不同类型的消息
 */
object Hello2 extends App {

  case class Greeting(greet:String)
  case class Greet(name :String)

  val system = ActorSystem("actor-demo-scala")

  val hello = system.actorOf(Props[Hello],"hello")

  hello ! Greeting("Hello")
  hello ! Greet("Bob")
  hello ! Greet("Alice")
  hello ! Greeting("Hola")
  hello ! Greet("Alice")
  hello ! Greet("Bob")
  Thread sleep 1000
  system shutdown
//消息不一定是按此顺序出现的，因为 actor 执行顺序是不确定的



  class Hello extends Actor{
    var greeting =""
    def receive={
      case Greeting(greet) => greeting =greet
      case Greet(name) => println(s"$greeting  $name")

    }
  }
}
