package com.pluto.cluster;

import java.net.MulticastSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import com.pluto.network.Joiner;
import com.pluto.network.Listener;
import com.pluto.network.impl.MulticastJoiner;
import com.pluto.network.impl.MulticastListener;

public class MulticastNode implements INode, Observer {

	private List<String> members;
	private Joiner joiner;
	private Listener listener;
	private MulticastSocket socket;
	
	@Override
	public void init() {
		members = new ArrayList<String>();
		joiner = new MulticastJoiner();
		socket = ((MulticastJoiner) joiner).getSocket();
		listener = new MulticastListener(socket);
		
		joiner.join();
		listener.listen();
	}

	@Override
	public void update(Observable o, Object arg) {
	}
}