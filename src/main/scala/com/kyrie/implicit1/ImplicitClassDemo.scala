package com.kyrie.implicit1

 /**
 * Created by Kyrie on 2019/1/9.
 */
object ImplicitClassDemo {


   def main(args: Array[String]) {

     implicit class DB1(val m:MySQL1){
       def addSuffix():String={
         m + " scala"
       }
     }


     val mySQL = new MySQL1
     mySQL.sayOK

     println( mySQL.addSuffix())

   }
}

class MySQL1{

  def sayOK:Unit={
    println("sayOK")
  }

}