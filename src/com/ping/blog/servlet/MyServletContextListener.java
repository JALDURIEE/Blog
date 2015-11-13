package com.ping.blog.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Modifier;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.PropertyConfigurator;

import com.google.gson.Gson;
import com.ping.blog.common.ClassFilter;
import com.ping.blog.common.ClassUtils;
import com.ping.blog.common.PropertiesUtil;

public class MyServletContextListener implements ServletContextListener {

	
	public final static String MAPPING = "MAPPING";
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
		String packageName = null;
		try {
			packageName = PropertiesUtil.getProperty("scan.package");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		InputStream is = PropertiesUtil.class.getClassLoader().getResourceAsStream("log4j.properties");
		PropertyConfigurator.configure(is);
		Map<String,Class> mapping = ClassUtils.scanPackage(packageName, new ClassFilter(){
            @Override
            public boolean accept(Class clazz) {
                return
                         !Modifier.isAbstract(clazz.getModifiers())
                      && !Modifier.isInterface(clazz.getModifiers())
                      && Modifier.isPublic(clazz.getModifiers())
                      && !Modifier.isStatic(clazz.getModifiers());
            }
         });
		sce.getServletContext().setAttribute(MAPPING, mapping);	}

}
