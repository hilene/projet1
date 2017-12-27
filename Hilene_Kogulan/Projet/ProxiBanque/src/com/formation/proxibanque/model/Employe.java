package com.formation.proxibanque.model;

/**
 * @author Hilene - Kogulan
 * Classe heritant de Employe avec les proprietes, ID, nom et prenom 
 */
public class Employe {
	
	private int idEmploye;
	protected String nomEmploye;
	protected String prenomEmploye;
	
	//Constructeurs
	
	public Employe() {
		super();
	}	
	/**
	 * @param nomEmploye
	 */
	public Employe(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}
	/**
	 * @param idConseiller
	 * @param nomEmploye
	 */
	public Employe(int idConseiller, String nomEmploye) {
		this.idEmploye = idConseiller;
		this.nomEmploye = nomEmploye;
	}
	/**
	 * @param idEmploye
	 * @param nomEmploye
	 * @param prenomEmploye
	 */
	public Employe(int idEmploye, String nomEmploye, String prenomEmploye) {
		super();
		this.idEmploye = idEmploye;
		this.nomEmploye = nomEmploye;
		this.prenomEmploye = prenomEmploye;
	}
	
	//Getters
	public int getIdEmploye() {
		return idEmploye;
	}


	public String getNomEmploye() {
		return nomEmploye;
	}


	public String getPrenomEmploye() {
		return prenomEmploye;
	}

	//Setters
	public void setIdEmploye(int idEmploye) {
		this.idEmploye = idEmploye;
	}


	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}


	public void setPrenomEmploye(String prenomEmploye) {
		this.prenomEmploye = prenomEmploye;
	}
	
	
}
