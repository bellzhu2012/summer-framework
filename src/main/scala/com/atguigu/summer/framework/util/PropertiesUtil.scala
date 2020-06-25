package com.atguigu.summer.framework.util

import java.util.ResourceBundle

/**
  * @Author: lenovo
  * @Time: 2020/5/24 20:54
  * @Description:
  * @Modified By: lenovo
  */
object PropertiesUtil {
  // 绑定配置文件,ResourceBundle专门读取配置文件，不需要加后缀名
  /*
    server.cluster = server1 server2
    server1.port=9999
    server1.host=localhost
    server2.port=8888
    server2.host=localhost
  * */
  val bundle: ResourceBundle = ResourceBundle.getBundle("summer")
  def getValue(key:String):String = {
    bundle.getString(key)
  }

}
