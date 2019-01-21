package com.kyrie.akka.introduce

import akka.actor.{ActorRef, Props, ActorSystem, Actor}

/**
 * Created by Kyrie on 2019/1/16.
 * 发消息给自己
 */
//继承Actor 后就是一个Actor
class ActorToHimself extends Actor {


  //1.receive方法，会被该actor 的MailBox调用
  override
  def receive: Receive = {

    case "hello" => println("receive Hello, response hello too.")
    case "ok" => println("receive ok,response ok too.")
    case "exit" =>{
      println("receive exit ,exit system")
      context.stop(self) //停止 actoref
      context.system.terminate() //推出actorsystem
    }
    case _ => println("no match")
  }
}


object SayHelloActorDemo{
  //创建actorSystem，专用于创建Actor
  private val actorFactory = ActorSystem("actorFactory")

  //创建Actor，返回Actor的ActorRef
  private val actorToHimselfActorRef:ActorRef = actorFactory.actorOf(Props[ActorToHimself],"ActorToHimselfActor")


  def main(args: Array[String]) {

    //给actor发送消息
    actorToHimselfActorRef ! "hello"

    actorToHimselfActorRef ! "ok"

    actorToHimselfActorRef ! "fuck"

    actorToHimselfActorRef ! "exit"

  }

}








