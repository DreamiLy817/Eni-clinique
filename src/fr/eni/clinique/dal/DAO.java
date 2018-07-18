package fr.eni.clinique.dal;

import java.util.List;

public interface DAO<T> {
	
	/**
	 * Select en fonction de l'id (int)
	 * @param id
	 * @return
	 */
	public abstract T selectbyID(Integer id);
	
	/**
	 * Insert dans la base de donn�e
	 * @param obj
	 * @return
	 * @throws DALException 
	 */
	public abstract void insert(T obj) throws DALException;
	
	/**
	 * Select tout les �l�ments dans la BDD
	 * @throws DALException 
	 */
	public abstract List<T> selectAll() throws DALException;

	
	/**
	 * Update d'un objet en base de donn�e
	 * @param obj
	 * @return
	 * @throws DALException 
	 */
	public abstract T update(T obj) throws DALException;
	
	/**
	 * Delete d'un objet en base de donn�e
	 * @param id
	 * @return
	 * @throws DALException 
	 */
	public abstract void supprimer(Integer id) throws DALException;
	
}
