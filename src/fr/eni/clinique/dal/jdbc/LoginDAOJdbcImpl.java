package fr.eni.clinique.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.clinique.bo.Login;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.DAO;

public class LoginDAOJdbcImpl extends DAO<Login>{
	private static final String sqlSelectByMDP = "SELECT MotPasse from Personnels WHERE Nom =?";
	private Connection cnx;

	@Override
	public Login selectbyID(long id) {
		return null;
	}

	@Override
	public Login add(Login obj) {
		return null;
	}

	@Override
	public Login update(Login obj) {
		return null;
	}

	@Override
	public Login delete(Login obj) {
		return null;
	}

	@Override
	public String selectbyMDP(String nom) {
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
	}
