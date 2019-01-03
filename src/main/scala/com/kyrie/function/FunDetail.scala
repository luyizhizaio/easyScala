package com.kyrie.function

/**
 * Created by Kyrie on 2019/1/3.
 */
object FunDetail {


  def main(args: Array[String]) {

    println(f4("3"))

    println(sum(1,3,5,7,9))

  }

  def f4(s:String):Any ={

    if (s.length >= 3){
      s+ "123"
    }else {
      3
    }

  }



  def sum(n1:Int, args:Int*): Int ={

    println("args.length="+ args.length)

    var sum = n1

    for (item <- args){
      sum += item
    }
    sum
  }


}
