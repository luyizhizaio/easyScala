package com.kyrie.function

/**
 * Created by Kyrie on 2019/1/3.
 */
object ExceptionDemo {

  def main(args: Array[String]) {

    f()
  }


  @throws(classOf[NumberFormatException])
  def f()={

    "abc".toInt

  }

}
