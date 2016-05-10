package es.upm.isst.dao;
import java.util.Date;
import java.util.List;

import es.upm.isst.model.InfraccionModel;
import es.upm.isst.model.UserModel;

public interface MatacuasDAO{
	
	/*USER*/
	public List<UserModel> getAllUsers();
	public UserModel getUser(String id);
	public Long addUser(String name, String email, String matricula, int moderador);
	public boolean updateUser(int id, String name, String email, String matricula, int moderador);
	public void remove (int id);
	public String getUserIdFromEmail(String email);
	
	/*INFRACCIONES*/
	public Long addInfraccion(Double longitud, Double latitud,String matricula, String descripcion, Date fecha);
	public List<InfraccionModel> getAllInfracciones();
	public List<InfraccionModel> getMyInfracciones(String user_id);
	public List<InfraccionModel> getReceivedComments(String user_id);
	
	/*RELACION INFRACCION Y USUARIO*/
	public void matchInfraccionUsuario(Long infraccionId, Long userId);
	
	/*DENUNCIA DE UN COMENTARIO*/
	public Long newDenuncia(String comentario_id, String userId);
	
	/*MODERADOR*/
	public List<InfraccionModel> getInfraccionModerar();
	public void aprobarComentario(String comentario_id);
	public void rechazarComentario(String comentario_id);
	
}
