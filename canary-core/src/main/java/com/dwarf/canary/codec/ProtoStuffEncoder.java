package com.dwarf.canary.codec;

import com.dwarf.canary.common.utils.SerializationUtil;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class ProtoStuffEncoder<T> extends MessageToByteEncoder<T> {

	@Override
	public void encode(ChannelHandlerContext context, Object object, ByteBuf byteBuf) throws Exception {
		byte[] data = SerializationUtil.serialize(object);
		byteBuf.writeInt(data.length);
		byteBuf.writeBytes(data);
	}
	

}
