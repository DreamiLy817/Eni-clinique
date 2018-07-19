package fr.eni.clinique.dal;

import fr.eni.clinique.bo.Personnel;

public interface DAOPersonnel {

	public abstract Boolean selectbyMDP(String nom,String motDePasse)throws DALException;
	
	public abstract void reinitialiserPersonnel(Personnel personne, String motDePasse) throws DALException;

}
