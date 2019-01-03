package com.kyrie.function

/**
 * Created by Kyrie on 2019/1/3.
 */
object FunDemo01 {

  def main(args: Array[String]) {

    val n1 =10
    val n2=20

    println("res="+getRes(1,2,'c'))

  }

  def getRes(n1:Int, n2:Int,oper:Char)={

    if(oper == '+'){

      n1 +n2
    }else if (oper =='-'){
      n1 - n2
    }else {
      null
    }


  }


}
