package com.kyrie.functionAdvanced

/**
 * Created by Kyrie on 2019/2/1.
 */
object AnonymouseFunction {

  def main(args: Array[String]) {


    //匿名函数
    val triple =(x:Double) =>{
      println("x= "+x)
      3*x
    }
    println("triple"+ triple(3))

    val f1 =(x:Int,y:Int)=>{
      x+y
    }

    println("f1 类型：" + f1) //f1 类型：<function2>

    println(f1(10,19))
  }

}
