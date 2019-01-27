package com.kyrie.designpattern.simplefactory

/**
 * Created by Kyrie on 2019/1/27.
 */
object SimpleFactory {

  def createPizza(t:String) :Pizza = {

    var pizza :Pizza = null
    if(t == "greek"){
      new GreekPizza
    }else if (t == "pepper"){
      new PepperPizza
    } else {
      pizza
    }


  }

}
