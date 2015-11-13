package com.ping.blog.test;

import java.lang.reflect.Modifier;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.ping.blog.common.ClassFilter;
import com.ping.blog.common.ClassUtils;

public class MvcTest {
	
	private ClassFilter filter;
	
	@Before
	public void setUp(){
		
		filter = new ClassFilter(){
            @Override
            public boolean accept(Class clazz) {
                return
                         !Modifier.isAbstract(clazz.getModifiers())
                      && !Modifier.isInterface(clazz.getModifiers())
                      && Modifier.isPublic(clazz.getModifiers())
                      && !Modifier.isStatic(clazz.getModifiers());
            }
         };
		
	}
	
	@Test
	public void scan(){
		
	   Map<String,Class> mapping = ClassUtils.scanPackage("com", filter);
       for(Map.Entry<String, Class> entry:mapping.entrySet()){
    	  System.out.println("key----->"+ entry.getKey()+" value------>"+entry.getValue());
       }
		
		
	}

}
