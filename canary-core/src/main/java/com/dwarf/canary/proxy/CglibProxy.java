package com.dwarf.canary.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {
	
	public static Object getInstance(Class clazz){
		CglibProxy proxy = new CglibProxy();
		Enhancer enHancer = new Enhancer();
		enHancer.setSuperclass(clazz);
		enHancer.setCallback(proxy);
		return enHancer.create();
	}
	
	@Override
	public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		
		return proxy.invokeSuper(object, args);
	}
	
	public static void main(String args[]){
		HelloServiceImpl service = (HelloServiceImpl)CglibProxy.getInstance(HelloServiceImpl.class);
		service.say();
		
	}

}
