package com.kyrie.test.akka

/**
 * Created by tend on 2017/7/10.
 */
class Shapes {


}

case class Point(x:Double = 0.0,y:Double=0.0)


abstract class Shape(){

  /**
   * draw方法接受一个函数参数。每个图形对象都会将自己的字符格式传给函数f，
   * 由函数f执行绘制工作。
   */
  def draw(f:String => Unit) :Unit=f(s"draw:${this.toString}")
}

case class Circle (Center :Point,radius:Double) extends Shape

case class Rectangle(lowerLeft:Point,hieght:Double,width:Double) extends Shape

case class Triangle(point1:Point,point2:Point,point3:Point) extends Shape