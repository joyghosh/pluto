package com.pluto.network.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Observable;
import java.util.Observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pluto.data.MulticastMessage;
import com.pluto.network.Joiner;

public class MulticastJoiner implements Joiner, Observer{

	private static final Logger logger = LoggerFactory.getLogger(MulticastJoiner.class);
	private static final String ip = "228.5.6.7";
	private static final int port = 4001;
	
	private InetAddress group;
	private MulticastSocket socket;
	
	public MulticastJoiner() {
		
		try {	
			this.socket = new MulticastSocket(port);
			this.group = InetAddress.getByName(ip);
//			join();
//			new Thread(new MulticastListener(getSocket())).start();
		}catch (IOException e) {
			logger.error(e.getMessage());
		}
	}
	
	@Override
	public void join() {
		
		try {
			
			this.socket.joinGroup(group);
			MulticastMessage msg = new MulticastMessage();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(msg);
			oos.flush();
			byte[] buffer = baos.toByteArray();
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length,
											InetAddress.getByName(ip), port);
			this.socket.send(packet);
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public void leave() {
		
		try {
			this.socket.leaveGroup(group);
			this.socket.close();
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @return multi-cast socket object.
	 */
	public MulticastSocket getSocket(){
		return this.socket;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
