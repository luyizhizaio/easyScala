package com.kyrie.functionAdvanced

/**
 * Created by Kyrie on 2019/2/1.
 */
object PartialFunDemo2 {

  def main(args: Array[String]) {

    //简写偏函数为case
    def partialFun2:PartialFunction[Any,Int]={

      case i:Int => i+1
      case j:Double => (j *2).toInt
    }

    val list = List(1,2,3,4,5,1.3,2.5,2.2f,"hello")

    val list2 = list.collect(partialFun2)

    println("list2="+list2)


    //简化2：
    val list3= list.collect{
      case i:Int => i+1
      case j:Double => (j*2)
      case k:Float => k*3
    }


    println("list3="+ list3)


  }

}
