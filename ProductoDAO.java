package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import modelo.Producto;
import static utilidades.Conexion.getConexion;

/**
 * @author catas
 */

public class ProductoDAO {
  
  
  public static void nuevoProducto(Producto producto) throws SQLException{
    Connection con = getConexion();
    CallableStatement entrada = con.prepareCall("{ call nuevoProducto(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
    entrada.setString(1, producto.getIdProducto());
    entrada.setString(2, producto.getNombre());
    entrada.setString(3, producto.getDescripcion());
    entrada.setInt(4, producto.getCategoria());
    entrada.setInt(5, producto.getCantidad());
    entrada.setDouble(6, producto.getCostoUnitario());
    entrada.setDouble(7, producto.getCostoEntrega());
    entrada.setString(8, producto.getEstado());
    entrada.setInt(9, producto.getVendedor());
    entrada.setBytes(10, producto.getFotografia());
    entrada.execute();
  }
}