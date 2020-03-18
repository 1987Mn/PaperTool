package com.lzw.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SM {

	public static Object getBean(Class cla) {
        ApplicationContext ap=new ClassPathXmlApplicationContext(
        		new String[] {"applicationContext-dao.xml","applicationContext-service.xml"});
        return ap.getBean(cla);
	}
}
