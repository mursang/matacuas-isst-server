package es.upm.isst.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import es.upm.isst.model.UserModel;

public class MatacuasDAOImpl implements MatacuasDAO {
	
	//Singleton
	private static MatacuasDAOImpl instance;
	private MatacuasDAOImpl () {
		
	}
	public static MatacuasDAOImpl getInstance() {
		if (instance == null)
			instance = new MatacuasDAOImpl();
		return instance;
	}
	//

	
	@Override
	public List<UserModel> getAllUsers() {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select u from UserModel u");
		List<UserModel> results = q.getResultList();
		em.close();
		return results;
	}

	@Override
	public void addUser(String name, String email, String matricula, int moderador) {
		EntityManager em = EMFService.get().createEntityManager();
		//creamos un usuario
		UserModel myUser = new UserModel(name,email,matricula,moderador);
		em.persist(myUser); //guardamos.
		em.close(); //cerramos conexion.
	}

	@Override
	public UserModel getUser(int id) {
		return null;
	}

	@Override
	public boolean updateUser(int id, String name, String email, String matricula,
			int moderador) {
		

		return true;
	}

	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub

	}

}
