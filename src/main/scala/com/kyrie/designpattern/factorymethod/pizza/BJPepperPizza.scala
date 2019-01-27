package com.kyrie.designpattern.factorymethod.pizza

/**
   * Created by Kyrie on 2019/1/27.
   */
class BJPepperPizza extends  Pizza{
    override def prepare(): Unit = {

      this.name = "北京 胡椒 pizza"
      println(this.name + "preparing")
    }
  }
