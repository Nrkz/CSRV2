package org.inria.restlet.mta.backend;

import org.inria.restlet.mta.database.api.impl.*;

public class Client extends Thread{

	private Buffet buffet;
	private Stand stand;
	private Restaurant restau;
	int i;
	

	public Client (Buffet buffet, Stand stand,Restaurant restau,int i) {
		this.buffet=buffet;
		this.stand = stand;
		this.restau = restau;
		this.i=i;
	}

	public void run() {
		
		entrerRestaurant();		
		//System.out.println("Entree reussi pour thread :"+i);
		prendrePortion();
		//System.out.println("Prendre Portion :"+i);
		cuirePlat();
		mangerPlat();
		sortir();
		//System.out.println("Sortie reussi " +i);
	}
	
	public void entrerRestaurant(){		
		restau.addClients();
	}


	public void cuirePlat() {
		stand.cuissonQueue();
	}

	public void mangerPlat() {
		try {
			sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sortir() {
		restau.removeClient();
	}

	public void prendrePortion() {
		for(int i = 0; i<4 ; i++) {
			switch (i) {
			case 0:
				try {
					buffet.semPoisson.acquire();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					sleep((int)alea(300,200));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				buffet.semPoisson.release();
				int varP =(int)alea(100,0);
				if(buffet.getPoisson() - varP < 0) {
					try {
						buffet.semPoisson.acquire();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				buffet.destocker(varP,i);
			case 1:
				try {
					buffet.semViande.acquire();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					sleep((int)alea(300,200));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				buffet.semViande.release();
				int varV =(int)alea(100,0);
				if(buffet.getViande() - varV < 0) {
					try {
						buffet.semViande.acquire();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				buffet.destocker(varV,i);
			case 2 :
				try {
					buffet.semLegume.acquire();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					sleep((int)alea(300,200));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				buffet.semLegume.release();
				int varL=(int)alea(100,0);
				if(buffet.getLegume() - varL<0) {
					try {
						buffet.semLegume.acquire();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				buffet.destocker(varL,i);
			case 3:
				
				try {
					sleep((int)alea(300,200));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				buffet.semNouille.release();
				int varN = (int)alea(100,0);
				if(buffet.getNouille() - varN <0) {
					try {
						buffet.semNouille.acquire();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				buffet.destocker(varN,i);
			}
		}
	}
	public double alea(int max,int min) {
		return Math.random()* (max - min) + min;
	}
	
}
