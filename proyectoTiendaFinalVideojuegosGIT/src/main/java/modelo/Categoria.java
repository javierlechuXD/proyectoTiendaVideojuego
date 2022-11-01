package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tabla_categorias")
public class Categoria {
	
	private String nombre;
	
	@Column(name = "descripcion_categoria", length = 9000)
	private String descreipcion;
	
	@Id
	@GeneratedValue
	private int id;

	public Categoria() {

	}

	public Categoria(String nombre, String descreipcion) {
		super();
		this.nombre = nombre;
		this.descreipcion = descreipcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescreipcion() {
		return descreipcion;
	}

	public void setDescreipcion(String descreipcion) {
		this.descreipcion = descreipcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
