package com.dwarf.canary.rpc.server;

import com.dwarf.canary.rpc.TcpRequest;
import com.dwarf.canary.rpc.TcpResponse;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 了解下：MessageReceived和channelRead的区别
 * @author jiyu
 *
 */
public class CanaryServerHandler extends SimpleChannelInboundHandler<TcpRequest> {

	@Override
	protected void messageReceived(ChannelHandlerContext ctx, TcpRequest msg) throws Exception {
		System.out.println(msg);
	}
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		TcpRequest request = (TcpRequest)msg;
		String interfaceName = request.getInterfaceName();
		String methodName = request.getMethodName();
		
		TcpResponse response = new TcpResponse();
		/*ProxyInvocationHandler handler = new ProxyInvocationHandler(new HelloServiceImpl());
		Object object = Proxy.newProxyInstance(HelloService.class.getClassLoader(), new Class<?>[]{HelloService.class}, handler);*/
		
		response.setRequestID(100);
		response.setResult("123");
		ctx.writeAndFlush(response);
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		System.out.println(cause);
	}
	
	

	
}
