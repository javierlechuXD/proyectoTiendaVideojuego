package servicios;

import java.util.List;

import modelo.Videojuego;

public interface ServicioVideojuegos {
	
	public void registrarVideojuego(Videojuego videojuegoRegistrar);
	
	public List<Videojuego> obtenerVideojuegos();
	
	public Videojuego obtenerVideojuegoPorId(int idVideojuegoEditar);
	
	public void guardarCambiosVideojuego(Videojuego videojuego);
	
	public void borrarVideojuego (int id);
	
}
