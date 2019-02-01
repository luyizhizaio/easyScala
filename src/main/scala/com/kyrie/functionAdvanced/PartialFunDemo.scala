package com.kyrie.functionAdvanced

/**
 * Created by Kyrie on 2019/2/1.
 */
object PartialFunDemo {

  def main(args: Array[String]) {

    val list =List(1,2,3,4,"hello")

    val partialFun = new PartialFunction[Any,Int] {
      override
      def isDefinedAt(x: Any): Boolean = {
        println("x="+x)
        x.isInstanceOf[Int] //判断类型
      }

      override
      def apply(v1: Any): Int = {
        println("v1="+v1)
        v1.asInstanceOf[Int] +1  //转换类型
      }
    }
    //使用偏函数
    val list2 = list.collect(partialFun)

    println("list2 ="+ list2)

  }
}
