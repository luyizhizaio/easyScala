package com.kyrie.akka

import scala.concurrent.duration._
import akka.actor._
import akka.util._
import akka.pattern.ask

/**
 * Created by Kyrie on 2017/7/2.
 */
object Hello4 extends App {

import Greeter._

  val system = ActorSystem("actor-demo-scala")
  val bob = system.actorOf(props("Bob","Howya doing"))
  val alice = system.actorOf(props("alice","Happy to meet you"))
  bob !Greet(alice)
  alice ! Greet(bob)
  Thread sleep 1000
  system shutdown()




  object Greeter{
    case class Greet(peer:ActorRef)
    case object AskName
    def props(name :String, greeting:String)=Props(new Greeter(name,greeting))
  }

  class Greeter(myName:String ,greeting:String) extends Actor{
    import Greeter._
    import system.dispatcher
    implicit val timeout = Timeout(5 seconds)
    def receive = {
      case Greet(peer) => {
        val futureName = peer ? AskName
        futureName.foreach { name => println(s"$greeting, $name") }
      }
      case AskName => sender ! myName
    }

  }
}
