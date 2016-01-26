package com.pluto.network.impl;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.MulticastSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pluto.datastructure.Members;
import com.pluto.network.Listener;

public class MulticastListener implements Listener{

	private static final Logger logger = LoggerFactory.getLogger(MulticastListener.class); 
	private MulticastSocket socket;
	private Members<String> members;
	
	public MulticastListener(MulticastSocket socket) {
		this.socket = socket;
	}
	
	@Override
	public void listen() {
		
		logger.info("Listening on a multicast port.");
		
		byte[] buffer = new byte[4096];
		
		while(true){
			DatagramPacket recv = new DatagramPacket(buffer, buffer.length);
			try {
				this.socket.receive(recv);
//				this.members.add(recv.getAddress().getHostAddress()+":"+recv.getPort());
//				logger.info(this.members.toString());
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}
	}
}
