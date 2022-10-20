package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String nombre;
	private String apellido;
	private String tel;
	private String ciudad;
	private int cp;
	
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	

	public Usuario(int id, String nombre, String apellido, String tel, String ciudad, int cp) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tel = tel;
		this.ciudad = ciudad;
		this.cp = cp;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public int getCp() {
		return cp;
	}


	public void setCp(int cp) {
		this.cp = cp;
	}


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", tel=" + tel + ", ciudad="
				+ ciudad + ", cp=" + cp + "]";
	}



	
	
	
	
}
