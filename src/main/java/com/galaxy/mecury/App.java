package com.galaxy.mecury;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

public class App {
    public static void main(String[] args) {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(9999);
        Connector conn = tomcat.getConnector(); // Tomcat 9.0 必须调用 Tomcat#getConnector() 方法之后才会监听端口
        System.out.println("连接器设置完成: " + conn);

        try {
            tomcat.addWebapp("/", "D:\\boot");
            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}