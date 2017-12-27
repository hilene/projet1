package com.formation.proxibanque.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.formation.proxibanque.model.CompteEpargne;
import com.formation.proxibanque.util.Bdd;

public class DaoCompteEpargne implements IDaoCrud<CompteEpargne> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.proxibanque.persistance.IDaoCrud#insert(java.lang.Object)
	 */
	@Override
	public void insert(CompteEpargne myCompteEpargne) {
		// TODO Auto-generated method stub
		System.out.println("**** Inserstion Compte Epargne *****");
		Connection c = Bdd.seConnecter();
		try {

			if (c != null) {
				PreparedStatement prep1 = c.prepareStatement(
						"insert into compteepargne (soldeCompte,dateOuvertureCompte,idClient,tauxRemuneration)values (?,?,?,?)");

				prep1.setFloat(1, myCompteEpargne.getSoldeCompte());
				prep1.setString(2, myCompteEpargne.getDateOuvertureCompte());
				prep1.setInt(3, myCompteEpargne.getIdClient());
				prep1.setDouble(4, myCompteEpargne.getTauxRemuneration());

				prep1.executeUpdate();
				System.out.println("Ajout d'un compte epargne pour le client " + myCompteEpargne.getIdClient()
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
	public void update(CompteEpargne myCompteEpargne) {
		// TODO Auto-generated method stub
		System.out.println("**** Mise à jour Compte Epargne *****");
		Connection c = Bdd.seConnecter();
		try {

			if (c != null) {
				PreparedStatement prep1 = c.prepareStatement(
						"update compteCourant set soldeCompte=?,dateOuvertureCompte=?, 	tauxRemuneration=? where idCompte=?");

				prep1.setFloat(1, myCompteEpargne.getSoldeCompte());
				prep1.setString(2, myCompteEpargne.getDateOuvertureCompte());
				prep1.setDouble(3, myCompteEpargne.getTauxRemuneration());
				prep1.setInt(4, myCompteEpargne.getIdCompte());

				prep1.executeUpdate();
				System.out.println(
						"Le compte d'epargne du client " + myCompteEpargne.getIdClient() + " a ete mis à jour");
			}

		} catch (SQLException ex) {
			System.out.println("Erreur d'execution SQL");
			ex.printStackTrace();
		} finally {
			Bdd.seDeconnecter(c);
		}
	}

	@Override
	public void delete(int idCompteEpargne) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.formation.proxibanque.persistance.IDaoCrud#selectById(int)
	 */
	@Override
	public CompteEpargne selectById(int idCompteEpargne) {
		// TODO Auto-generated method stub
		System.out.println("**** Selectionner Compte Epargne *****");
		Connection c = Bdd.seConnecter();
		CompteEpargne MyCompteEpargne = null;
		try {
			if (c != null) {
				PreparedStatement prep1 = c.prepareStatement("select * from compteCourant where idCompte=?");
				prep1.setInt(1, idCompteEpargne);
				ResultSet rs = prep1.executeQuery();
				rs.next();
				MyCompteEpargne = new CompteEpargne(rs.getInt("idCompte"), rs.getFloat("soldeCompte"),
						rs.getString("dateOuvertureCompte"), rs.getDouble("tauxRemuneration"));
				MyCompteEpargne.setIdClient(rs.getInt("idClient"));
			}

		} catch (SQLException ex) {
			System.out.println("Erreur d'execution SQL");
			ex.printStackTrace();
		} finally {
			Bdd.seDeconnecter(c);
		}
		return MyCompteEpargne;
	}

	@Override
	public List<CompteEpargne> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Prend en parametre l'identifiant d'un client et retourne le compte epargne
	 * assigné
	 * 
	 * @param idClient
	 * @return MyCompteEpargne
	 */
	public CompteEpargne selectByIdClient(int idClient) {
		// TODO Auto-generated method stub
		System.out.println("**** Selectionner Compte Epargne par IdClient*****");
		Connection c = Bdd.seConnecter();
		CompteEpargne MyCompteEpargne = null;
		try {
			if (c != null) {
				PreparedStatement prep1 = c.prepareStatement("select * from compteepargne where idClient=?");
				prep1.setInt(1, idClient);
				ResultSet rs = prep1.executeQuery();
				rs.next();
				MyCompteEpargne = new CompteEpargne(rs.getInt("idCompte"), rs.getFloat("soldeCompte"),
						rs.getString("dateOuvertureCompte"), rs.getFloat("tauxRemuneration"));
				MyCompteEpargne.setIdClient(rs.getInt("idClient"));
			}

		} catch (SQLException ex) {
			System.out.println("Erreur d'execution SQL");
			ex.printStackTrace();
		} finally {
			Bdd.seDeconnecter(c);
		}
		return MyCompteEpargne;
	}
}
