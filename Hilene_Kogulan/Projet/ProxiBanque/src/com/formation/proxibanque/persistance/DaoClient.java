package com.formation.proxibanque.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.formation.proxibanque.model.Client;
import com.formation.proxibanque.model.TypeClient;
import com.formation.proxibanque.util.Bdd;

public class DaoClient implements IDaoCrud<Client> {
	HashMap<Integer, Client> listesClient = new HashMap<Integer, Client>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.proxibanque.persistance.IDaoCrud#insert(java.lang.Object)
	 */
	@Override
	public void insert(Client myClient) {
		// TODO Auto-generated method stub
		// listesClient.put(myClient.getIdClient(), myClient);

		System.out.println("**** Inserstion Client *****");
		Connection c = Bdd.seConnecter();
		try {

			if (c != null) {
				PreparedStatement prep1 = c.prepareStatement(
						"insert into client (NomClient,PrenomClient,AdresseClient,CodePostalClient,VilleClient,TelClient,EmailClient,typeClient,IdConseiller)values (?,?,?,?,?,?,?,?,?)");

				prep1.setString(1, myClient.getNomClient());
				prep1.setString(2, myClient.getPrenomClient());
				prep1.setString(3, myClient.getAdresseClient());
				prep1.setInt(4, myClient.getCodePostalClient());
				prep1.setString(5, myClient.getVilleClient());
				prep1.setString(6, myClient.getTelClient());
				prep1.setString(7, myClient.getEmailClient());
				prep1.setString(8, String.valueOf(myClient.getTyClient()));
				prep1.setInt(9, myClient.getIdConseiller());

				prep1.executeUpdate();
				System.out.println("Insertion du client " + myClient.getNomClient() + " " + myClient.getPrenomClient()
						+ " a ete effectue");

			}

		} catch (SQLException ex) {
			System.out.println("Erreur d'execution SQL");
		} finally {
			Bdd.seDeconnecter(c);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.proxibanque.persistance.IDaoCrud#update(java.lang.Object)
	 */
	@Override
	public void update(Client myClient) {
		// TODO Auto-generated method stub
		// listesClient.replace(myClient.getIdClient(), myClient);
		System.out.println("**** Mise à jour Client *****");
		Connection c = Bdd.seConnecter();
		try {
			if (c != null) {
				PreparedStatement prep1 = c.prepareStatement(
						"update client set NomClient=?,PrenomClient=?,AdresseClient=?,CodePostalClient=?,VilleClient=?,TelClient=?,EmailClient=?,typeClient=?,IdConseiller=? where idClient=?");
				prep1.setString(1, myClient.getNomClient());
				prep1.setString(2, myClient.getPrenomClient());
				prep1.setString(3, myClient.getAdresseClient());
				prep1.setInt(4, myClient.getCodePostalClient());
				prep1.setString(5, myClient.getVilleClient());
				prep1.setString(6, myClient.getTelClient());
				prep1.setString(7, myClient.getEmailClient());
				prep1.setString(8, String.valueOf(myClient.getTyClient()));
				prep1.setInt(9, myClient.getIdConseiller());
				prep1.setInt(10, myClient.getIdClient());
				prep1.executeUpdate();
				System.out.println("La mise à jour du client " + myClient.getNomClient() + " "
						+ myClient.getPrenomClient() + " a ete effectue");
			}

		} catch (SQLException ex) {
			System.out.println("Erreur d'execution SQL");
		} finally {
			Bdd.seDeconnecter(c);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.proxibanque.persistance.IDaoCrud#delete(int)
	 */
	@Override
	public void delete(int idClient) {
		// TODO Auto-generated method stub
		// listesClient.remove(idClient);
		System.out.println("**** Supprimer Client *****");
		Connection c = Bdd.seConnecter();
		try {
			if (c != null) {
				PreparedStatement prep1 = c.prepareStatement("delete from client where idClient=?");
				prep1.setInt(1, idClient);
				prep1.executeUpdate();
				System.out.println("Suppression du client N°" + idClient + " a ete effectue");
			}

		} catch (SQLException ex) {
			System.out.println("Erreur d'execution SQL");
		} finally {
			Bdd.seDeconnecter(c);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.proxibanque.persistance.IDaoCrud#selectById(int)
	 */
	@Override
	public Client selectById(int idClient) {
		// TODO Auto-generated method stub
		System.out.println("**** Selectionner Client *****");
		Connection c = Bdd.seConnecter();
		Client Myclient = null;
		try {
			if (c != null) {
				PreparedStatement prep1 = c.prepareStatement("select * from client where idClient=?");
				prep1.setInt(1, idClient);
				ResultSet rs = prep1.executeQuery();
				rs.next();

				Myclient = new Client(rs.getInt("idClient"), rs.getString("NomClient"), rs.getString("PrenomClient"),
						rs.getString("AdresseClient"), +rs.getInt("CodePostalClient"), rs.getString("VilleClient"),
						rs.getString("TelClient"), rs.getString("EmailClient"),
						TypeClient.valueOf(rs.getString("typeClient")));

				Myclient.setMonConseiller(rs.getInt("IdConseiller"));
			}

		} catch (SQLException ex) {
			System.out.println("Erreur d'execution SQL");
		} finally {
			Bdd.seDeconnecter(c);
		}
		return Myclient;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.proxibanque.persistance.IDaoCrud#selectAll()
	 */
	@Override
	public List<Client> selectAll() {
		// TODO Auto-generated method stub
		List<Client> listeClient = new ArrayList();
		Client Myclient;
		try {

			Connection c = Bdd.seConnecter();
			if (c != null) {
				Statement stmt = c.createStatement();
				String sql = "Select * from client";

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

}
