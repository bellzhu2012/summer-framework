package com.atguigu.summer.framework.core

import java.net.{ServerSocket, Socket}

import com.atguigu.summer.framework.util.{EnvUtil, PropertiesUtil}
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ListBuffer

/**
  * @Author: lenovo
  * @Time: 2020/5/22 15:45
  * @Description:
  * @Modified By: lenovo
  */
trait TApplication {

  var envData: Any = null

  def start(t:String = "JDBC")(op : => Unit):Unit = {
    // 1.初始化
    if (t == "socket") {
        envData = new Socket(PropertiesUtil.getValue("server.host"), PropertiesUtil.getValue("server.port").toInt)
    }else if (t == "serverSocket"){
        envData = new ServerSocket(
          PropertiesUtil.getValue("server.port").toInt
        )
    }else if ( t == "spark" ){
        envData = EnvUtil.getEnv()
    }

      // 2.执行逻辑
      try {
        op
      } catch {
        case ex: Exception => println("业务执行失败；" + ex.getMessage)
      }


    // 服务器处理
    if (t == "socket"){
      val socket = envData.asInstanceOf[Socket]
      if(!socket.isClosed){
        socket.close()
      }
    }else if(t == "serverSocket"){
      val server = envData.asInstanceOf[ServerSocket]
      if (!server.isClosed) {
        server.close()
      }
    }else if(t == "spark"){
        EnvUtil.clear()
    }


  }
}
