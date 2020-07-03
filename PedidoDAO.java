package dao;

import java.sql.CallableStatement;
import java.sql.SQLException;
import utilidades.Conexion;

/**
 * @author catas
 */

public class PedidoDAO {
  
  public static void eliminarPedido(int pPedido) throws SQLException{
    CallableStatement entrada = Conexion.getConexion().prepareCall("{ call eliminarPedido(?) }");
    entrada.setInt(1, pPedido);
    entrada.execute();
  }
}