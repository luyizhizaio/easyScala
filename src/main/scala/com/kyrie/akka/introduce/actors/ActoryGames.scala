package com.kyrie.akka.introduce.actors

import akka.actor.{Props, ActorSystem}

/**
 * Created by Kyrie on 2019/1/21.
 * 继承App可不用写主函数
 */
object ActoryGames extends App {

  //创建actorSystem
  private val as = ActorSystem("actorfactory")

  //创建bActorref
  val bActorRef = as.actorOf(Props[BActor],"bActor")
  //创建AActorref
  val aActorRef = as.actorOf(Props(new AActor(bActorRef)))

  //A 开始
  aActorRef ! "start"
}
