package com.kyrie.test.akka

/**
 * Created by tend on 2017/7/10.
 */
object MainTest {


  def main(args: Array[String]) {

    val upper = new Upper
    println(upper.upper("hero"))
    println(upper.upper("hero","Hello"))

    println(Seq("prudent","bias").mkString("[",",","]"))

  }

}

class Upper{



  //可选的参数列表
  //strings 参数的类型实际上是 WrapppedArray该类型对 Java 数组进行了封装。
  def upper(strings:String*):Seq[String]={

    strings.map((s:String) =>s.toUpperCase)
  }

}
