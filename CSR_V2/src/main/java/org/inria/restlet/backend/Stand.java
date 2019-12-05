package org.inria.restlet.backend;

public class Stand {
		
	public Stand(){}
	
	
	//La cuisson contient aussi un blocage avec les cuisson des plats par le cuisinier.
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
