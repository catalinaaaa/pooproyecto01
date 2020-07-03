package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import modelo.Administrador;
import static utilidades.Conexion.getConexion;

public class AdministradorDAO {
  public static void nuevoAdministrador(Administrador pAdministrador) throws SQLException{
    Connection con = getConexion();
    CallableStatement entrada = con.prepareCall(" { call nuevoAdministrador (?, ?, ?, ?)}");
    entrada.setString(1, pAdministrador.getNombre());
    entrada.setString(2, pAdministrador.getContrasenia());
    entrada.setString(3, pAdministrador.getCorreoElectronico());
    entrada.setString(4, pAdministrador.getNombreUsuario());
    entrada.execute();
  }
}