package com.kyrie.collections1

/**
 * Created by Kyrie on 2019/1/13.
 */
object MatchIfDemo {

  def main(args: Array[String]) {

    for(ch <- "+-!"){

      var sign = 0
      var digit = 0
      ch match {
        case '+' => sign =1
        case '-' => sign = -1
        case _ if ch.toString.equals("3") => digit =3
        //case _ if (ch > 1110 || ch < 120) => println(" ch>10 ")
        case _ => sign =2
      }

      println( ch +" "+sign +" "+digit)

    }


  }

}
