package es.upm.isst.model;
import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class InfraccionModel implements Serializable {

	private static final long serialVersionUID = 01L;

	@GeneratedValue @Id @PrimaryKey private Long id;
	private Double latitud;
	private Double longitud;
	private String matricula;
	private String descripcion;
	private int aprobada;
	private Date fecha;
	
	
	public InfraccionModel(Double longitud, Double latitud, String matricula, String descripcion, int aprobada, Date fecha) {
		this.latitud = latitud;
		this.longitud = longitud;
		this.matricula = matricula;
		this.descripcion = descripcion;
		this.aprobada = aprobada;
		this.fecha = fecha;
	}
	
	public Double getLatitud(){
		return latitud;
	}
	public void setLatitud(Double newLatitud){
		latitud = newLatitud;
	}
	
	public Double getLongitud(){
		return longitud;
	}
	public void setLongitud(Double newLongitud){
		longitud = newLongitud;
	}
	
	public String getDescripcion(){
		return descripcion;
	}
	public void setDescripcion(String newDescripcion){
		descripcion = newDescripcion;
	}
	
	public int getAprobada(){
		return aprobada;
	}
	
	public boolean isAprobada(){
		if (aprobada != 0){
			return true;
		}
		return false;
	}
	
	public void setAprobada(int newAprobada){
		aprobada = newAprobada;
	}
	
	public Date getFecha(){
		return fecha;
	}
	
	public String getMatricula(){
		return matricula;
	}
	
	public void setMatricula(String newMatricula){
		matricula = newMatricula;
	}

	public Long getId(){
		return id;
	}
	
	
}
