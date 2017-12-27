package com.formation.proxibanque.service;

import java.util.List;

import com.formation.proxibanque.model.CompteEpargne;
import com.formation.proxibanque.persistance.DaoCompteEpargne;

/**
 * @author Hilene - Kogulan
 *
 */
public class ServiceCompteEpargne implements IServiceCrud<CompteEpargne> {
	DaoCompteEpargne daoCE = new DaoCompteEpargne();


/* (non-Javadoc)
 * @see com.formation.proxibanque.service.IServiceCrud#insert(java.lang.Object)
 */
@Override
public void insert(CompteEpargne paramT) {
	// TODO Auto-generated method stub
	daoCE.insert(paramT);
}

/* (non-Javadoc)
 * @see com.formation.proxibanque.service.IServiceCrud#update(java.lang.Object)
 */
@Override
public void update(CompteEpargne paramT) {
	// TODO Auto-generated method stub
	daoCE.update(paramT);
}

/* (non-Javadoc)
 * @see com.formation.proxibanque.service.IServiceCrud#delete(int)
 */
@Override
public void delete(int id) {
	// TODO Auto-generated method stub
	daoCE.delete(id);
}

/* (non-Javadoc)
 * @see com.formation.proxibanque.service.IServiceCrud#selectById(int)
 */
@Override
public CompteEpargne selectById(int id) {
	// TODO Auto-generated method stub
	return daoCE.selectById(id);
}

/* (non-Javadoc)
 * @see com.formation.proxibanque.service.IServiceCrud#selectAll()
 */
@Override
public List<CompteEpargne> selectAll() {
	// TODO Auto-generated method stub
	return daoCE.selectAll();
}

/**
 * Appel la DAO afin de retouner le compte Epargne d'un client (idClient)
 * @param idClient
 * @return
 */
public CompteEpargne selectByIdClient(int idClient) {
	return daoCE.selectByIdClient(idClient);
}
}