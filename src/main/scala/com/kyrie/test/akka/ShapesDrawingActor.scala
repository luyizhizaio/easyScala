package com.kyrie.test.akka

/**
 * Created by tend on 2017/7/10.
 */

  //定义actor之间通信的消息
  object Messages{
    object Exit  //起标志作用
    object Finished
    case class Response(message:String)
  }

  import akka.actor.Actor

  class ShapesDrawingActor extends Actor{

    import Messages._

    override def receive: Receive = {
      case s:Shape =>
        s.draw(str => println(s"ShapeDrawingActor:$str"))
        sender ! Response(s"ShapesDrawingActor: $s drawn")
      case Exit =>
        println(s"ShapesDrawingAcotr: exiting ...")
        sender ! Finished
      case unexpected =>
        val response = Response(s"ERROR:Unknown message:$unexpected")
        println(s"ShapesDrawingActor:$response")
        sender ! response
    }

  }



