package com.dwarf.canary.rpc.client;

import com.dwarf.canary.codec.ProtoStuffDecoder;
import com.dwarf.canary.codec.ProtoStuffEncoder;
import com.dwarf.canary.rpc.TcpRequest;
import com.dwarf.canary.rpc.TcpResponse;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class CanaryClient {
	
	private int port;
	private String host;
	private StringBuilder message = new StringBuilder();
	
	public CanaryClient(String host, int port){
		this.host = host;
		this.port = port;
	}
	
	public Object connect(TcpRequest request){
		EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
             .channel(NioSocketChannel.class)
             .handler(new ChannelInitializer<SocketChannel>() {
                 @Override
                 protected void initChannel(SocketChannel ch) throws Exception {
                	 ch.pipeline().addLast(new ProtoStuffEncoder(TcpRequest.class));
                	 ch.pipeline().addLast(new ProtoStuffDecoder(TcpResponse.class));
                	 ch.pipeline().addLast(new CanaryClientHandler(message));
                 }
             });

            ChannelFuture f = b.connect(this.host, this.port);
            f.channel().writeAndFlush(request);
            f.channel().closeFuture().sync();
            return message;
        }catch(InterruptedException e){
        	e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
        return null;
	}
	
	public static void main(String[] args) {
		CanaryClient client = new CanaryClient("127.0.0.1", 8089);
		TcpRequest request = new TcpRequest();
		request.setRequestID(100);
		request.setInterfaceName("HelloService");
		request.setMethodName("say");
		client.connect(request);
	}

}
