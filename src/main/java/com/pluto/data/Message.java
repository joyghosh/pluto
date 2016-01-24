package com.pluto.data;

import java.io.Serializable;

public class Message<T extends Serializable> {
	
	public static final String MULTICAST = "mcast";
	public static final String TCP = "tcp";
	public static final String CUSTOM = "custom";
	
	protected String type;
	protected T message;
	
	public Message(){ }
	
	protected Message(String type) {
		this.type = type;
	}
	
	protected Message(String type, T message){
		this.type = type;
		this.message = message;
	}
		
	public String getType(){
		return this.type;
	}
	
	public T getMessage(){
		return this.message;
	}
	
	public void setMessage(T message){
		this.message = message;
	}
}
