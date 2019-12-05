package org.inria.restlet.backend;

public class Stand {
		
	public Stand(){}
	
	public synchronized void cuire() {
		notify();
	}
	
	public synchronized void cuissonQueue() {
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
