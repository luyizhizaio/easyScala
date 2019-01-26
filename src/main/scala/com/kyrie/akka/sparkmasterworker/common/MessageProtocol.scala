package com.kyrie.akka.sparkmasterworker.common


//worker注册信息，worker 的资源有多少
case class RegisterWorkerInfo(id:String,cpu:Int,ram:Int)

//保存到master的hashMap中，该hashMap用管理多个worker
class WorkerInfo(val id:String,val cpu :Int, val ram:Int){
  var lastHeartBeat:Long = System.currentTimeMillis()
}

//当worker 注册成功，服务器返回一个RegisteredWorkerInfo对象
case object RegisteredWorkerInfo


//worker每隔一定时间有定时器发送给自己的一个消息
case object SendHeartBeat

//worker 每隔一定时间由定时器出发， 而向master发送的协议消息
case class HeartBeat(id:String)


//master给自己发送一个触发检查超时worker的信息
case object StartTimeOutWorker

//master 给自己发消息，检测worker 对于心跳超时就删除
case object RemoveTimeOutWorker

