package com.kyrie.collections1

/**
 * Created by Kyrie on 2019/1/13.
 */
object ListDemo {

  def main(args: Array[String]) {

    val list1= List(1,2,3,"cde")
    println(list1)
    //前面追加
    val list2 = list1.+:("fuck")
    println(list2)
    //后面追加
    val list3 = list1.:+("nihao")
    println(list3)
  }

}
