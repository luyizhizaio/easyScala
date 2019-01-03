package com.kyrie.oop

/**
 * Created by Kyrie on 2019/1/3.
 */
object CatDemo {


  def main(args: Array[String]) {

    var cat = new Cat
   // cat.color = "white"

    println(cat.color)

  }


}

class Cat{

  var name:String =""
  var age:Int =_  //default
  var color :String =_

}
