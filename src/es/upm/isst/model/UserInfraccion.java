package es.upm.isst.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserInfraccion implements Serializable {

	private static final long serialVersionUID = 01L;
	
	@GeneratedValue @Id
	private Long id;
	private Long user_id;
	private Long infraccion_id;
	
	public UserInfraccion(Long userId, Long infraccionId) {
		user_id = userId;
		infraccion_id = infraccionId;
	}
	public Long getUserId(){
		return user_id;
	}
	public void setUserId(Long newUserId){
		user_id = newUserId;
	}
	public Long getInfraccionId(){
		return infraccion_id;
	}
	public void setInfraccionId(Long newInfraccionId){
		infraccion_id = newInfraccionId;
	}

}
