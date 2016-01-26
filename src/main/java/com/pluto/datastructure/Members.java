package com.pluto.datastructure;

import java.util.List;
import java.util.Observable;


public final class Members<T> extends Observable{
	
	private List<T> members;
	private static Members<?> instance;
	
	private Members() {}
	
	public static <T> Members<?> getInstance(){
		
		synchronized (Members.class) {
			if(instance == null){
					instance = new Members<T>();
			}
			return instance;
		}
	}
	
	public T get(int index){
		return members.get(index);
	}
	
	public T set(int index, T element){
		T oldValue = members.set(index, element);
		setChanged();
		notifyObservers();
		return oldValue;
	}
	
	public boolean remove(T element){
		if(members.remove(element)){
			setChanged();
			notifyObservers();
			return true;
		}
		return false;
	}
	
	public List<T> getMembers(){
		return members;
	}
}