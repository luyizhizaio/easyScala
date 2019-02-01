package com.kyrie.functionAdvanced

/**
 * Created by Kyrie on 2019/2/1.
 */
object CurryDemo {

  def main(args: Array[String]) {


    def mul(x:Int,y:Int)=x*y
    println(mul(10,10))


    def mulCurry(x:Int)=(y:Int)=> x*y
    println(mulCurry(10)(8))


    def mulCurry2(x:Int)(y:Int) =x*y
    println(mulCurry2(10)(6))




  }

}
