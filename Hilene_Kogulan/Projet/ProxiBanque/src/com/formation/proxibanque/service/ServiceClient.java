package com.formation.proxibanque.service;

import java.util.HashMap;
import java.util.List;

import com.formation.proxibanque.model.Client;
import com.formation.proxibanque.persistance.DaoClient;

/**
 * @author Hilene - Kogulan
 *
 */
public class ServiceClient implements IServiceCrud<Client> {

	DaoClient daoC = new DaoClient();

	/* (non-Javadoc)
	 * @see com.formation.proxibanque.service.IServiceCrud#insert(java.lang.Object)
	 */
	public void insert(Client myClient) {
		daoC.insert(myClient);
	}

	/* (non-Javadoc)
	 * @see com.formation.proxibanque.service.IServiceCrud#delete(int)
	 */
	public void delete(int idClient) {
		daoC.delete(idClient);
	}

	/* (non-Javadoc)
	 * @see com.formation.proxibanque.service.IServiceCrud#update(java.lang.Object)
	 */
	public void update(Client myClient) {
		daoC.update(myClient);
	}

	/* (non-Javadoc)
	 * @see com.formation.proxibanque.service.IServiceCrud#selectById(int)
	 */
	public Client selectById(int idClient) {
		return daoC.selectById(idClient);
	}

	/* (non-Javadoc)
	 * @see com.formation.proxibanque.service.IServiceCrud#selectAll()
	 */
	@Override
	public List<Client> selectAll() {
		// TODO Auto-generated method stub
		return daoC.selectAll();
	}

}
