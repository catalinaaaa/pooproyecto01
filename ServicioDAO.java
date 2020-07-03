package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import modelo.Servicio;
import static utilidades.Conexion.getConexion;

/**
 * @author catas
 */

public class ServicioDAO {
 
  public static void nuevoServicio(Servicio servicio) throws SQLException{
    Connection con = getConexion();
    CallableStatement entrada;
    entrada = con.prepareCall("{ call nuevoServicio(?, ?, ?, ?, ?, ?) }"); 
    entrada.setString(1, servicio.getIdentificador());
    entrada.setString(2, servicio.getNombre());
    entrada.setString(3, servicio.getDescripcion());
    entrada.setInt(4, servicio.getCategoria());
    entrada.setDouble(5, servicio.getCosto());
    entrada.setInt(6, servicio.getProveedor());
    entrada.execute();
  }
}