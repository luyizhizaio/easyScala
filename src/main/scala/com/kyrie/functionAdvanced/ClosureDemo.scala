package com.kyrie.functionAdvanced

/**
 * Created by Kyrie on 2019/2/1.
 */
object ClosureDemo {

  def main(args: Array[String]) {

    def minusxy(x:Int) =(y:Int) => x-y

    val f = minusxy(20)

    println(s"f(1)=${f(1)}") //19
  }

}
