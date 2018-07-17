package fr.eni.clinique.dal;

import java.util.List;

import fr.eni.clinique.bo.Personnel;

public interface PersonnelDAO {
	
	// selectionner la liste du personnel 
	public List<Personnel> SelectAllInfosPersonnel(); 
	// to do throws DALexception

	// Insérer un nouveau membre
	public void insertPersonnel(Personnel p);
	// to do throws DALexception
	

}
