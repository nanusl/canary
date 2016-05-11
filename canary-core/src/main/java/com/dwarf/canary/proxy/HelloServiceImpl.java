package com.dwarf.canary.proxy;

public class HelloServiceImpl implements HelloService, java.io.Serializable {

	@Override
	public void say() {
		System.out.println("Hello world!!");
	}

}
