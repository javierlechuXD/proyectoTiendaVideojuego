package modelo;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="videojuegos")
public class Videojuego {
	@Id
	@GeneratedValue
	private int id;
	
	@NotEmpty
	@Size(min = 1, max = 40)
	@Pattern(regexp = "^[a-zA-Z áéíóúÁÉÍÓÚñÑ0-9]{1,40}$")
	private String nombre;
	
	@NotEmpty(message = "Descripción no puede estar vacio")
	@Size(min = 1, max = 2000, message = "Descripción debe tener entre 1 y 2000 caracterec")
	@Pattern(regexp = "^[a-zA-Z ().,áéíóúÁÉÍÓÚñÑ0-9]{1,2000}$", message = "Solo letras, números, puntos, comas y paréntesis")
	private String descri;
	
	private boolean alta;
	private int edadmin;
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,###.###")
	@Min(value = 1, message = "El precio mímimo es de un euro")
	@Max(value = 9999, message = "El precio máximo es de 9999")
	private double precio;	
	private String desarrollador;
	private int notaCritica;
	
	@Column(nullable = true)
	private Date fechaImagenPortada1;
	
	@Column(nullable = true)
	private Date fechaImagenPortada2;
	
	
	@ManyToOne(targetEntity = Categoria.class, optional = false, fetch = FetchType.EAGER)
	private Categoria categoria;
	
	@Transient
	private int idCategoria;
	
	@Transient // el siguiente campo es ignorado por hibernate
	private MultipartFile portada;
	
	@Transient // el siguiente campo es ignorado por hibernate
	private MultipartFile portada2;
	
	public Videojuego() {
		// TODO Auto-generated constructor stub
	}
	
	public Videojuego(int id, String nombre, String descri, int edadmin, double precio, String desarrollador, int notaCritica) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descri = descri;
		this.edadmin = edadmin;
		this.precio = precio;
		this.desarrollador = desarrollador;
		this.notaCritica = notaCritica;
	}
	
	public Videojuego(String nombre, String descri, int edadmin, double precio, String desarrollador, int notaCritica) {
		this.nombre = nombre;
		this.descri = descri;
		this.edadmin = edadmin;
		this.precio = precio;
		this.desarrollador = desarrollador;
		this.notaCritica = notaCritica;
	}
	
	

	public Videojuego(String nombre, String descri, int edadmin, double precio, String desarrollador, int notaCritica,
			Categoria categoria, boolean alta) {
		super();
		this.nombre = nombre;
		this.descri = descri;
		this.edadmin = edadmin;
		this.precio = precio;
		this.desarrollador = desarrollador;
		this.notaCritica = notaCritica;
		this.categoria = categoria;
		this.alta = alta;
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

	public String getDescri() {
		return descri;
	}

	public void setDescri(String descri) {
		this.descri = descri;
	}

	public int getEdadmin() {
		return edadmin;
	}

	public void setEdadmin(int edadmin) {
		this.edadmin = edadmin;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDesarrollador() {
		return desarrollador;
	}

	public void setDesarrollador(String desarrollador) {
		this.desarrollador = desarrollador;
	}

	public int getNotaCritica() {
		return notaCritica;
	}

	public void setNotaCritica(int notaCritica) {
		this.notaCritica = notaCritica;
	}

	public MultipartFile getPortada() {
		return portada;
	}

	public void setPortada(MultipartFile portada) {
		this.portada = portada;
	}
	

	public MultipartFile getPortada2() {
		return portada2;
	}

	public void setPortada2(MultipartFile portada2) {
		this.portada2 = portada2;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	public Date getFechaImagenPortada1() {
		return fechaImagenPortada1;
	}

	public void setFechaImagenPortada1(Date fechaImagenPortada1) {
		this.fechaImagenPortada1 = fechaImagenPortada1;
	}

	public Date getFechaImagenPortada2() {
		return fechaImagenPortada2;
	}

	public void setFechaImagenPortada2(Date fechaImagenPortada2) {
		this.fechaImagenPortada2 = fechaImagenPortada2;
	}

	public boolean isAlta() {
		return alta;
	}

	public void setAlta(boolean alta) {
		this.alta = alta;
	}

	@Override
	public String toString() {
		return "Videojuego [id=" + id + ", nombre=" + nombre + ", descri=" + descri + ", edadmin=" + edadmin
				+ ", precio=" + precio + ", desarrollador=" + desarrollador + ", notaCritica=" + notaCritica + "]";
	}
	
	
	
	
}
