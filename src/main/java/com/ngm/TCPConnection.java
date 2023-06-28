package com.ngm;

import java.net.SocketTimeoutException;
import java.net.Socket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import java.io.IOException;

public class TCPConnection {

    private InetAddress addr;
    private InetSocketAddress dst;
    private int port;

    public TCPConnection(InetAddress addr, int port) {
        this.addr = addr;
        this.port = port;
        this.dst = new java.net.InetSocketAddress(this.addr, this.port);
    }

    public long ping(int timeout) throws IOException {
        Socket socket = new Socket();

        long startTime = System.currentTimeMillis();
        socket.connect(this.dst, timeout);
        long endTime = System.currentTimeMillis();
        long timeConnect = endTime - startTime;

        socket.close();

        return timeConnect;
    }
}
