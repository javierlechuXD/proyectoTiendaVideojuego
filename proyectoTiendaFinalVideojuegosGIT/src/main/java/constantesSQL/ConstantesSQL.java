package constantesSQL;

public class ConstantesSQL {

	public final static String SQL_OBTENER_VIDEOJUEGOS = "select * from videojuegos;";
	
	public final static String SQL_OBTENER_USUARIOS = "select * from usuarios;";
	
	public final static String SQL_REGISTRAR_USUARIO = "insert into usuarios (nombre,apellido,tel,ciudad,cp) values(?,?,?,?,?);";

	public static final String SQL_BORRAR_USUARIO = "delete from usuarios where id = ?";
	
	public static final String SQL_BORRAR_VIDEOJUEGO = "delete from videojuegos where id = ?";

	public static final String OBTENER_USUARIO_POR_ID = "select * from usuarios where id = ?";
	
	public static final String OBTENER_VIDEOJUEGO_POR_ID = "select * from videojuegos where id = ?";

	public static final String SQL_GUARDAR_CAMBIOS_USUARIO = "UPDATE `usuarios` SET `nombre` = ?, `apellido` = ?, `tel` = ?, `ciudad` = ?, `cp` = ? WHERE `usuarios`.`id` = ?";
	
	public static final String SQL_GUARDAR_CAMBIOS_VIDEOJUEGO = "UPDATE `videojuegos` SET `nombre` = ?, `descri` = ?, `edadmin` = ?, `precio` = ?, `desarrollador` = ?, `notaCritica` = ? WHERE `videojuegos`.`id` = ?";
	
	public final static String SQL_OBTENER_CATEGORIAS_PARA_DESPLEGABLE = "select id, nombre from tabla_categorias order by nombre asc"; 
	
	public final static String SQL_OBTENER_PRODUCTOS_CARRITO = "select videojuegos.id as videojuegos_id,  videojuegos.nombre, videojuegos.precio, productocarrito.cantidad from videojuegos, productocarrito where productocarrito.videojuego_id = videojuegos.id and productocarrito.carrito_id = :carrito_id ORDER by productocarrito.id asc"; 

	public final static String BORRAR_PRODUCTOS_CARRITO = "delete from productocarrito where carrito_id = :carrito_id"; 
	
}
