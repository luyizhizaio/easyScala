package com.kyrie.akka.yellowchicken.common


//使用样例类作为客服端发给服务器的协议
case class ClientMessage(mes:String)



//使用样例类作为服务端发给客户端的协议
case class ServerMessage(mes:String)