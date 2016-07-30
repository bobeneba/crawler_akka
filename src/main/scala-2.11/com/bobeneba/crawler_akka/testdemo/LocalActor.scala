package com.bobeneba.crawler_akka.testdemo

import java.io.File

import akka.actor.{Props, Actor, ActorSystem}
import com.typesafe.config.ConfigFactory
import akka.event.Logging
import java.net.URL

/**
 * Local actor which listens on any free port
 */
class LocalActor extends Actor{
  @throws[Exception](classOf[Exception])
   val log = Logging(context.system, this)
   def getlog = Logging(context.system, this)
  override def preStart(): Unit = {
    /*
      Connect to remote actor. The following are the different parts of actor path
      akka.tcp : enabled-transports  of remote_application.conf
      RemoteSystem : name of the actor system used to create remote actor
      127.0.0.1:5150 : host and port
      user : The actor is user defined
      remote : name of the actor, passed as parameter to system.actorOf call
     */
    val remoteActor = context.actorSelection("akka.tcp://RemoteSystem@192.168.11.9:5150/user/remote")
    log.info("That 's remote:" + remoteActor)
    remoteActor ! "大苹果 ， 你好啊， 我是邓涛的mac 小苹果"
  }
  override def receive: Receive = {

    case msg:String => {
     log.info("[got message from remote]::" + msg)
    }
  }
}



object LocalActor {
  
  def main(args: Array[String]) {
    
 
    val class_path =getClass.getClassLoader.getResource("").toString()
    val conf_path = class_path.substring(0,class_path.indexOf("/target") )+"/local_application.conf"
    val url = new URL(conf_path)
    val configFile = url.getFile
    println("[configFile]::"+configFile)
   
    val config = ConfigFactory.parseFile(new File(configFile))
    println("[config]"+config.toString)
    val system = ActorSystem("ClientSystem",config)
    val localActor = system.actorOf(Props[LocalActor], name="local")
  }


}