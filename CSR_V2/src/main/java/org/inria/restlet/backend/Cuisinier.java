package org.inria.restlet.backend;

public class Cuisinier extends Thread{
	
	private Stand stand;
    
    public Cuisinier(Stand stand) {
    	this.stand = stand;
		//Mis en tant que d�mon pour que le Thread soit arr�t� quand le principal (Client) s'arr�te.
    	this.setDaemon(true);
    }
    
    //Le temps de cuisson est mis � 1 seconde.
    public void run() {
    	while(true) {
    		try {
				sleep(1000) ;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		stand.cuire();
    	}
    }
	
}
