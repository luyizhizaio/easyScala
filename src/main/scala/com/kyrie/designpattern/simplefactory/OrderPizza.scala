package com.kyrie.designpattern.simplefactory


import scala.io.StdIn
import scala.util.control.Breaks._
/**
 * Created by Kyrie on 2019/1/27.
 */
class OrderPizza {

  var orderType:String=_

  var pizza :Pizza =_

  breakable{

    do{
      println("input type of pizza:")
      var orderType = StdIn.readLine()
      pizza = SimpleFactory.createPizza(orderType)

      if(pizza == null){
        break()
      }

      this.pizza.prepare()


    }while(true)

  }




}
