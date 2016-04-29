package com.dwarf.canary.base;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseTest {
	
	ApplicationContext cp;
	
	@Before
    public void before() {
		cp = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	}
}
