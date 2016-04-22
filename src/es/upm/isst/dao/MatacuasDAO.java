package es.upm.isst.dao;
import java.util.Date;
import java.util.List;

import es.upm.isst.model.InfraccionModel;
import es.upm.isst.model.UserModel;

public interface MatacuasDAO{
	
	/*USER*/
	public List<UserModel> getAllUsers();
	public Long addUser(String name, String email, String matricula, int moderador);
	public UserModel getUser(int id);
	public boolean updateUser(int id, String name, String email, String matricula, int moderador);
	public void remove (int id);
	public String getUserIdFromEmail(String email);
	
	/*INFRACCIONES*/
	public Long addInfraccion(Double longitud, Double latitud,String matricula, String descripcion, Date fecha);
	public List<InfraccionModel> getAllInfracciones();
	public List<InfraccionModel> getMyInfracciones(String user_id);
	
	/*RELACION INFRACCION Y USUARIO*/
	public void matchInfraccionUsuario(Long infraccionId, Long userId);
	
}
