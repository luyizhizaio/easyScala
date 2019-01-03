package com.kyrie.function

/**
 * Created by Kyrie on 2019/1/3.
 */
object LazyDemo {

  def main(args: Array[String]) {

    lazy val res = sum(10,23)

    println("-------hello-------------")

    println("res= "+ res)

  }


  def sum(n1:Int,n2:Int):Int={

    println("sum() executing")

    n1 + n2

  }
}
