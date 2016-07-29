package com.bobeneba.crawler_akka.properties
/**  
* @Package package_name
* @Description: 对crawler_akka爬虫配置进行读取，提供给 com.bobeneba.crawler_akka.testdemo MastActor 使用
* @author bobeneba dengtao139796@gmail.com
* @date 2016年7月26日 下午7:02:34
* @version V1.0  
*/ 
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

object CrawlerProperties {
   def loadProperties(): Properties ={
     var properties = new Properties()
     try {
       val input = new FileInputStream("crawler_akka.properties");
       properties.load(input)
       input.close()
     } catch {
       case t: Throwable => t.printStackTrace() // TODO: handle error
     }
       
     
     properties
   }
}