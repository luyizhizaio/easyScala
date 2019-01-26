package com.kyrie.akka.sparkmasterworker.common


//worker注册信息，worker 的资源有多少
case class RegisterWorkerInfo(id:String,cpu:Int,ram:Int)

//保存到master的hashMap中，该hashMap用管理多个worker
class WorkerInfo(val id:String,val cpu :Int, val ram:Int)

//当worker 注册成功，服务器返回一个RegisteredWorkerInfo对象
case object RegisteredWorkerInfo


