package es.upm.isst.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserModel implements Serializable {

	private static final long serialVersionUID = 01L;
	
	@GeneratedValue @Id
	private Long id;
	private String nombre;
	private String email;
	private String matricula;
	private int moderador;
	

	public UserModel(String nombre, String email, String matricula, int moderador) {
		this.nombre = nombre;
		this.email = email;
		this.matricula = matricula;
		this.moderador = moderador;
	}
	
	public Long getId(){
		return id;
	}
	
	public String getName(){
		return nombre;
	}
	public void setName(String newName){
		nombre = newName;
	}
	
	public String getEmail(){
		return email;
	}
	public void setEmail(String newEmail){
		email = newEmail;
	}
	
	public String getMatricula(){
		return matricula;
	}
	public void setMatricula(String newMatricula){
		matricula = newMatricula;
	}
	
	public boolean isModerator(){
		if (moderador != 0){
			return true;
		}
		return false;
	}
	
	public void setModerador(){
		moderador = 1;
	}

	
}
