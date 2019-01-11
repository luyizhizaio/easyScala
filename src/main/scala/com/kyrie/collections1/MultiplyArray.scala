package com.kyrie.collections1

/**
 * Created by Kyrie on 2019/1/11.
 */
object MultiplyArray {

  def main(args: Array[String]) {


    //定义3行4列二维数组
    val arr = Array.ofDim[Int](3,4)

    for (item <- arr){
      for(item2 <- item){
        print(item2 +"\t")
      }
      println()
    }

    arr(1)(1) = 100

    println("=======================")
    for (item <- arr){
      for(item2 <- item){
        print(item2 +"\t")
      }
      println()
    }

    println("=======================")

    for(i <- 0 to arr.length -1){
      for(j <- 0 to arr(i).length -1){
        printf("arr[%d][%d]=%d\t",i,j,arr(i)(j))
      }
      println
    }

  }


}
