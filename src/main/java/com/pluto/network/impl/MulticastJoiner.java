package com.pluto.network.impl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pluto.network.Joiner;

public class MulticastJoiner implements Joiner {

	private static final Logger logger = LoggerFactory.getLogger(MulticastJoiner.class);
	private static final String ip = "127.0.0.1";
	private static final int port = 4001;
	
	private InetAddress group;
	private MulticastSocket socket;
	
	public MulticastJoiner() {
		
		try {	
			socket = new MulticastSocket(port);
			group = InetAddress.getByName(ip);
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}
	
	@Override
	public void join() {
		
		try {
			socket.joinGroup(group);
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public void leave() {
		
		try {
			socket.leaveGroup(group);
			socket.close();
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @return multicast socket object.
	 */
	public MulticastSocket getSocket(){
		return this.socket;
	}
}
