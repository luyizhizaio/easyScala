package com.kyrie.function

import org.apache.spark.rdd.UnionRDD
import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.sql.SQLContext

/**
 * Created by tend on 2017/6/30.
 */
object MonitorStatTest {

  def main(args: Array[String]) {

    val path_prefix = ""

    val conf = new SparkConf()

    val sc = new SparkContext(conf)

    val sqlContext = new SQLContext(sc)
    val Array(date,cid) = args(0).split(";")
    val Array(start,end) = date.split(",")

    val cidArr = cid.split(",")
    val cid_filter = (cid:String) => if(cidArr.isEmpty || cidArr.contains(cid)) true else false


    val map =Map(1 ->"a" , 2->"b")

    import sqlContext.implicits._
    import sqlContext.sql

/*    new UnionRDD(sc,List("","").map{
      case day =>
        val path = s"$path_prefix/$day"
        sc.textFile(path).flatMap{
          line =>
            val plog = ""
            plog match{
              case Some(log) => if(cid_filter(log)) plog else None
              case _ => None
            }
        }
    }).cache.toDF().registerTempTable("t_monitor")

    sql("").map(_.mkString(",")).coalesce(1).saveAsTextFile("")


    val sql_func = (media:String, sc:String,eventType:String,idType:Int)=>{
      s"select distinct(id) from t_monitor wher mediaId=$media and sc = $sc"


    }*/





  }

}
