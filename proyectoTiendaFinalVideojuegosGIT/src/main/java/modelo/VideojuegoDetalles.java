package modelo;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class VideojuegoDetalles {

	private String idioma;
	private String titulo;
	private String descripcion;

	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	private Videojuego videojuego;

}
