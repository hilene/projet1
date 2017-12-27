package com.formation.proxibanque.service;

import java.util.HashMap;
import java.util.List;

public interface IServiceCrud<T> {
	/**
	 * Ajout un Objet � la BDD
	 * @param paramT
	 */
	public void insert(T paramT);

	/**
	 * Prend en parametre un objet et mets � jour la BDD
	 * @param paramT
	 */
	public void update(T paramT);

	/**
	 * Supprime un objet de la BDD
	 * @param id
	 */
	public void delete(int id);

	/**
	 * Retourne un objet correspondant � id
	 * @param id
	 * @return
	 */
	public T selectById(int id);

	/**
	 * Retourne une liste d'objet: requete select all
	 * @return
	 */
	public List<T> selectAll();
}
