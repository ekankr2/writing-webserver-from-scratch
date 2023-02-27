package com.eddicorp;

import com.eddicorp.http.HttpConnectionHandler;

import java.net.ServerSocket;
import java.net.Socket;

public class WebApplication {

    public static void main(String[] args) throws Exception {
        // index.html 브라우저에 띄워보기
        final ServerSocket serverSocket = new ServerSocket(8080);
        Socket connection;

        while ((connection = serverSocket.accept()) != null) {
            HttpConnectionHandler httpConnectionHandler = new HttpConnectionHandler(connection);
            httpConnectionHandler.handleHttp();
        }
    }
}
