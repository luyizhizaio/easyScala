package com.kyrie.function

/**
 * Created by Kyrie on 2019/1/3.
 */
object Recursive {

  def main(args: Array[String]) {

    //斐波那契数 ：第n为
    println(s"fbn=${fbn(3)}")

  }


  def fbn(n:Int):Int ={

    if(n==1 || n==2){
      1
    }else{

      fbn(n-1) + fbn(n-2)
    }

  }



  def f2(n:Int):Int = {
    if (n == 1) {
      3
    } else {
      2 * f2(n - 1)
    }


  }

}
