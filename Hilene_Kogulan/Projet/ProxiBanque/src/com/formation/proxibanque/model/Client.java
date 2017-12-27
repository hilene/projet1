package com.formation.proxibanque.model;

/**
 * @author Kogulan - Hilene
 * @version 2
 * Cette classe regroupe les données relatives au client, deux
 *          variables statics permettent de distiunguer le type de client :
 *          Particulier ou Entreprise, la classe dispose en attribut de
 *          CompteCourant et CompteEpargne afin d'aggreger cette classe aux
 *          comptes bancaire.
 */

public class Client {

	private int idClient;
	private String nomClient;
	private String prenomClient;
	private String adresseClient;
	private int codePostalClient;
	private String villeClient;
	private String telClient;
	private String emailClient;

	private TypeClient tyClient;

	private int idConseiller;

	public Client() {
		super();
	}

	/**
	 * @param idClient
	 * @param nomClient
	 * @param prenomClient
	 */
	public Client(int idClient, String nomClient, String prenomClient) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
	}

	/**
	 * @param nomClient
	 * @param prenomClient
	 * @param adresseClient
	 * @param codePostalClient
	 * @param villeClient
	 * @param telClient
	 * @param emailClient
	 * @param ty
	 */
	public Client(String nomClient, String prenomClient, String adresseClient, int codePostalClient, String villeClient,
			String telClient, String emailClient, TypeClient ty) {
		super();
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.adresseClient = adresseClient;
		this.codePostalClient = codePostalClient;
		this.villeClient = villeClient;
		this.telClient = telClient;
		this.emailClient = emailClient;
		this.tyClient = ty;
	}

	/**
	 * @param idClient
	 * @param nomClient
	 * @param prenomClient
	 * @param adresseClient
	 * @param codePostalClient
	 * @param villeClient
	 * @param telClient
	 * @param emailClient
	 * @param ty
	 */
	public Client(int idClient, String nomClient, String prenomClient, String adresseClient, int codePostalClient,
			String villeClient, String telClient, String emailClient, TypeClient ty) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.adresseClient = adresseClient;
		this.codePostalClient = codePostalClient;
		this.villeClient = villeClient;
		this.telClient = telClient;
		this.emailClient = emailClient;
		this.tyClient = ty;
	}

	// Getters

	public int getIdClient() {
		return idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public String getPrenomClient() {
		return prenomClient;
	}

	public String getAdresseClient() {
		return adresseClient;
	}

	public int getCodePostalClient() {
		return codePostalClient;
	}

	public String getVilleClient() {
		return villeClient;
	}

	public String getTelClient() {
		return telClient;
	}

	public String getEmailClient() {
		return emailClient;
	}

	public TypeClient getTyClient() {
		return tyClient;
	}

	public int getIdConseiller() {
		return this.idConseiller;
	}

	// SETTERS
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}

	public void setCodePostalClient(int codePostalClient) {
		this.codePostalClient = codePostalClient;
	}

	public void setVilleClient(String villeClient) {
		this.villeClient = villeClient;
	}

	public void setTelClient(String telClient) {
		this.telClient = telClient;
	}

	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}

	public void setTyClient(TypeClient tyClient) {
		this.tyClient = tyClient;
	}

	public void setMonConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}

	// Méthodes
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nomClient=" + nomClient + ", adresseClient=" + adresseClient
				+ ", codePostalClient=" + codePostalClient + ", villeClient=" + villeClient + ", telClient=" + telClient
				+ ", emailClient=" + emailClient + ", idConseiller=" + idConseiller + "]";
	}

}
