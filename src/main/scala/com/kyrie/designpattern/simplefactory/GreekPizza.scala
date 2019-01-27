package com.kyrie.designpattern.simplefactory

/**
 * Created by Kyrie on 2019/1/27.
 */
class GreekPizza extends  Pizza{
  override def prepare(): Unit = {

    this.name = "希腊 pizza"
    println(this.name + "preparing")
  }
}
