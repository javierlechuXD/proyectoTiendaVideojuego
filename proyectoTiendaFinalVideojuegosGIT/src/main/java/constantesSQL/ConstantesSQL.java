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


}
