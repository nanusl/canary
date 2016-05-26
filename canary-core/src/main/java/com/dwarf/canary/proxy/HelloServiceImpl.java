package com.dwarf.canary.proxy;

public class HelloServiceImpl implements HelloService, java.io.Serializable {

	@Override
	public String say() {
		System.out.println("Hello world!!");
		return "Hello world!!";
	}

}
