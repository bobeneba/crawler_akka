package com.bobeneba.crawler_akka.testdemo

import akka.actor.Actor
import akka.event.Logging
import akka.actor.ActorSystem
import akka.actor.Props

import com.bobeneba.crawler_akka.properties.CrawlerProperties

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


object MastActor extends App with IOTool{
  val system = ActorSystem("mySystem")
  val myActor = system.actorOf(Props[MyActor],"myactor")
  val secondActor =system.actorOf(Props[MyActor],"myactor1")
  val pro =CrawlerProperties loadProperties()
  println(pro.toString())
  myActor ! "test"
  secondActor !"test"
}