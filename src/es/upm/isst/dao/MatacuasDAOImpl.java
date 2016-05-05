package es.upm.isst.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.mortbay.log.Log;

import es.upm.isst.model.InfraccionModel;
import es.upm.isst.model.UserInfraccion;
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
	public Long addUser(String name, String email, String matricula, int moderador) {
		EntityManager em = EMFService.get().createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		//creamos un usuario
		UserModel myUser = new UserModel(name,email,matricula,moderador);
		transaction.begin();
		em.persist(myUser); //guardamos.
		transaction.commit();
		long id = myUser.getId();
		em.close(); //cerramos conexion.
		
		
		return id;
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
	public Long addInfraccion(Double longitud, Double latitud, String matricula, String descripcion,
			Date fecha) {
		EntityManager em = EMFService.get().createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		//por defecto las nuevas infracciones están con aprobadas = 0, porque necesitan moderacion.
		InfraccionModel myInfraccion = new InfraccionModel(latitud,longitud,matricula,descripcion,0,fecha);
		transaction.begin();
		em.persist(myInfraccion);
		transaction.commit();
		long id = myInfraccion.getId();
		em.close();	
		
		
		
		/*TODO: Avisar al usuario que ha cometido la infraccion si estuviera registrado con esa matricula*/
		
		
		return id;
		
		
	
	
	}
	@Override
	public List<InfraccionModel> getAllInfracciones() {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select i from InfraccionModel i");
		List<InfraccionModel> results = q.getResultList();
		em.close();
		return results;
	}
	
	@Override
	public List<InfraccionModel> getMyInfracciones(String user_id) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select i from UserInfraccion i where user_id = "+user_id,UserInfraccion.class);
		List<UserInfraccion> listUserInfraccion = q.getResultList();
	

		List<InfraccionModel> listInfracciones = new ArrayList<InfraccionModel>();
		for (UserInfraccion inf: listUserInfraccion){
			String idInfraccion = inf.getInfraccionId().toString();
			Query q1 = em.createQuery("select i from InfraccionModel i where id = "+idInfraccion,InfraccionModel.class);
			List<InfraccionModel> result1 = q1.getResultList();
			listInfracciones.add(result1.get(0));
			
		}
		em.close();
		return listInfracciones;
	}
	
	
	
	@Override
	public void matchInfraccionUsuario(Long infraccionId, Long userId) {
		EntityManager em = EMFService.get().createEntityManager();
		UserInfraccion myUserInfraccion = new UserInfraccion(userId,infraccionId);
		em.persist(myUserInfraccion);
		em.close();
	}
	@Override
	public String getUserIdFromEmail(String email) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select u from UserModel u where email = :email");
		q.setParameter("email", email);
		List<UserModel> results = q.getResultList();
		em.close();
		if (results.isEmpty()){
			return "not found";
		}else{
			UserModel myUser = results.get(0);
			return myUser.getId().toString();
		}
	}
	@Override
	public List<InfraccionModel> getReceivedComments(String user_id) {
		EntityManager em = EMFService.get().createEntityManager();
		//hay que coger la matricula del usuario con ese id y buscar las infracciones cuya matricula encaje.
			UserModel myUser = em.find(UserModel.class, Long.valueOf(user_id));
			String matricula = myUser.getMatricula();
			Query q2 = em.createQuery("select i from InfraccionModel i where i.matricula = :matricula");
			q2.setParameter("matricula",matricula);
			List<InfraccionModel> infracciones = q2.getResultList();
			return infracciones;
	}
	

}
