package com.atguigu.summer.framework.bean

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * @Author: lenovo
  * @Time: 2020/5/24 21:23
  * @Description:
  * @Modified By: lenovo
  */
class Task extends Serializable {
  /*
   0 hello scala
   0 hello spark
   0 flume hadoop kafka => List[String] => Map[(String, Int)]
  * */
  var data : ListBuffer[String] = null
  var logic : ListBuffer[String] => mutable.Map[String, Int] = null
  var listData : ListBuffer[mutable.Map[String, Int]] = null
  var reduce : ListBuffer[mutable.Map[String, Int]] => mutable.Map[String, Int] = null
  var result : mutable.Map[String, Int] = null
  def compute() : mutable.Map[String, Int] = {
    logic(data)
  }
  def computeReduce() : mutable.Map[String, Int] = {
    reduce(listData)
  }

  override def toString = s"Task($data, $logic, $compute)"
}
