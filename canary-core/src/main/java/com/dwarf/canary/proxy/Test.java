package com.dwarf.canary.proxy;

import java.lang.reflect.Proxy;

public class Test {

	public static void main(String[] args) {
		ProxyInvocationHandler handler = new ProxyInvocationHandler(new HelloServiceImpl());
		HelloService service = (HelloService)Proxy.newProxyInstance(HelloService.class.getClassLoader(), new Class<?>[]{HelloService.class}, handler);
		service.say();
	}

}
