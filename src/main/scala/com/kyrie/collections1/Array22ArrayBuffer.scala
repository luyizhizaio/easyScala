package com.kyrie.collections1

import scala.collection.mutable.ArrayBuffer

/**
 * Created by Kyrie on 2019/1/13.
 */
object Array22ArrayBuffer {


  def main(args: Array[String]) {

      var arrb = ArrayBuffer[Int]()

      arrb.append(1,2,3,4)

    println(arrb)


    val newarr = arrb.toArray

    println(newarr)

    val newArr2 = newarr.toBuffer
    newArr2.append(4,5)
    println(newArr2)
  }


}
