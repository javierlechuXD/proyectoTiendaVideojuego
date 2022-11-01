package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String nombre;
	private String apellido;
	private String email;
	private String pass;
	private String tel;
	private String ciudad;
	private int cp;
	
	@OneToOne
	private Carrito carrito;
	
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}


	public Usuario(int id, String nombre, String apellido, String email, String pass, String tel, String ciudad,
			int cp) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.pass = pass;
		this.tel = tel;
		this.ciudad = ciudad;
		this.cp = cp;
	}
	


	public Usuario(String nombre, String apellido, String email, String pass, String tel, String ciudad, int cp) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.pass = pass;
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

	

	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}
	

	public Carrito getCarrito() {
		return carrito;
	}


	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", pass="
				+ pass + ", tel=" + tel + ", ciudad=" + ciudad + ", cp=" + cp + "]";
	}










	
	
	
	
}
