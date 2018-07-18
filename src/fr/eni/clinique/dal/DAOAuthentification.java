package fr.eni.clinique.dal;

public interface DAOAuthentification {

	public abstract Boolean selectbyMDP(String nom,String motDePasse)throws DALException;
}
