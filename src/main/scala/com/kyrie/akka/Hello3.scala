package com.kyrie.akka

import akka.actor.Actor.Receive
import akka.actor.{Actor, ActorRef, Props, ActorSystem}

/**
 * Created by Kyrie on 2017/7/2.
 */
object Hello3 extends App {


  import Greeter._
  val system = ActorSystem("actor-demo-scala")
  val bob = system.actorOf(props("Bob","Howya doing"))
  val alice = system.actorOf(props("Alice","Happy to meet you"))

  bob ! Greet(alice)
  alice ! Greet(bob)
  Thread sleep 1000
  system shutdown

 /* Howya doing , Alice
  Happy to meet you , Bob*/

  object Greeter{
    case class Greet(peer: ActorRef)
    case object AskName
    case class TellName(name:String)
    def props(name:String, greeting:String) = Props(new Greeter(name,greeting))
  }

  class Greeter(myName:String,greeting:String) extends Actor{
    import Greeter._
    override def receive: Receive = {
      case Greet(peer) => peer ! AskName
      case AskName => sender ! TellName(myName)
      case TellName(name) => println(s"$greeting , $name")
    }
  }
}
