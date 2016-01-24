package com.pluto.data;

import java.io.Serializable;

public class CustomMessage<T extends Serializable> extends 
		Message<T> implements Serializable{

	private static final long serialVersionUID = -4975615520935914632L;

	public CustomMessage() {
		super(CUSTOM);
	}
	
	@Override
	public T getMessage() {
		return super.getMessage();
	}
}
