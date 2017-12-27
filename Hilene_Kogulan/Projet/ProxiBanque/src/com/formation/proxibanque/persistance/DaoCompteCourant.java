package com.formation.proxibanque.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.formation.proxibanque.model.CompteCourant;
import com.formation.proxibanque.util.Bdd;

public class DaoCompteCourant implements IDaoCrud<CompteCourant> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.proxibanque.persistance.IDaoCrud#insert(java.lang.Object)
	 */
	@Override
	public void insert(CompteCourant myCompteCourant) {
		// TODO Auto-generated method stub
		System.out.println("**** Inserstion Compte Courant *****");
		Connection c = Bdd.seConnecter();
		try {

			if (c != null) {
				System.out.println(myCompteCourant.getSoldeCompte() + "," + myCompteCourant.getDateOuvertureCompte()
						+ "," + myCompteCourant.getIdClient() + "," + myCompteCourant.getDecouvertA());
				PreparedStatement prep1 = c.prepareStatement(
						"insert into comptecourant (soldeCompte,dateOuvertureCompte,idClient,decouvertAutoriser)values (?,?,?,?)");

				prep1.setFloat(1, myCompteCourant.getSoldeCompte());
				prep1.setString(2, myCompteCourant.getDateOuvertureCompte());
				prep1.setInt(3, myCompteCourant.getIdClient());
				prep1.setFloat(4, myCompteCourant.getDecouvertA());

				prep1.executeUpdate();
				System.out.println("Ajout d'un compte courant pour le client " + myCompteCourant.getIdClient()
						+ " a ete effectue");

			}

		} catch (SQLException ex) {
			System.out.println("Erreur d'execution SQL");
			ex.printStackTrace();
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
	public void update(CompteCourant myCompteCourant) {
		// TODO Auto-generated method stub
		System.out.println("**** Mise à jour Compte Courant *****");
		Connection c = Bdd.seConnecter();
		try {

			if (c != null) {
				PreparedStatement prep1 = c.prepareStatement(
						"update compteCourant set soldeCompte=?,dateOuvertureCompte=?,decouvertAutoriser=? where idCompte=?");

				prep1.setFloat(1, myCompteCourant.getSoldeCompte());
				prep1.setString(2, myCompteCourant.getDateOuvertureCompte());
				prep1.setFloat(3, myCompteCourant.getDecouvertA());
				prep1.setInt(4, myCompteCourant.getIdCompte());

				prep1.executeUpdate();
				System.out.println("Le compte courant N°" + myCompteCourant.getIdCompte() + " du client "
						+ myCompteCourant.getIdClient() + " a ete mis à jour");
			}

		} catch (SQLException ex) {
			System.out.println("Erreur d'execution SQL");
			ex.printStackTrace();
		} finally {
			Bdd.seDeconnecter(c);
		}
	}

	@Override
	public void delete(int idCompteCourant) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.proxibanque.persistance.IDaoCrud#selectById(int)
	 */
	@Override
	public CompteCourant selectById(int idCompteCourant) {
		// TODO Auto-generated method stub
		System.out.println("**** Selectionner Compte Courant *****");
		Connection c = Bdd.seConnecter();
		CompteCourant MyCompteCourant = null;
		try {
			if (c != null) {
				PreparedStatement prep1 = c.prepareStatement("select * from compteCourant where idCompte=?");
				prep1.setInt(1, idCompteCourant);
				ResultSet rs = prep1.executeQuery();
				rs.next();
				MyCompteCourant = new CompteCourant(rs.getInt("idCompte"), rs.getFloat("soldeCompte"),
						rs.getString("dateOuvertureCompte"), rs.getFloat("decouvertAutoriser"));
				MyCompteCourant.setIdClient(rs.getInt("idClient"));
			}

		} catch (SQLException ex) {
			System.out.println("Erreur d'execution SQL");
			ex.printStackTrace();
		} finally {
			Bdd.seDeconnecter(c);
		}
		return MyCompteCourant;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.proxibanque.persistance.IDaoCrud#selectAll()
	 */
	@Override
	public List<CompteCourant> selectAll() {
		// TODO Auto-generated method stub
		List<CompteCourant> listeCompteCourant = new ArrayList();
		CompteCourant MyCompteCourant;
		try {

			Connection c = Bdd.seConnecter();
			if (c != null) {
				Statement stmt = c.createStatement();
				String sql = "Select * from compteCourant";

				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					MyCompteCourant = new CompteCourant(rs.getInt("idCompte"), rs.getFloat("soldeCompte"),
							rs.getString("dateOuvertureCompte"), rs.getFloat("decouvertAutoriser"));
					MyCompteCourant.setIdClient(rs.getInt("idClient"));

					listeCompteCourant.add(MyCompteCourant);
				}
				System.out.println("Les donnees relative aux clients ont ete extraites");
				Bdd.seDeconnecter(c);
			}

		} catch (SQLException ex) {
			System.out.println("Erreur d'execution SQL");
			ex.printStackTrace();
		}
		return listeCompteCourant;
	}

	/**
	 * Prend en parametre l'identifiant d'un client et retourne le compte courant
	 * assigné
	 * @param idClient
	 * @return MyCompteCourant
	 */
	public CompteCourant selectByIdClient(int idClient) {
		// TODO Auto-generated method stub
		System.out.println("**** Selectionner Compte Courant par IdClient*****");
		Connection c = Bdd.seConnecter();
		CompteCourant MyCompteCourant = null;
		try {
			if (c != null) {
				PreparedStatement prep1 = c.prepareStatement("select * from comptecourant where idClient=?");
				prep1.setInt(1, idClient);
				ResultSet rs = prep1.executeQuery();
				rs.next();
				MyCompteCourant = new CompteCourant(rs.getInt("idCompte"), rs.getFloat("soldeCompte"),
						rs.getString("dateOuvertureCompte"), rs.getFloat("decouvertAutoriser"));
				MyCompteCourant.setIdClient(rs.getInt("idClient"));
			}

		} catch (SQLException ex) {
			System.out.println("Erreur d'execution SQL");
			ex.printStackTrace();
		} finally {
			Bdd.seDeconnecter(c);
		}
		return MyCompteCourant;
	}

}
