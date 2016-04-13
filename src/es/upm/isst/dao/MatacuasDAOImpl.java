package es.upm.isst.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import es.upm.isst.model.InfraccionModel;
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
	@Override
	public void addInfraccion(Long longitud, Long latitud, String matricula, String descripcion,
			Date fecha) {
		EntityManager em = EMFService.get().createEntityManager();
		//por defecto las nuevas infracciones están con aprobadas = 0, porque necesitan moderacion.
		InfraccionModel myInfraccion = new InfraccionModel(latitud,longitud,matricula,descripcion,0,fecha);
		em.persist(myInfraccion);
		em.close();	
		/*TODO: Avisar al usuario que ha cometido la infraccion si estuviera registrado con esa matricula*/
	
	
	}
	@Override
	public List<InfraccionModel> getAllInfracciones() {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select i from InfraccionModel i");
		List<InfraccionModel> results = q.getResultList();
		em.close();
		return results;
	}

}
