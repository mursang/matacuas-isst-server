package es.upm.isst.dao;
import java.util.Date;
import java.util.List;

import es.upm.isst.model.InfraccionModel;
import es.upm.isst.model.UserModel;

public interface MatacuasDAO{
	
	/*USER*/
	public List<UserModel> getAllUsers();
	public void addUser(String name, String email, String matricula, int moderador);
	public UserModel getUser(int id);
	public boolean updateUser(int id, String name, String email, String matricula, int moderador);
	public void remove (int id);
	
	/*INFRACCIONES*/
	public void addInfraccion(Long longitud, Long latitud,String matricula, String descripcion, Date fecha);
	public List<InfraccionModel> getAllInfracciones();
}
