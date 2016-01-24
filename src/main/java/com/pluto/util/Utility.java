package com.pluto.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utility {
	
	private static final Logger logger = LoggerFactory.getLogger(Utility.class);
	
	public static InetAddress getInetAddress(){
		try {
			return InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			logger.error(e.getMessage());
		}
		return null;
	}
}
