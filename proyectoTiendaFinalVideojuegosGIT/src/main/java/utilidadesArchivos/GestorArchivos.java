package utilidadesArchivos;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import modelo.Videojuego;

public class GestorArchivos {

	public static void guardarPortadaVideojuego(Videojuego v, String rutaReal) {
		String nombreArchivo = v.getId() + ".jpg";
		String nombreArchivo2 = v.getId() + "-2.jpg";
		String rutaSubidas = rutaReal + "/subidas";
		
		File fileRutaSubidas = new File(rutaSubidas);
		
		if (!fileRutaSubidas.exists()) {
			fileRutaSubidas.mkdir();
		}
		
		moverPortada(v.getPortada(), rutaSubidas, nombreArchivo);
		moverPortada(v.getPortada2(), rutaSubidas, nombreArchivo2);
	}
	
	private static void moverPortada(MultipartFile m, String rutaSubidas, String nombreArchivo) {
		if(m.getSize() > 0) {
			try {
				m.transferTo(new File(rutaSubidas,nombreArchivo));
				System.out.println("Archivo movido a: " + rutaSubidas);
			} catch (IllegalStateException | IOException e) {
				System.out.println("No se ha podido mover el archivo a la ruta de subidas");
				e.printStackTrace();
			}
		}else {
			System.out.println("Se ha subido un videojuego sin portada");
		}
	}
	
}
