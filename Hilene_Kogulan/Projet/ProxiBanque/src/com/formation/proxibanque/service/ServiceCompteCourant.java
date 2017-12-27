package com.formation.proxibanque.service;

import java.util.List;

import com.formation.proxibanque.model.CompteCourant;
import com.formation.proxibanque.persistance.DaoCompteCourant;

/**
 * @author Hilene - Kogulan
 *
 */
public class ServiceCompteCourant implements IServiceCrud<CompteCourant> {

	DaoCompteCourant daoCC = new DaoCompteCourant();

	/* (non-Javadoc)
	 * @see com.formation.proxibanque.service.IServiceCrud#insert(java.lang.Object)
	 */
	@Override
	public void insert(CompteCourant myCompteCourant) {
		// TODO Auto-generated method stub
		daoCC.insert(myCompteCourant);
	}

	/* (non-Javadoc)
	 * @see com.formation.proxibanque.service.IServiceCrud#update(java.lang.Object)
	 */
	@Override
	public void update(CompteCourant myCompteCourant) {
		// TODO Auto-generated method stub
		daoCC.update(myCompteCourant);
	}

	/* (non-Javadoc)
	 * @see com.formation.proxibanque.service.IServiceCrud#delete(int)
	 */
	@Override
	public void delete(int idCompteCourant) {
		// TODO Auto-generated method stub
		daoCC.delete(idCompteCourant);		
	}

	/* (non-Javadoc)
	 * @see com.formation.proxibanque.service.IServiceCrud#selectById(int)
	 */
	@Override
	public CompteCourant selectById(int idCompteCourant) {
		// TODO Auto-generated method stub
		return daoCC.selectById(idCompteCourant);
	}

	/* (non-Javadoc)
	 * @see com.formation.proxibanque.service.IServiceCrud#selectAll()
	 */
	@Override
	public List<CompteCourant> selectAll() {
		// TODO Auto-generated method stub
		return daoCC.selectAll();
	}

	/**
	 * Retourne le compte courant correspondant à un Client (idClient)
	 * @param idClient
	 * @return
	 */
	public CompteCourant selectByIdClient(int idClient) {
		// TODO Auto-generated method stub
		return daoCC.selectByIdClient(idClient);
	}

}
