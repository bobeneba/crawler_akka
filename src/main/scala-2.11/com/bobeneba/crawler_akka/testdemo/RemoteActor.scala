package com.bobeneba.crawler_akka.testdemo

import java.io.File
import java.net.URL

import com.typesafe.config.ConfigFactory

import akka.actor.Actor
import akka.actor.actorRef2Scala

import akka.actor.ActorSystem
import akka.actor.Props

import com.bobeneba.crawler_akka.conf.RemoteActorConf



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
    val config = RemoteActorConf getSlaveConfig
    val system = ActorSystem("RemoteSystem" , config)
    //create a remote actor from actorSystem
    val remote = system.actorOf(Props[RemoteActor], name="remote")
    println("remote is ready")


  }
}