package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tabla_categorias")
public class Categorias {
	
	private String nombre;
	private String descreipcion;
	
	@Id
	@GeneratedValue
	private int id;
}
