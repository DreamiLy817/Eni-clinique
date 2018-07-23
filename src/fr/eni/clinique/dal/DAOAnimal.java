package fr.eni.clinique.dal;

public interface DAOAnimal {
	
	public void modifier(String nom, char sexe, String couleur, String race, String espece, String tatouage, String antecedents, int codeAnimal) throws DALException;
	
	public void supprimerViaCodeClient(int codeClient, int codeAnimal) throws DALException;
}
