package org.inria.restlet.backend;


public class Employe extends Thread{

	
	private Buffet buffet;
	
	
	public Employe (Buffet buffet) {
		this.buffet=buffet;
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
				i=-1;
				break;
			}
		}
	}
}
