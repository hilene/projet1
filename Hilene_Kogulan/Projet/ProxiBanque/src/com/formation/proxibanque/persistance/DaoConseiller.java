package com.formation.proxibanque.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.formation.proxibanque.model.Client;
import com.formation.proxibanque.model.Conseiller;
import com.formation.proxibanque.model.TypeClient;
import com.formation.proxibanque.util.Bdd;

public class DaoConseiller implements IDaoCrud<Conseiller> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.proxibanque.persistance.IDaoCrud#insert(java.lang.Object)
	 */
	@Override
	public void insert(Conseiller myConseiller) {
		// TODO Auto-generated method stub
		System.out.println("**** Inserstion Client *****");
		Connection c = Bdd.seConnecter();
		try {

			if (c != null) {
				PreparedStatement prep1 = c.prepareStatement(
						"insert into conseiller (nomConseiller,loginConseiller,mdpConseiller)values (?,?,?)");

				prep1.setString(1, myConseiller.getNomEmploye());
				prep1.setString(2, myConseiller.getLogin());
				prep1.setString(3, myConseiller.getMdp());

				prep1.executeUpdate();
				System.out.println("Insertion de l'employe " + myConseiller.getIdEmploye() + " "
						+ myConseiller.getNomEmploye() + " a ete effectue");

			}

		} catch (SQLException ex) {
			System.out.println("Erreur d'execution SQL");
			ex.printStackTrace();
		} finally {
			Bdd.seDeconnecter(c);
		}
	}

	@Override
	public void update(Conseiller paramT) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Conseiller selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.proxibanque.persistance.IDaoCrud#selectAll()
	 */
	@Override
	public List<Conseiller> selectAll() {
		// TODO Auto-generated method stub
		List<Conseiller> listeConseiller = new ArrayList();
		Conseiller MyConseiller;
		try {

			Connection c = Bdd.seConnecter();
			if (c != null) {
				Statement stmt = c.createStatement();
				String sql = "Select * from conseiller";

				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					MyConseiller = new Conseiller();

					listeConseiller.add(MyConseiller);
				}
				System.out.println("Les donnees relative aux clients ont ete extraites");
				Bdd.seDeconnecter(c);
			}

		} catch (SQLException ex) {
			System.out.println("Erreur d'execution SQL");
			ex.printStackTrace();
		}
		return listeConseiller;
	}

	// METHODES NON GENERIQUE

	/**
	 * Met à jour la table Client en assignant un conseiller(idConseiller) à un
	 * Client donné
	 * 
	 * @param myClientId
	 * @param idConseiller
	 */
	public void addMyClient(int myClientId, int idConseiller) {
		// TODO Auto-generated method stub
		// Affecter un idConseiller dans Client
		System.out.println("**** Mise à jour Client *****");
		Connection c = Bdd.seConnecter();
		try {
			if (c != null) {
				PreparedStatement prep1 = c.prepareStatement("update client set IdConseiller=? where idClient=?");
				prep1.setInt(1, idConseiller);
				prep1.setInt(2, myClientId);
				prep1.executeUpdate();
				System.out.println("Le client N°" + myClientId + " a ete ajoute a votre liste");
			}

		} catch (SQLException ex) {
			System.out.println("Erreur d'execution SQL");
			ex.printStackTrace();
		} finally {
			Bdd.seDeconnecter(c);
		}
	}

	/**
	 * Retourne une liste de Client sous la responsabilité du Conseiller passé en
	 * paramètre (idConseiller)
	 * 
	 * @param idConseiller
	 * @return listeClient
	 */
	public List<Client> selectMyClients(int idConseiller) {
		List<Client> listeClient = new ArrayList();
		Client Myclient;
		try {

			Connection c = Bdd.seConnecter();
			if (c != null) {
				Statement stmt = c.createStatement();
				String sql = "Select * from client where IdConseiller=" + idConseiller;

				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					Myclient = new Client(rs.getInt("idClient"), rs.getString("NomClient"),
							rs.getString("PrenomClient"), rs.getString("AdresseClient"), +rs.getInt("CodePostalClient"),
							rs.getString("VilleClient"), rs.getString("TelClient"), rs.getString("EmailClient"),
							TypeClient.valueOf(rs.getString("typeClient")));

					Myclient.setMonConseiller(rs.getInt("IdConseiller"));
					listeClient.add(Myclient);
				}
				System.out.println("Les donnees relative aux clients ont ete extraites");
				Bdd.seDeconnecter(c);
			}

		} catch (SQLException ex) {
			System.out.println("Erreur d'execution SQL");
			ex.printStackTrace();
		}
		return listeClient;

	}

	/**
	 * Retourne un conseiller si celui correspond au login et mdp passés en
	 * paramètre
	 * 
	 * @param login
	 * @param pwd
	 * @return MyConseiller
	 */
	public Conseiller findMyConseiller(String login, String pwd) {

		Conseiller MyConseiller = null;
		try {

			Connection c = Bdd.seConnecter();
			if (c != null) {
				System.out.println(login + " : " + pwd);
				PreparedStatement prep1 = c
						.prepareStatement("select * from conseiller where loginConseiller=? and mdpConseiller=?");
				prep1.setString(1, login);
				prep1.setString(2, pwd);

				ResultSet rs = prep1.executeQuery();
				rs.next();

				MyConseiller = new Conseiller(rs.getInt("idConseiller"), rs.getString("nomConseiller"),
						rs.getString("loginConseiller"), rs.getString("mdpConseiller"));

				System.out.println("Les donnees relative au Conseiller ont ete extraites");
				Bdd.seDeconnecter(c);
			}

		} catch (SQLException ex) {
			System.out.println("Erreur d'execution SQL");
			ex.printStackTrace();
		}
		return MyConseiller;

	}
}
