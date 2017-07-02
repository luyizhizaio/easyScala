/*
package com.kyrie.akka

import akka.actor.{ActorRef, Actor}
import akka.actor.Actor.Receive

/**
 * Created by Kyrie on 2017/7/2.
 */
object ActorLifecycle {

  def main(args: Array[String]) {

  }



  class MyWorker extends Actor{
    object working
    object done
    object close

    override def preStart: Unit ={
      println("myworker is starting")
    }

    override def postStop: Unit ={
      println("myworker is stopping")
    }



    override def receive: Receive = {
      case working => println("i am working")
      case done => println("stop working")
      case close => {
        println("i will shutdown")
        sender ! (close,self)
        context.stop(self)
      }
      case _ => unhandled()
    }
  }


 /* class WatchActor(ref:ActorRef) extends Actor{

    def apply(): Unit ={
      context.watch(ref)
    }

    override def receive: Actor.Receive = {


    }
  }
*/

}
*/
