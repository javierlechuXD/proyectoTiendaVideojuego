package serviciosWEB;

import java.util.List;

import modelo.Videojuego;

public class RespuestaVideojuegos {
	
	private int total;
	private List<Videojuego> videojuegos;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<Videojuego> getVideojuegos() {
		return videojuegos;
	}
	public void setVideojuegos(List<Videojuego> videojuegos) {
		this.videojuegos = videojuegos;
	}
	
	
}
