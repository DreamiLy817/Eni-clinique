package fr.eni.clinique.dal;

import java.util.List;

import fr.eni.clinique.bo.Personnel;

public interface PersonnelDAO {
	
	// selectionner la liste du personnel 
	public List<Personnel> SelectAllInfosPersonnel() throws DALException; 
	// to do throws DALexception

	// Insérer un nouveau membre du personnel
	public void insertPersonnel(Personnel p) throws DALException;
	// to do throws DALexception
	
	//supprimer un membre du personnel
	public void suppressionPersonnel(int CodePers) throws DALException;
}
