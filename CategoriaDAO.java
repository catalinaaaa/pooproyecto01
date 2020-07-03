package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Categoria;
import utilidades.Conexion;
import static utilidades.Conexion.getConexion;

/**
* @author catas
 */

public class CategoriaDAO {
 
  public static void nuevaCategoria(Categoria categoria) throws SQLException{
    Connection con = getConexion();
    CallableStatement entrada = con.prepareCall(" { call nuevaCategoria (?, ?, ?)}");
    entrada.setString(1, categoria.getNombre());
    entrada.setString(2, categoria.getDescripcion());
    entrada.setString(3, "Activa");
    entrada.execute();
  }
  
  
  public static Categoria buscarCategoria(String pNombre){
    Connection con = getConexion();
    ResultSet res;
    Categoria nuevaCategoria = null;
    try{
      res = Conexion.consulta("select * from categoria where nombre = '" + pNombre + "'");
      while(res.next()){
        nuevaCategoria = new Categoria(res.getInt(1), res.getString(2), res.getString(3), res.getString(4));
      }
      return nuevaCategoria;
    }
    catch(SQLException e){
      System.out.println(e);
      return nuevaCategoria;
    } 
  }  
  
  
  public static void eliminarCategoria(int pCodigo) throws SQLException{
    CallableStatement entrada = Conexion.getConexion().prepareCall("{ call eliminarCategoria(?) }");
    entrada.setInt(1, pCodigo);
    entrada.execute();
  }
  
  
  public static void actualizarCategoriaNombre(String pNombreNuevo, String pNombreViejo) 
     throws SQLException{
    Connection con = getConexion();
    CallableStatement entrada = con.prepareCall("{ call actualizarCategoriaNombre(?, ?) }");
    entrada.setString(1, pNombreNuevo);
    entrada.setString(2, pNombreViejo);
    entrada.execute();
  }
  
  
  public static void actualizarCategoriaDescripcion(String pDescripcion, String pNombreViejo) 
     throws SQLException{
    Connection con = getConexion();
    CallableStatement entrada = con.prepareCall("{ call actualizarCategoriaDescripcion(?, ?) }");
    entrada.setString(1, pDescripcion);
    entrada.setString(2, pNombreViejo);
    entrada.execute();
  }
  
  
  public static void actualizarCategoriaEstado(String pEstado, String pNombre) throws SQLException{
    Connection con = getConexion();
    CallableStatement entrada = con.prepareCall("{ call actualizarCategoriaEstado(?, ?) }");
    entrada.setString(1, pEstado);
    entrada.setString(2, pNombre);
    entrada.execute();
  }
}