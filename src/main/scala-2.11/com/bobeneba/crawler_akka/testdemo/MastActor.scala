package com.bobeneba.crawler_akka.testdemo

import com.avaje.ebean.Ebean
import com.avaje.ebean.EbeanServerFactory
import com.avaje.ebean.config.ServerConfig
import com.bobeneba.crawler_akka.properties.CrawlerProperties
import com.bobeneba.crawler_akka.ebeanServer.EbeanServerProvider

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.actorRef2Scala
import akka.event.Logging

import org.openqa.selenium.phantomjs.PhantomJSDriver
import org.openqa.selenium.phantomjs

class MyActor extends Actor{
  val log = Logging(context.system,this)
  def receive ={
    case "test" => log.info("received test") 
    case _ => log.info("received unknow messages")
  }
}

//class FirstActor extends Actor{
//  val child = context.actorOf(props)
//}


object MastActor extends App with IOTool  with EbeanServerProvider{
  val system = ActorSystem("mySystem")
  val myActor = system.actorOf(Props[MyActor],"myactor")
  val secondActor =system.actorOf(Props[MyActor],"myactor1")
  val pro =CrawlerProperties loadProperties()
  println(pro.toString())
 



val server = getDefaEbeanServer
  val sql = "select count(*) from user";
  val row = server.createSqlQuery(sql).findUnique()
  println("got"+row)
  val driver = new PhantomJSDriver()
//  val b = driver.
    try {
      driver.get("http://www.baidu.com")
      println("hhshs"+ driver.getPageSource)
      println("hahah"+driver)
    } finally {
      driver.quit()
    }
  
  
}