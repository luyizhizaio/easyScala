package com.kyrie.functionAdvanced

/**
 * Created by Kyrie on 2019/2/1.
 * 使用控制抽象实现了while语法
 */
object AbstractControl {

  def main(args: Array[String]) {

    def myRunInThread(f1:() => Unit) ={

      new Thread{
        override  def run():Unit={
          f1()
        }
      }.start()
    }

    myRunInThread{

      ()=>
        println("干活喽，5秒完成")
        Thread.sleep(5000)
        println("干完了")
    }

  }

}
