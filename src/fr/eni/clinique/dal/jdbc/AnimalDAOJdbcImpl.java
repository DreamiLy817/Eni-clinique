package fr.eni.clinique.dal.jdbc;

import java.util.List;

import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAO;

public class AnimalDAOJdbcImpl implements DAO<Animal> {

	@Override
	public Animal selectbyID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Animal ani) throws DALException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Animal> selectAll() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Animal update(Animal ani) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimer(Integer id) throws DALException {
		// TODO Auto-generated method stub

	}

}
