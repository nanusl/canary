package com.dwarf.canary.proxy;

import com.dwarf.canary.rpc.TcpRequest;

public class Test {

	public static void main(String[] args) {
		ProxyInvocationHandler handler = new ProxyInvocationHandler(new HelloServiceImpl());
		TcpRequest request = new TcpRequest();
		request.setRequestID("100");
		request.setInterfaceName("HelloService");
		request.setMethodName("say");
		
		CanaryProxy proxy = new CanaryProxy("127.0.0.1", 8089); 
		HelloService service = proxy.create(HelloService.class);
		System.out.println(service.say());
	}

}
