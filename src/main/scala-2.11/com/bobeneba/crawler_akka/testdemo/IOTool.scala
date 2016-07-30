package com.bobeneba.crawler_akka.testdemo

/**  
* @Title: file_name
* @Package package_name
* @Description: 
* @author bobeneba dengtao139796@gmail.com
* @date 2016年7月26日 下午3:57:29
* @version V1.0  
*/ 

import java.util.Properties
import java.io.FileInputStream

trait IOTool {
  /**
  * @Description: from dir:/crawler_akka/ read  crawler_akka.properties file
  */ 
  def fileload:Unit = {
    
      
      
//    val properties = new Properties()
// 
//    val path = FileOperator.getClass.getClassLoader.getResourceAsStream("crawler_akka.properties")
//    properties.load(new FileInputStream(path))
//    println(properties.getProperty("ddd"))//读取键为ddd的数据的值
//    println(properties.getProperty("ddd","没有值"))//如果ddd不存在,则返回第二个参数
//    properties.setProperty("ddd","123")//添加或修改属性值
  }
}