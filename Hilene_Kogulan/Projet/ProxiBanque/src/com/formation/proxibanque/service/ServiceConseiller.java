package com.formation.proxibanque.service;

import java.util.List;

import com.formation.proxibanque.model.Client;
import com.formation.proxibanque.model.Compte;
import com.formation.proxibanque.model.CompteCourant;
import com.formation.proxibanque.model.CompteEpargne;
import com.formation.proxibanque.model.Conseiller;
import com.formation.proxibanque.persistance.DaoCompteCourant;
import com.formation.proxibanque.persistance.DaoCompteEpargne;
import com.formation.proxibanque.persistance.DaoConseiller;

/**
 * @author Hilene - Kogulan
 *
 */
public class ServiceConseiller implements IServiceCrud<Conseiller> {

	DaoConseiller daoCons = new DaoConseiller();

	@Override
	public void insert(Conseiller myConseiller) {
		daoCons.insert(myConseiller);
	}

	@Override
	public void delete(int idClient) {
		daoCons.delete(idClient);
	}

	@Override
	public void update(Conseiller myConseiller) {
		daoCons.update(myConseiller);
	}

	@Override
	public Conseiller selectById(int idConseiller) {
		return daoCons.selectById(idConseiller);
	}

	@Override
	public List<Conseiller> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	// METHODE NON GENERIQUE
	public void addMyClient(int myClientId, int idConseiller) {
		daoCons.addMyClient(myClientId, idConseiller);
	}

	public List<Client> selectMyClients(int idConseiller) {
		return daoCons.selectMyClients(idConseiller);
	}

	public Conseiller findMyConseiller(String login, String pwd) {
		return daoCons.findMyConseiller(login, pwd);
	}

	/**
	 * Prend en parametre identifiant d'un compte courant, d'un courant epargne et
	 * le montant du virement Analyse les contraintes en fonction du type de Client
	 * (Entreprise ou particulier) si la transaction peut aboutir
	 * 
	 * @param idCompteClient1
	 * @param idCompteClient2
	 * @param montant
	 */
	public void transfer(int idCompteCourant, int idCompteEpargne, float montant) {
		/*
		 * CompteCourant c1 = cc1.getSolde();
		 * 
		 * 
		 * double soldeClient1 = cc1.getSolde(); double soldeClient2 = cc2.getSolde();
		 * 
		 * String typeClient = c1.getTypeClient(); System.out.println(typeClient);
		 * 
		 * if (typeClient.equals("particulier")) { if ((soldeClient1 - montant) > -1000)
		 * { soldeClient1 -= montant; soldeClient2 += montant;
		 * System.out.println("Le virement a bien �t� effectu�."); transac = true;
		 * 
		 * } else { System.out.println("le virement exc�de le d�couvert autoris� ");
		 * 
		 * } } else if (typeClient.equals("entreprise")) { if ((soldeClient1 - montant)
		 * > -50000) { soldeClient1 -= montant; soldeClient2 += montant;
		 * System.out.println("Le virement a bien �t� effectu�."); transac = true; }
		 * else { System.out.println("le virement exc�de le d�couvert autoris� ");
		 * 
		 * } }
		 * 
		 * if (transac == true) { cc1.setSolde(soldeClient1);
		 * cc2.setSolde(soldeClient2); c.updateClient(CBClient1, c1);
		 * c.updateClient(CBClient2, c2); }
		 */
	}

	/**
	 * le capital empruntable la m�thode permet de calculer le capital empruntable �
	 * partir d'une mensualit� donn�e, d'un taux d'emprunt et d'une dur�e d'emprunt
	 * en moi
	 * 
	 * @param mensualit�
	 * @param tauxEmprunt
	 * @param nbMois
	 * @return
	 * 
	 */
	public double interetCalculCapital(double mensualite, double tauxEmprunt, double nbMois) {

		double empruntClient = (mensualite * (1 - Math.pow(1 + tauxEmprunt / 12, -nbMois))) / (tauxEmprunt / 12);

		System.out.println("Le capital empruntable est de " + (int) empruntClient + " euros pour une mensualit� de "
				+ mensualite + " euros \n � un taux d'int�r�t de " + tauxEmprunt + " pour une p�riode de "
				+ (int) nbMois + " mois.");
		return empruntClient;
	}

	/**
	 * la mensualit� payable par le client la m�thode permet de calculer la
	 * mensualit� liss�e � partir d'un capital emprunt� donn�, d'un taux d'emprunt
	 * donn� et d'une dur�e d'emprunt en mois
	 * 
	 * @param empruntClient
	 * @param tauxEmprunt
	 * @param nbMois
	 * @return mensualite
	 */
	public double interetCalculMensualite(double empruntClient, double tauxEmprunt, double nbMois) {

		double mensualite = (empruntClient * tauxEmprunt / 12) / (1 - Math.pow(1 + tauxEmprunt / 12, -nbMois));
		System.out.println("Les mensualit�s sont de  " + (int) mensualite + " euros par mois pour un emprunt de "
				+ empruntClient + " euros \n � un taux d'int�r�t de " + tauxEmprunt + " pour une p�riode de "
				+ (int) nbMois + " mois.");

		return mensualite;

	}

}
