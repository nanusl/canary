package com.dwarf.canary.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.UUID;

import com.dwarf.canary.rpc.TcpRequest;
import com.dwarf.canary.rpc.client.CanaryClient;

public class CanaryProxy {
	
	private String host;
	private int port;
	
	public CanaryProxy(String host, int port){
		this.host = host;
		this.port = port;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T create(Class<?> interfaceClass){
		return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass}, new InvocationHandler(){

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				CanaryClient client = new CanaryClient(host, port);
				TcpRequest request = new TcpRequest();
				request.setRequestID(UUID.randomUUID().toString());
				request.setInterfaceName(method.getDeclaringClass().getName());
				request.setMethodName(method.getName());
				request.setParameterTypes(method.getParameterTypes());
				request.setParameters(args);
				Object object = client.connect(request);
				return object;
			}
			
		});
	}
	
}
