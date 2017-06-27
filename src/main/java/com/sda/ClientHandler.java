package com.sda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by RENT on 2017-06-27.
 */
public class ClientHandler implements Runnable {

	private final Socket socket;

	public ClientHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {



			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);

				String line = reader.readLine(); //read message from client
				System.out.println("Received: " + line);
				printWriter.println("Response from server: " + line);
				//printWriter.flush();

				printWriter.close();
				reader.close();
			} catch (IOException e) {
				System.err.println(e);
			}

	}
}
