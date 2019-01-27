package com.kyrie.designpattern.rmi

import java.rmi.{RemoteException, Remote}

/**
 * Created by Kyrie on 2019/1/27.
 * 接口文件， 提供给远程端和本地端使用
 */
trait MyRemote extends Remote {


  //抽象方法
  @throws(classOf[RemoteException])
  def sayHello():String

}
