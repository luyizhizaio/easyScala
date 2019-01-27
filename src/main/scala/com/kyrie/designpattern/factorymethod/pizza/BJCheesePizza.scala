package com.kyrie.designpattern.factorymethod.pizza

/**
   * Created by Kyrie on 2019/1/27.
   */
class BJCheesePizza extends  Pizza{
    override def prepare(): Unit = {

      this.name = "北京 奶酪 pizza"
      println(this.name + "preparing")
    }
  }
