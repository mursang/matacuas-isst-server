package es.upm.isst.model;
import java.io.Serializable;

import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class DenunciaModel implements Serializable {

	private static final long serialVersionUID = 01L;

	@GeneratedValue @Id @PrimaryKey private Long id;
	private Long user_id;
	private Long infraccion_id;
	
	
	public DenunciaModel(Long user_id, Long infraccion_id) {
		this.user_id = user_id;
		this.infraccion_id = infraccion_id;
	}
	
	public Long getUserId(){
		return user_id;
	}
	public void setUserId(Long newId){
		user_id = newId;
	}
	
	public Long getInfraccionId(){
		return infraccion_id;
	}
	public void setInfraccionId(Long newInfraccionId){
		infraccion_id = newInfraccionId;
	}

	public Long getId(){
		return id;
	}
	
	
}
