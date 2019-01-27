package com.kyrie.designpattern.factorymethod

import com.kyrie.designpattern.factorymethod.pizza.Pizza

import scala.io.StdIn
import scala.util.control.Breaks._

/**
  * Created by Kyrie on 2019/1/27.
  */
abstract class OrderPizza {

   var orderType:String=_

   var pizza :Pizza =_

   breakable{

     do{
       println("input type of pizza:")
       var orderType = StdIn.readLine()
       pizza = createPizza(orderType)

       if(pizza == null){
         break()
       }

       this.pizza.prepare()


     }while(true)

   }


  def createPizza(t:String):Pizza




 }
