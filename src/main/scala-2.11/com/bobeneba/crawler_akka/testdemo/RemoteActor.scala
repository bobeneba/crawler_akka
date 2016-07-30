package com.bobeneba.crawler_akka.testdemo

import java.io.File
import java.net.URL

import com.typesafe.config.ConfigFactory

import akka.actor.Actor
import akka.actor.actorRef2Scala

import akka.actor.ActorSystem
import akka.actor.Props




/**
 * Remote actor which listens on port 5150
 */
class RemoteActor extends Actor {
  override def receive: Receive = {
    case msg: String => {
      println("remote received " + msg + " from " + sender)
      sender ! "小苹果，你好啊，我是大苹果"
    }
    case _ => println("Received unknown msg ")
  }
}

object RemoteActor {
  def main(args: Array[String]) {
    //get the configuration file from classpath
  
    val class_path =getClass.getClassLoader.getResource("").toString()
    val conf_path = class_path.substring(0,class_path.indexOf("/target") )+"/remote_application.conf"
   val url = new URL(conf_path)
    val configFile = url.getFile
    println("[configFile]::"+configFile)
    //parse the config
    val config = ConfigFactory.parseFile(new File(configFile))
    println("confilg"+ config.toString())
    //create an actor system with that config
    val system = ActorSystem("RemoteSystem" , config)
    //create a remote actor from actorSystem
    val remote = system.actorOf(Props[RemoteActor], name="remote")
    println("remote is ready")


  }
}