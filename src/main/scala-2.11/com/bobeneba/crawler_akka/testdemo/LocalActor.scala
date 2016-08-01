package com.bobeneba.crawler_akka.testdemo
/**  
* @Title: file_name
* @Package package_name
* @Description: slave node actor 
* @author bobeneba dengtao139796@gmail.com
* @date 2016年8月1日 下午4:30:37
* @version V1.0  
*/ 
import java.io.File

import akka.actor.{ Props, Actor, ActorSystem }
import com.typesafe.config.ConfigFactory
import akka.event.Logging
import java.net.URL

import com.bobeneba.crawler_akka.conf.RemoteActorConf
import com.bobeneba.crawler_akka.properties.CrawlerProperties
/**
 * Local actor which listens on any free port
 */
class LocalActor extends Actor {
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
    val properties = CrawlerProperties.loadProperties()
    val master_ip = properties.getProperty("master_ip")
    println("a"+master_ip)
    val remoteActor = context.actorSelection("akka.tcp://RemoteSystem@"+master_ip+":5150/user/remote")
    log.info("That 's remote:" + remoteActor)
    remoteActor ! "大苹果 ， 你好啊， 我是邓涛的mac 小苹果"
  }
  override def receive: Receive = {

    case msg: String => {
      log.info("[got message from remote]::" + msg)
    }
  }
}

object LocalActor {

  def main(args: Array[String]) {
    val config = RemoteActorConf getSlaveConfig
    val system = ActorSystem("ClientSystem", config)
    val localActor = system.actorOf(Props[LocalActor], name = "local")
  }

}