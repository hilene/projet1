package com.formation.proxibanque.persistance;

import java.util.List;

/**
 * Utilisation d'une interface generique pour gerer le CRUD
 * @author Hilene - Kogulan 
 * @param <T>
 */
public interface IDaoCrud<T> {

	public void insert(T paramT);

	public void update(T paramT);

	public void delete(int id);

	public T selectById(int id);

	//public HashMap<Integer, T> selectAll();
	
	public List<T> selectAll();
	

}
