package fr.eni.clinique.dal;

import java.util.List;

import fr.eni.clinique.bo.Personnel;

public interface DAOPersonnel {

	public abstract Boolean selectbyMDP(String nom,String motDePasse)throws DALException;
	
	public abstract void reinitialiserPersonnel(Personnel personne, String motDePasse) throws DALException;

	public abstract Personnel selectbyNom(String nom) throws DALException;
	
	public abstract int selectbyNomGiveID(String nom) throws DALException;
	
	public abstract List<Personnel> selectAllArchi() throws DALException;
	
}
