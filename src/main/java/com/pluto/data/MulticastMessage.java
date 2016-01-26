package com.pluto.data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.pluto.util.Utility;

public class MulticastMessage extends Message<String> 
								implements Serializable{
	
	private static final long serialVersionUID = 6631363047730736319L;
	
	public MulticastMessage() {
		super(MULTICAST);
		String message = getType()+" member : "+Utility.getInetAddress().getHostAddress();
		super.message = message;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage(); 
	}
		
	private void writeObject(ObjectOutputStream ostream) throws IOException{
		ostream.defaultWriteObject();
		ostream.writeObject(getType());
		ostream.writeObject(getMessage());
	}
	
	private void readObject(ObjectInputStream istream) 
			throws ClassNotFoundException, IOException{
		istream.defaultReadObject();
		super.type = ((String) istream.readObject());
		super.setMessage((String) istream.readObject());
	}
}