package com.kyrie.akka.introduce.actors

import akka.actor.{ActorRef, Actor}
import akka.actor.Actor.Receive

/**
 * Created by Kyrie on 2019/1/21.
 */
class AActor(actorRef:ActorRef) extends Actor {

  val bActorRef = actorRef

  override
  def receive: Receive = {

    case "start" => {
      println("AActor 出招了，start ok")
      self ! "我打" //给自己发消息
    }
    case "我打" =>{
      //给BActor 发送消息

      println("AActor(黄飞鸿): 佛山无影脚")
      Thread.sleep(1000)
      bActorRef ! "无影脚"
    }

  }
}
