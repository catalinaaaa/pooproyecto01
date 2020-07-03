package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Cliente;
import modelo.Proveedor;
import utilidades.Conexion;
import static utilidades.Conexion.getConexion;

/**
 * @author catas
 */

public class ClienteDAO {
  
  public static void nuevoCliente(Cliente cliente) throws SQLException{
    Connection con = getConexion();
    CallableStatement entrada = con.prepareCall(" { call nuevoCliente "
       + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)} ");
    entrada.setInt(1, cliente.getNumeroCedula());
    entrada.setString(2, cliente.getNombre());
    entrada.setString(3, cliente.getContrasenia());
    entrada.setString(4, cliente.getCorreoElectronico());
    entrada.setString(5, cliente.getNombreUsuario());
    entrada.setString(6, cliente.getProvincia());
    entrada.setString(7, cliente.getCanton());
    entrada.setString(8, cliente.getDistrito());
    entrada.setString(9, cliente.getSenias());
    entrada.setInt(10, cliente.getTelefono());
    entrada.setString(11, cliente.getUbicacion());
    entrada.execute();
  }
  
  
  public static Cliente buscarCliente(int pCedula){
    Connection con = getConexion();
    ResultSet res;
    Cliente nuevoCliente = null;
    try{
      res = Conexion.consulta("select * from cliente where cedula = '" + pCedula + "'");
      while(res.next()){
        nuevoCliente = new Cliente(res.getInt(1), res.getString(2), res.getString(3),
           res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8),
           res.getString(9), res.getInt(10), res.getString(11));
      }
      return nuevoCliente;
    }
    catch(SQLException e){
      return nuevoCliente;
    }
  }
    
    
  public static Cliente buscarClienteCorreo(String pCorreo){
    Connection con = getConexion();
    ResultSet res;
    Cliente nuevoCliente = null;
    try{
      res = Conexion.consulta("select * from cliente where correoElectronico = '" + pCorreo + "'");
      while(res.next()){
        nuevoCliente = new Cliente(res.getInt(1), res.getString(2), res.getString(3),
           res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8),
           res.getString(9), res.getInt(10), res.getString(11));
      }
      return nuevoCliente;
    }
    catch(SQLException e){
      return nuevoCliente;
    } 
  }
}