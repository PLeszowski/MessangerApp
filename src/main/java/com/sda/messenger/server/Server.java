package com.sda.messenger.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.sda.messenger.Connection;

public class Server {

	public static void main(String[] args) throws IOException {
		int port = 4444;

		ServerSocket serverSocket = new ServerSocket(port);

		Socket socket = serverSocket.accept();

		Connection connection = new Connection(socket);
		connection.start();
	}
}