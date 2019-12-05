package org.inria.restlet.backend;

import java.util.concurrent.Semaphore;

public class Buffet {

	private int poissoncru;
	private int viandecru;
	private int legumecru;
	private int nouilles;
	// Cr�ation des s�maphores pour les diff�rents bacs afin d'�viter un interblocage entre les bacs.
	Semaphore semPoisson;
	Semaphore semViande;
	Semaphore semLegume;
	Semaphore semNouille;
	
	public Buffet () {
		this.poissoncru = 1000;
		this.viandecru = 1000;
		this.legumecru = 1000;
		this.nouilles = 1000;
		this.semPoisson = new Semaphore(1);
		this.semViande = new Semaphore(1);
		this.semLegume = new Semaphore(1);
		this.semNouille = new Semaphore(1);	
	}
	
	public int getPoisson() {
		return this.poissoncru;
	}
	
	public int getViande() {
		return this.viandecru;
	}
	
	public int getLegume() {
		return this.legumecru;
	}
	
	public int getNouille() {
		return this.nouilles;
	}

	//La fonction stocker est utilis�e par l'employ� pour restocker les bacs. i=0 est le Poisson
	//i=1 est la viande i=2 sont les l�gumes i =3 correspond aux nouilles.
	public void stocker(int i) {
		switch (i) {
			case 0:
				this.poissoncru = 1000;
				break;
			case 1:
				this.viandecru = 1000;
				break;
			case 2:
				this.legumecru = 1000;
				break;
			case 3:
				this.nouilles = 1000;
				break;
		}
	}
	
	//Pareil que stocker mais pour le Client.
	public void destocker(int qt, int i) {
		switch (i) {
			case 0:
				this.poissoncru = getPoisson() - qt;
				//System.out.println("Qt Poisson :" + this.poissoncru);
				break;
			case 1:
				this.viandecru = getViande() - qt;
				//System.out.println("Qt Viande :" + this.viandecru);
				break;
			case 2:
				this.legumecru = getLegume() - qt;
				//System.out.println("Qt Legume :" + this.legumecru);
				break;
			case 3:
				this.nouilles = getNouille()- qt;
				//System.out.println("Qt Nouille :" +this.nouilles);
				break;
		}
	}
}
