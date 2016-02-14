package com.pluto.cluster;

import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pluto.datastructure.Members;
import com.pluto.network.Joiner;
import com.pluto.network.Listener;
import com.pluto.network.impl.MulticastJoiner;
import com.pluto.network.impl.MulticastListener;

public class MulticastNode implements INode{
	
	private static final Logger logger = LoggerFactory.getLogger(MulticastNode.class);
	private Members<InetAddress> members;
	private Joiner joiner;
	private Listener listener;
	private MulticastSocket socket;
	
	@SuppressWarnings("unchecked")
	@Override
	public void init() {
		joiner = new MulticastJoiner();
		socket = ((MulticastJoiner) joiner).getSocket();
		this.members = (Members<InetAddress>) Members.getInstance();
		listener = new MulticastListener(socket, this.members);
		
		joiner.join();
		listener.listen();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable o, Object arg) {
//		members = (Members<InetAddress>)o;
//		logger.info("Members:[");
//		for(String member:members.getMembers()){
//			logger.info("\tmember:{"+member+"}\n");
//		}
//		logger.info("]");
		logger.info(arg.toString());
	}
}