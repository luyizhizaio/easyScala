package com.kyrie.functionAdvanced

/**
  * Created by Kyrie on 2019/2/1.
  */
object CurryDemo2 {

   def main(args: Array[String]) {

      def eq(s1:String,s2:String):Boolean={

        s1.equals(s2)
      }

     //隐式类
     implicit class TestEq(s:String){


       def checkEq(ss:String)(f:(String,String) => Boolean)={

         f(s.toLowerCase(),ss.toLowerCase)
       }

     }

     val str1 = "fuck"
     println(str1.checkEq("FUCK")(eq))

     println(str1.checkEq("FUCK")(_.equals(_)))

   }

 }
