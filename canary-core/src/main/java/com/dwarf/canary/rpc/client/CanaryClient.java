package com.dwarf.canary.rpc.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class CanaryClient {
	
	private int port;
	private String host;
	
	public CanaryClient(String host, int port){
		this.host = host;
		this.port = port;
	}
	
	public void connect(){
		EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
             .channel(NioSocketChannel.class)
             .handler(new ChannelInitializer<SocketChannel>() {
                 @Override
                 protected void initChannel(SocketChannel ch) throws Exception {
                     ChannelPipeline p = ch.pipeline();
                     
                     p.addLast();
                 }
             });

            ChannelFuture f = b.connect(this.host, this.port).sync();

            f.channel().closeFuture().sync();
        }catch(InterruptedException e){
        	e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
	}
	
	public static void main(String[] args) {
		
	}

}
