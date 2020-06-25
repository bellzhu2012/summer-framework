package com.atguigu.summer.framework.util

import org.apache.spark.{SparkConf, SparkContext}

/**
  * @Author: lenovo
  * @Time: 2020/6/9 10:17
  * @Description:
  * @Modified By: lenovo
  */
object EnvUtil {
    private val threadLocal = new ThreadLocal[SparkContext]

    def getEnv() = {
      var context: SparkContext = threadLocal.get()
      if (context == null) {
        val conf = new SparkConf().setMaster("local[*]").setAppName("wordcount")
        context = new SparkContext(conf)
        threadLocal.set(context)
      }
      context
    }

  def clear() = {
    threadLocal.get().stop()
    threadLocal.remove()
  }
}
