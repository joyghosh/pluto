package com.pluto.network.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pluto.data.Message;
import com.pluto.datastructure.Members;
import com.pluto.network.Listener;

public class MulticastListener implements Listener{

	private static final Logger logger = LoggerFactory.getLogger(MulticastListener.class); 
	private MulticastSocket socket;
	private Members<InetAddress> members;
	
	public MulticastListener(MulticastSocket socket, Members<InetAddress> members) {
		this.socket = socket;
		this.members = members;
	}
	
	@Override
	public void listen() {
		
		logger.info("Listening on a multicast port.");
		
		byte[] buffer = new byte[4096];
		DatagramPacket recv = new DatagramPacket(buffer, buffer.length);
		while(true){
			
			try {
				this.socket.receive(recv);
				ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
				ObjectInputStream ois = new ObjectInputStream(bais);
				Message<?> m = (Message<?>)ois.readObject();
				
				switch (m.getType()) {
					case Message.MULTICAST:	
											members.add(recv.getAddress());
											break;
					case Message.TCP:		
											break;
					case Message.CUSTOM:    
											break;
					default:				logger.warn("message type not supported.");
											break;
				}
			} catch (IOException | ClassNotFoundException e) {
				logger.error(e.getMessage());
			}
		}
	}
}
