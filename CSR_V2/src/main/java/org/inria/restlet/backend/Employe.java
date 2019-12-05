package org.inria.restlet.backend;


public class Employe extends Thread{

	
	private Buffet buffet;
	
	
	public Employe (Buffet buffet) {
		this.buffet=buffet;
		//Mis en tant que d�mon pour que le Thread soit arr�t� quand le principal (Client) s'arr�te.
		this.setDaemon(true);
	}
	
	public void run(){

		for(int i =0;i<4;i++) {

			switch (i) {
			
			case 0:
				if(buffet.getPoisson() < 100) {
					buffet.stocker(i);
					buffet.semPoisson.release(0);
				}
				break;
			case 1:
				if(buffet.getViande() < 100) {
					buffet.stocker(i);
					buffet.semViande.release(0);
				}
				break;
			case 2:
				if(buffet.getLegume() < 100) {
					buffet.stocker(i);
					buffet.semLegume.release(0);
				}
				break;
			case 3:
				if(buffet.getNouille() < 100) {
					buffet.stocker(i);
					buffet.semNouille.release(0);
				}
				//On retourne � -1 pour obtenir une boucle infinie.
				i=-1;
				break;
			}
		}
	}
}
