package com.kyrie.designpattern.simplefactory

/**
  * Created by Kyrie on 2019/1/27.
  */
class PepperPizza extends  Pizza{
   override def prepare(): Unit = {

     this.name = "胡椒pizza"
     println(this.name + "preparing")

   }
 }
