package org.inria.restlet.backend;

public class Cuisinier extends Thread{
	
	private Stand stand;
    
    public Cuisinier(Stand stand) {
    	this.stand = stand;
		//Mis en tant que démon pour que le Thread soit arrêté quand le principal (Client) s'arrête.
    	this.setDaemon(true);
    }
    
    //Le temps de cuisson est mis à 1 seconde.
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
