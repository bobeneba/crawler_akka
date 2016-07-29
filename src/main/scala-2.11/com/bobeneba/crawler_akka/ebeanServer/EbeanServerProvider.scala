package com.bobeneba.crawler_akka.ebeanServer
/**  
* @Title: file_name
* @Package package_name
* @Description:  provide trait EbeanServer method to get ebean.properties
*                you can add method of EbeanServer to Spread
* @author bobeneba dengtao139796@gmail.com
* @date 2016年7月28日 上午10:45:12
* @version V1.0  
*/ 
import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.config.ServerConfig
import com.avaje.ebean.EbeanServerFactory

trait EbeanServerProvider {
  /**
  * @Description: provide  what database to select, many database can use
  * you must modify ebean.properties， datasource.default=xxxxx
  * 
  */ 
  def getDefaEbeanServer: EbeanServer={
   val config = new ServerConfig();  
    // load configuration from ebean.properties
   config.loadFromProperties();
   config.setName(config.getProperties.getProperty("datasource.default"));
   config.loadFromProperties();
    // other programmatic configuration

    return EbeanServerFactory.create(config);
  }
}