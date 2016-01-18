package com.pluto.network.impl;

import java.net.MulticastSocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pluto.network.Listener;

public class MulticastListener implements Listener, Runnable{

	private static final Logger logger = LoggerFactory.getLogger(MulticastListener.class); 
	private MulticastSocket socket;
	
	public MulticastListener(MulticastSocket socket) {
		this.socket = socket;
	}
	
	@Override
	public void listen() {
		
	}

	@Override
	public void run() {
		listen();
	}

}
