package com.lzming.demo.netty;

import lombok.Data;

import static com.lzming.demo.netty.Command.LOGIN_REQUEST;

@Data
public class LoginRequestPacket extends Packet {

    private Integer userId;

    private String username;

    private String password;

    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }
}
