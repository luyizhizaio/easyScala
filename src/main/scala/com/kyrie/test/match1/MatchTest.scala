package com.kyrie.test.match1


/**
 * Created by tend on 2017/7/10.
 */
object MatchTest extends App{



  val  bools =Seq(true,false)

  for (bool <-bools){
    bool match{
      case true => println("got heads")
      case false => println("got tails")
    }

  }

  //*******************************************************/

  println("**********************************************")

  for{
    x <-Seq(1,2,2.7,"one","two",'four)
  }{
    val str = x match {
      case 1 => "int 1"
      case i:Int => "other int:" +x
      case d:Double => "a double:"+x
      case "one" => "string one"
      case s:String => "other string" + s
      case unexpected => "unexpected value:" + unexpected
    }
    println(str)
  }


  println("**********************************************")

  for{
    x <-Seq(1,2,2.7,"one","two",'four)
  }{
    val str = x match {
      case 1 => "int 1"
      case _:Int => "other int:" +x
      case _:Double => "a double:"+x
      case "one" => "string one"
      case _:String => "other string" + x
      case _ => "unexpected value:" + x
    }
    println(str)
  }

  println("**********************************************")

  def checkY(y: Int) = {
    for {
      x <- Seq(99, 100, 101)
    } {
      val str = x match {
        case y => "found y!"
        case i: Int => "int: "+i
      }
      println(str)
    }
  }
  checkY(100)


}
