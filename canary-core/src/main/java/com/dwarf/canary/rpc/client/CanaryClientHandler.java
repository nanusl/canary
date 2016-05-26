package com.dwarf.canary.rpc.client;

import com.dwarf.canary.rpc.TcpResponse;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class CanaryClientHandler extends SimpleChannelInboundHandler<TcpResponse> {
	
	public StringBuilder message;
	
	public CanaryClientHandler(StringBuilder result){
		this.message = result;
	}
	
	@Override
	protected void messageReceived(ChannelHandlerContext ctx, TcpResponse msg) throws Exception {
		System.out.println(msg);
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
	}
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		TcpResponse response = (TcpResponse)msg;
		message.append(response.getResult());
		ctx.close();
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		System.out.println(cause);
	}

}
