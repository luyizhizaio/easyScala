package com.kyrie.oop

import scala.beans.BeanProperty

/**
 * Created by Kyrie on 2019/1/6.
 */
object BeanPropertyDemo {

  def main(args: Array[String]) {
    var car = new Car

    car.name = "奔驰"
    car.setName("audi")

    println(car.getName)

  }

}

class Car {

  //自动生成，get，set方法
  @BeanProperty
  var name:String = null;
}