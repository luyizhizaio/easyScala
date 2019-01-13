package com.kyrie.collections1

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable

/**
 * Created by Kyrie on 2019/1/13.
 */
object ArrayBuffer2JavaList {

  def main(args: Array[String]) {

    val arr = ArrayBuffer("1","2","3")

    //ArrayBuffer 转成java List
    import scala.collection.JavaConversions.bufferAsJavaList
    val javaArr = new ProcessBuilder(arr)

    val arrList = javaArr.command()

    //JAVA 砖scala
    import scala.collection.JavaConversions.asScalaBuffer
    val scalaArr:mutable.Buffer[String] = arrList


  }

}
