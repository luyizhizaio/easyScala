package com.kyrie.designpattern.factorymethod.order

import com.kyrie.designpattern.factorymethod.pizza.{BJCheesePizza, Pizza}

/**
 * Created by Kyrie on 2019/1/27.
 */
class BJOrderPizza extends OrderPizza {
  override
  def createPizza(t: String): Pizza = {

    var pizza :Pizza = null
    if(t == "cheese"){
      new BJCheesePizza
    }else if (t == "pepper"){
      new BJCheesePizza
    } else {
      pizza
    }


  }
}
