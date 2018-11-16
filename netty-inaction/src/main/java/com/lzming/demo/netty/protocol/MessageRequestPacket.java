package com.lzming.demo.netty.protocol;

import static com.lzming.demo.netty.protocol.command.Command.MESSAGE_REQUEST;

public class MessageRequestPacket extends Packet {
    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }
}
