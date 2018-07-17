package fr.eni.clinique.dal;

public abstract class DAO<T> {
	
	/**
	 * Select en fonction de l'id (int)
	 * @param id
	 * @return
	 */
	public abstract T selectbyID(long id);
	
	/**
	 * Insert dans la base de donn�e
	 * @param obj
	 * @return
	 */
	public abstract T add(T obj);
	
	/**
	 * Update d'un objet en base de donn�e
	 * @param obj
	 * @return
	 */
	public abstract T update(T obj);
	
	/**
	 * Delete d'un objet en base de donn�e
	 * @param obj
	 * @return
	 */
	public abstract T delete(T obj);
	
	/**
	 * M�thode v�rif mot de passe
	 */
	public abstract String selectbyMDP(String nom);
}
