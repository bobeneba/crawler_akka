package com.bobeneba.crawler_akka.conf

import java.io.File
import java.net.URL
import com.typesafe.config.ConfigFactory
import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

object RemoteActorConf {
  val Logger = LoggerFactory.getLogger("RemoteBase.class");
  def getMasterConfig = {
    val class_path = getClass.getClassLoader.getResource("").toString()
    val conf_path = class_path.substring(0, class_path.indexOf("/target")) + "/remote_application.conf"
    val url = new URL(conf_path)
    val configFile = url.getFile
    //parse the config
    val config = ConfigFactory.parseFile(new File(configFile))
    Logger.info("confilg" + config.toString())
    config
  }
  def getSlaveConfig = {
    val class_path = getClass.getClassLoader.getResource("").toString()
    val conf_path = class_path.substring(0, class_path.indexOf("/target")) + "/local_application.conf"
    val url = new URL(conf_path)
    val configFile = url.getFile
    //parse the config
    val config = ConfigFactory.parseFile(new File(configFile))
    Logger.info("confilg" + config.toString())
    config
  }

}