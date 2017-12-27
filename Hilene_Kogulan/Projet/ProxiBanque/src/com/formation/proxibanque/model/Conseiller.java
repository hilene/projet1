package com.formation.proxibanque.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hilene - Kogulan
 *
 */
public class Conseiller extends Employe{
	
	private String login;
	private String mdp;	

	List<Client> listeClients = new ArrayList<Client>();
	private Gerant monGerant;
	
	public Conseiller() {
		super();
	}

	public Conseiller(String nomEmploye, String login, String mdp) {
		// TODO Auto-generated constructor stub
		super(nomEmploye);
		this.login = login;
		this.mdp = mdp;	
	}
	public Conseiller(int idConseiller, String nomEmploye, String login, String mdp) {
		// TODO Auto-generated constructor stub
		super(idConseiller,nomEmploye);
		this.login = login;
		this.mdp = mdp;	
	}
	
	// Getters et setters
	public Gerant getMonGerant() {
		return monGerant;
	}

	public void setMonGerant(Gerant monGerant) {
		this.monGerant = monGerant;
	}

	public List<Client> getListeClients() {
		return listeClients;
	}

	public void setListeClients(List<Client> listeClients) {
		this.listeClients = listeClients;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	
}
