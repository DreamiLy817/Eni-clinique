package fr.eni.clinique.bll;

import fr.eni.clinique.dal.jdbc.JdbcTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.DAO;
import fr.eni.clinique.dal.DAOFactory;


public class LoginMger {
	private static LoginMger instance;
	private static DAO<Personnel> personnelDAO;
	
	public static synchronized LoginMger getInstance(){
		if (instance == null) {
			instance = new LoginMger();	
		}
		return instance;
	}
	
	private LoginMger(){
		personnelDAO = DAOFactory.getPersonnelDAO();
	}

	private Boolean getAccess(String saisieLogin, String saisieMotpasse) {
		Boolean access = null;
		String pass = null;
		
		
		return access;
	}
	
	/**
	 * A ajouter en DAL via interface
	 * 	public String selectbyMDP(String nom) {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		String pass = null;
		try {
			cnx=JdbcTools.getConnection();
			rqt=cnx.prepareStatement(sqlSelectByMDP);
			rqt.setString(1, nom);
			rs=rqt.executeQuery();
			pass = rs.toString();
			}	
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	return pass;
}
	 */
}
