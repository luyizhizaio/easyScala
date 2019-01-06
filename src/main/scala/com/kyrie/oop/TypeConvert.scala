package com.kyrie.oop

/**
 * Created by Kyrie on 2019/1/6.
 */
object TypeConvert {

  def main(args: Array[String]) {

    println(classOf[String])

    val s ="nihao"

    println(s.getClass.getName)

    var p1 = new  Person2
    var emp = new Emp

    p1 = emp

    if(p1.isInstanceOf[Emp]){
      var emp2 = p1.asInstanceOf[Emp] //向下转型
      emp2.sayHello()
      println("转换成功")

    }else{
      println("转换失败")
    }




  }

}


class Person2{

  var name:String ="Tony"

  def printName(){
    println("Person printName" + name)
  }


  def sayHi(){
    println("sayHi....")
  }


}

class Emp extends Person2{

  override def printName(): Unit ={
    println("Emp printName()"+ name)

    super.printName()
    sayHi()
  }


  def sayHello(): Unit ={
    println("Hello")
  }


}