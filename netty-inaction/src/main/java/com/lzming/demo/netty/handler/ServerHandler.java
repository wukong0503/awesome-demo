package com.lzming.demo.netty.handler;

import com.lzming.demo.netty.protocol.LoginRequestPacket;
import com.lzming.demo.netty.protocol.LoginResponsePacket;
import com.lzming.demo.netty.protocol.Packet;
import com.lzming.demo.netty.protocol.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf requestByteBuf = (ByteBuf) msg;

        Packet packet = PacketCodeC.INSTANCE.decode(requestByteBuf);

        // 业务逻辑
        if (packet instanceof LoginRequestPacket) {
            LoginRequestPacket loginRequestPacket = (LoginRequestPacket) packet;

            LoginResponsePacket responsePacket = new LoginResponsePacket();
            responsePacket.setVersion(loginRequestPacket.getVersion());
            if (valid(loginRequestPacket)) {
                responsePacket.setSuccess(true);
            } else {
                responsePacket.setReason("账号密码校验失败");
                responsePacket.setSuccess(false);
            }
            ByteBuf buf = PacketCodeC.INSTANCE.encode(ctx.alloc(), responsePacket);
            ctx.channel().writeAndFlush(buf);
        }
    }

    private boolean valid(LoginRequestPacket packet) {
        return true;
    }
}
