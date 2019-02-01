package com.kyrie.functionAdvanced

/**
  * Created by Kyrie on 2019/2/1.
  * 使用控制抽象实现了while语法
  */
object AbstractControl2 {


   def main(args: Array[String]) {

     var x =10

      def mywhile(condition: => Boolean)(block: => Unit):Unit={

       if(!condition){
         block
         mywhile(condition)(block)
       }
     }


     mywhile(x==0){
       x-=1
       println(s"x=${x}")
     }
   }

 }
