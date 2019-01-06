package com.kyrie.oop

/**
 * Created by Kyrie on 2019/1/6.
 */
object ScalaBaseContructor {

  def main(args: Array[String]) {

    val Emp2 = new Emp2("JACK")
    Emp2.printName()
  }
}



class Person3(pName:String){

  var name = pName

  def printName(){
    println("Person printName" + name)
  }


  def sayHi(){
    println("sayHi....")
  }


}

class Emp2(eName:String,eAge:Int) extends Person3(eName){

  override def printName(): Unit ={
    println("Emp printName()"+ name)

    super.printName()
    sayHi()
  }

  def this(name:String){
    this(name,10)//必须调用主构造器
  }


  def sayHello(): Unit ={
    println("Hello")
  }


}