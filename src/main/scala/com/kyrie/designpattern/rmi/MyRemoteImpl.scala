package com.kyrie.designpattern.rmi

import java.rmi.Naming
import java.rmi.registry.LocateRegistry
import java.rmi.server.UnicastRemoteObject

/**
 * Created by Kyrie on 2019/1/27.
 * 实现Myremote接口
 */
class MyRemoteImpl extends UnicastRemoteObject with MyRemote {
  //抽象方法
  override
  def sayHello(): String = {
    "Hello world .... "

  }
}

object MyRemoteImpl{

  def main(args: Array[String]) {
    val service :MyRemote = new MyRemoteImpl

//    //绑定方式一
//    LocateRegistry.createRegistry(9999)
//    Naming.rebind("RemoteHello",service)

    //完成注册任务（方式二）
    Naming.rebind("rmi://172.25.126.11:10002/RemoteHello",service)
  }

}