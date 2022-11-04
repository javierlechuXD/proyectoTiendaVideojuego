package datos.serviciosWEB;

import java.util.List;
import java.util.Map;

public class ResumenPedido {
	private List<Map<String, Object>> videojuegos;
	
	// paso1
	private String nombreCompleto;
	private String direccion;
	private String provincia;
	private String pais;
	private String telefono;
	
	
	// paso 2
	private String titularTarjeta;
	private String numeroTarjeta;
	
	// paso 3
	private String observaciones;
	
	
	
	public List<Map<String, Object>> getVideojuegos() {
		return videojuegos;
	}
	public void setVideojuegos(List<Map<String, Object>> videojuegos) {
		this.videojuegos = videojuegos;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getTitularTarjeta() {
		return titularTarjeta;
	}
	public void setTitularTarjeta(String titularTarjeta) {
		this.titularTarjeta = titularTarjeta;
	}
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	

	
	
	
	
}
