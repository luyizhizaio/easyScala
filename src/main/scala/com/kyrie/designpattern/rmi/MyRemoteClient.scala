package com.kyrie.designpattern.rmi

import java.rmi.Naming

/**
 * Created by Kyrie on 2019/1/27.
 */
class MyRemoteClient {

  def go() = {

    val service = Naming.lookup("rmi://172.25.126.11:10002/RemoteHello").asInstanceOf[MyRemote]
    val str = service.sayHello()

    println("str = "+str)

  }

}

object MyRemoteClient{

  def main (args: Array[String]){
    new MyRemoteClient().go()

  }

}
