package com.dwarf.canary.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.dwarf.canary.rpc.TcpRequest;
import com.dwarf.canary.rpc.client.CanaryClient;

public class Test {

	public static void main(String[] args) {
		ProxyInvocationHandler handler = new ProxyInvocationHandler(new HelloServiceImpl());
		TcpRequest request = new TcpRequest();
		request.setRequestID(100);
		request.setInterfaceName("HelloService");
		request.setMethodName("say");
		
		
		
		HelloService service = (HelloService)Proxy.newProxyInstance(HelloService.class.getClassLoader(), new Class<?>[]{HelloService.class}, new InvocationHandler(){

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				CanaryClient client = new CanaryClient("127.0.0.1", 8089);
				Object object = client.connect(request);
				return object.toString();
			}
			
		});
		System.out.println(service.say());
	}

}
