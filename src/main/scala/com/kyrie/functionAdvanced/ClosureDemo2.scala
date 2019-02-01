package com.kyrie.functionAdvanced

/**
  * Created by Kyrie on 2019/2/1.
  */
object ClosureDemo2 {

   def main(args: Array[String]) {

     //返回匿名函数
     val f =makeSuffix(".jpg")

     println(f("fuck.jpg")) //fuck.jpg

     println(f("cat"))//cat.jpg
   }


  //闭包函数
  def makeSuffix(suffix:String)={

        //返回一个匿名函数，会使用到suffix
    (filename:String) =>{

      if(filename.endsWith(suffix)){
        filename
      }else{
        filename + suffix
      }

    }

  }

 }
