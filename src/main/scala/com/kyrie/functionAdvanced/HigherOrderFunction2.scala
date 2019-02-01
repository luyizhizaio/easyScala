package com.kyrie.functionAdvanced

/**
  * Created by Kyrie on 2019/2/1.
  */
object HigherOrderFunction2 {


   def main(args: Array[String]) {

     //该函数返回匿名函数
     def minusXY(x:Int)={

       (y:Int) => x-y //匿名函数

     }

     val f1 = minusXY(3)

     println(s"f1 的类型=${f1}")

     println(f1(1)) //3-1 =2


   }
 }
