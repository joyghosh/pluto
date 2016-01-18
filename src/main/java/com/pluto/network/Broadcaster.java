package com.pluto.network;

import java.io.IOException;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Broadcaster {
	
	private static final Logger logger = LoggerFactory.getLogger(Broadcaster.class);
	private Socket socket;
	private final int listener_count = 2; 
	private final String host = "localhost";
	private final int port = 9000;
	
	private Broadcaster(){
		try {
			this.socket = new Socket(host, port);
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}
}
