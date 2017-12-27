package com.formation.proxibanque.model;

import java.time.LocalDateTime;

/**
 * @author adminl
 *
 */
public class CompteCourant extends Compte {
	private float decouvertAutoriser = 1000;

	// Constructeurs
	public CompteCourant() {
		super();
	}

	/**
	 * @param soldeCompte
	 */
	public CompteCourant(float soldeCompte) {
		super(soldeCompte);
	}

	/**
	 * @param soldeCompte
	 * @param decouvertAutoriser
	 */
	public CompteCourant(float soldeCompte, float decouvertAutoriser) {
		super(soldeCompte);
		this.decouvertAutoriser = decouvertAutoriser;
	}

	/**
	 * @param soldeCompte
	 * @param dateOuvertureCompte
	 */
	public CompteCourant(float soldeCompte, String dateOuvertureCompte) {
		super(soldeCompte, dateOuvertureCompte);
	}

	/**
	 * @param soldeCompte
	 * @param dateOuvertureCompte
	 * @param decouvert
	 */
	public CompteCourant(float soldeCompte, String dateOuvertureCompte, float decouvert) {
		super(soldeCompte, dateOuvertureCompte);
		this.decouvertAutoriser = decouvert;
	}

	/**
	 * @param idCompte
	 * @param soldeCompte
	 * @param dateOuvertureCompte
	 * @param decouvert
	 */
	public CompteCourant(int idCompte, float soldeCompte, String dateOuvertureCompte, float decouvert) {

		super(idCompte, soldeCompte, dateOuvertureCompte);
		this.decouvertAutoriser = decouvert;
	}

	// Getters
	public float getDecouvertA() {
		return decouvertAutoriser;
	}

	// Setters
	public void setDecouvertA(float decouvertA) {
		this.decouvertAutoriser = decouvertA;
	}

	/* (non-Javadoc)
	 * @see com.formation.proxibanque.model.Compte#toString()
	 */
	public String toString() {
		return super.toString() + "\nLe découvert autorisé est de " + this.decouvertAutoriser;
	}

}
