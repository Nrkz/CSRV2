package org.inria.restlet.mta.database.api.impl;

import java.util.Collection;

import org.inria.restlet.mta.backend.*;
import org.inria.restlet.mta.database.api.Database;

public class Restaurant implements Database{
	
	static final int CLIENTS_MAX = 25;
	private int nbClients;
	private Client[] clients;
	private Buffet buffet;
	private Stand stand;
	private Cuisinier cuisto;
	private Employe employe;
	
	public Restaurant () {
		this.buffet = new Buffet();
		this.employe = new Employe(this.buffet);
		this.stand = new Stand();
		this.cuisto = new Cuisinier(this.stand);
		this.nbClients = 0;
		this.clients = new Client[50];
		for (int i = 0; i < clients.length; i ++) {
			clients[i] = new Client(this.buffet, this.stand, this, i);
		}
	}
	
	public synchronized void addClients() {
		if(CLIENTS_MAX-nbClients<0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		nbClients++;
	}
	
	
	public synchronized void removeClient() {
		nbClients --;
		notify();	

	}

	public void run() {
		this.employe.start();
		this.cuisto.start();
		for (int i = 0; i < this.clients.length; i ++) {
			this.clients[i].start();
		}
	}
	
	@Override
	public Client getClient(int id) {
		// TODO Auto-generated method stub
		return clients[id];
	}

	
	@Override
	public Buffet getBuffet() {
		// TODO Auto-generated method stub
		return buffet;
	}
	
}
