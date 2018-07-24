package fr.eni.clinique.bll;

import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOPersonnel;
import fr.eni.clinique.dal.DAOFactory;

public class TestBLL {
	static String nom = "ezaez";
	static String pass = "12o34";
	static Boolean access;
	
	public static void main(String[] args) throws BLLException {
		LoginMger login = LoginMger.getInstance();
		PersonnelMger pm = PersonnelMger.getInstance();
		AnimalMger am = AnimalMger.getInstance();
		ClientMger cm = ClientMger.getInstance();
		
		System.out.println(am.listeAnimauxParClient(1));


	}

}
