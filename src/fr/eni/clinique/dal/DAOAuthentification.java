package fr.eni.clinique.dal;

public interface DAOAuthentification {

	public abstract String selectbyMDP(String nom)throws DALException;
}
