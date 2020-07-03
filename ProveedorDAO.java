package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Proveedor;
import utilidades.Conexion;
import static utilidades.Conexion.getConexion;

/**
 * @author catas
 */

public class ProveedorDAO {
  public static void nuevoProveedor(Proveedor proveedor) throws SQLException{
    Connection con = getConexion();
    CallableStatement entrada = con.prepareCall(" { call nuevoProveedor (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)} ");
    entrada.setInt(1, proveedor.getCedula());
    entrada.setString(2, proveedor.getIdentificador());
    entrada.setString(3, proveedor.getNombre());
    entrada.setString(4, proveedor.getContrasenia());
    entrada.setString(5, proveedor.getCorreoElectronico());
    entrada.setString(6, proveedor.getNombreUsuario());
    entrada.setString(7, proveedor.getProvincia());
    entrada.setString(8, proveedor.getCanton());
    entrada.setString(9, proveedor.getDistrito());
    entrada.setString(10, proveedor.getSenias());
    entrada.setInt(11, proveedor.getTelefono());
    entrada.setString(12, proveedor.getSitioWeb());
    entrada.setString(13, proveedor.getHorarioAtencion());
    entrada.setString(14, proveedor.getUbicacion());
    entrada.setString(15, proveedor.getRedesSociales());
    entrada.setString(16, proveedor.getTipoProveedor());
    entrada.execute();
  }
  
  
  public static Proveedor buscarProveedor(String pNombre){
    Connection con = getConexion();
    ResultSet res;
    Proveedor nuevoProveedor = null;
    try{
      res = Conexion.consulta("select * from proveedor where nombre = '" + pNombre + "'");
      while(res.next()){
        nuevoProveedor = new Proveedor(res.getInt(1), res.getString(2), res.getString(3),
           res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8),
           res.getString(9), res.getInt(10), res.getString(11), res.getString(12), 
           res.getString(13), res.getString(14), res.getInt(15), res.getString(16));
      }
      return nuevoProveedor;
    }
    catch(SQLException e){
      System.out.print(e);
      return nuevoProveedor;
    } 
  }
  
  
  public static void eliminarProveedor(int pCedula) throws SQLException{
    CallableStatement entrada = Conexion.getConexion().prepareCall("{ call eliminarProveedor(?) }");
    entrada.setInt(1, pCedula);
    entrada.execute();
  }
  
  
  public static void actualizarProveedorNombre(String pNombreNuevo, String pNombreViejo)
     throws SQLException{
    Connection con = getConexion();
    CallableStatement entrada = con.prepareCall("{ call actualizarProveedorNombre(?, ?) }");
    entrada.setString(1, pNombreNuevo);
    entrada.setString(2, pNombreViejo);
    entrada.execute();
  }
  
  
  public static void actualizarProveedorTelefono(int pTelefono, String pNombre) throws SQLException{
    Connection con = getConexion();
    CallableStatement entrada = con.prepareCall("{ call actualizarProveedorTelefono(?, ?) }");
    entrada.setInt(1, pTelefono);
    entrada.setString(2, pNombre);
    entrada.execute();
  }
  
  
  public static void actualizarProveedorCorreo(String pCorreo, String pNombre) throws SQLException{
    Connection con = getConexion();
    CallableStatement entrada = con.prepareCall("{ call actualizarProveedorCorreo(?, ?) }");
    entrada.setString(1, pCorreo);
    entrada.setString(2, pNombre);
    entrada.execute();
  }
   
  
  public static void actualizarProveedorSitio(String pSitio, String pNombre) throws SQLException{
    Connection con = getConexion();
    CallableStatement entrada = con.prepareCall("{ call actualizarProveedorSitio(?, ?) }");
    entrada.setString(1, pSitio);
    entrada.setString(2, pNombre);
    entrada.execute();
  }
   
  
  public static void actualizarProveedorRedes(String pRedes, String pNombre) throws SQLException{
    Connection con = getConexion();
    CallableStatement entrada = con.prepareCall("{ call actualizarProveedorRedes(?, ?) }");
    entrada.setString(1, pRedes);
    entrada.setString(2, pNombre);
    entrada.execute();
  }
}