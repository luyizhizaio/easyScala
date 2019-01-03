package com.kyrie.oop

/**
 * Created by Kyrie on 2019/1/3.
 */
object ConDemo01 {

  def main(args: Array[String]) {
    val person = new Person("jack")

    println(person)
  }

}


class Person private(inName:String,inAge:Int){ //主构造函数， 会执行类定义中的所有语句。

  var name :String = inName
  var age:Int = inAge
  age+= 10

  println("~~~~~~~~~~~~")

  def this(name:String){ //辅助构造器
    //辅助构造器，必须在第一行显示调用主构造器
    this(name,10)
  }
  override  def toString(): String ={

    s"name = ${name}\t age = ${age}"

  }

}