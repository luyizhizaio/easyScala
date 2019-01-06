package com.kyrie.oop

/**
 * Created by Kyrie on 2019/1/6.
 */
object ChildJoinGame {


  def main(args: Array[String]) {



    val child1 = new Child("star")
    val child2 = new Child("xj")
    var child3 = new Child("Penny")

    Child.joinGame(child1)
    Child.joinGame(child2)
    Child.joinGame(child3)
    Child.showNum



  }




}


class Child(cName:String){
  var name = cName
}

object Child{


  var totalChildNum = 0

  def joinGame(child :Child):Unit={

    printf("%s 小孩加入游戏\n" ,child.name)
    totalChildNum +=1

  }


  def showNum={

    printf("当前有%d 小孩玩游戏", totalChildNum)
  }
}