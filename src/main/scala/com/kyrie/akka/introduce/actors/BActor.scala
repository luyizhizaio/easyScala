package com.kyrie.akka.introduce.actors

import akka.actor.Actor
import akka.actor.Actor.Receive

/**
  * Created by Kyrie on 2019/1/21.
  */
class BActor extends Actor {
  override def receive: Receive = {

    case "无影脚" =>{
      println("BActor(乔峰)：降龙十八掌")
      Thread.sleep(1000)
      //通过sender 可以获取到发送消息的actor的ref
      sender ! "我打"

    }
  }
}
