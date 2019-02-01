package com.kyrie.functionAdvanced

/**
 * Created by Kyrie on 2019/2/1.
 */
object HigherOrderFunction {


  def main(args: Array[String]) {

    def test(f:Double => Double, f2:Double=>Int,n1:Double)={

      f(f2(n1))
    }


    def sum(d:Double):Double={
      d+d
    }

    def mod(d:Double):Int={
      d.toInt % 2
    }


    val res = test(sum,mod,5.0)

    println(s"res=${res}")

  }
}
