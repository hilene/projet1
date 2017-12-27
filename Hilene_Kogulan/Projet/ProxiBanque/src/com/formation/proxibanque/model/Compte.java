package com.formation.proxibanque.model;

import java.time.LocalDateTime;

/**
 * @author Hilene - Kogulan
 * Classe mère de CompteCourant et CompteEpargne, contient le numéro de client associé ainsi que le solde et la date de creation
 */
public class Compte {
	protected int idCompte;
	protected float soldeCompte;
	protected String dateOuvertureCompte;

	protected int idClient;

	public Compte() {
		super();
	}

	/**
	 * @param solde
	 */
	public Compte(float solde) {
		super();
		this.soldeCompte = solde;
		this.dateOuvertureCompte = LocalDateTime.now().toString();
	}
	
	/**
	 * @param solde
	 * @param dateOuverture
	 */
	public Compte(float solde, String dateOuverture) {
		super();
		this.soldeCompte = solde;
		this.dateOuvertureCompte = dateOuverture;
	}
	/**
	 * @param idCompte
	 * @param solde
	 * @param dateOuverture
	 */
	public Compte(int idCompte, float solde, String dateOuverture) {
		super();
		this.idCompte = idCompte;
		this.soldeCompte = solde;
		this.dateOuvertureCompte = dateOuverture;		
	}
	// Getters
	public int getIdCompte() {
		return idCompte;
	}

	public float getSoldeCompte() {
		return soldeCompte;
	}

	public String getDateOuvertureCompte() {
		return dateOuvertureCompte;
	}

	public int getIdClient() {
		System.out.println(this.idClient);
		return this.idClient;
	}

	// Setters
	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	public void setDateOuvertureCompte(String dateOuvertureCompte) {
		this.dateOuvertureCompte = dateOuvertureCompte;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public void setSoldeCompte(float soldeCompte) {
		this.soldeCompte = soldeCompte;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Id Client: " + idClient + " Id Compte: "+idCompte+"\nSolde au : 11/12/2017 est de " + this.soldeCompte;

	}

}
