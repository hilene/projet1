package com.formation.proxibanque.model;

/**
 * @author Hilene - Kogulan
 *
 */
public class CompteEpargne extends Compte{
	private double tauxRemuneration=0.03;

	//Constructeurs
	public CompteEpargne() {
		super();
	}
	/**
	 * @param soldeCompte
	 * @param dateOuvertureCompte
	 */
	public CompteEpargne(float soldeCompte, String dateOuvertureCompte) {
		super(soldeCompte,dateOuvertureCompte);
	}
	/**
	 * @param soldeCompte
	 * @param tauxRemuneration
	 */
	public CompteEpargne(float soldeCompte, double tauxRemuneration) {
		super(soldeCompte);
		this.tauxRemuneration = tauxRemuneration;
	}
	
	/**
	 * @param soldeCompte
	 * @param dateOuvertureCompte
	 * @param tauxRemuneration
	 */
	public CompteEpargne(float soldeCompte, String dateOuvertureCompte, double tauxRemuneration) {
		super(soldeCompte,dateOuvertureCompte);
		this.tauxRemuneration = tauxRemuneration;
	}
	/**
	 * @param idCompte
	 * @param soldeCompte
	 * @param dateOuvertureCompte
	 * @param tauxRemuneration
	 */
	public CompteEpargne(int idCompte,float soldeCompte, String dateOuvertureCompte, double tauxRemuneration) {
		super(idCompte,soldeCompte,dateOuvertureCompte);
		this.tauxRemuneration = tauxRemuneration;
	}
	
	//Getters
	public double getTauxRemuneration() {
		return tauxRemuneration;
	}
	//Setters
	public void setTauxRemuneration(double tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}
	
	/* (non-Javadoc)
	 * @see com.formation.proxibanque.model.Compte#toString()
	 */
	public String toString() {
		
		return super.toString() + "\nLe taux de rémuneration est de "+this.tauxRemuneration;
	}
	
}
