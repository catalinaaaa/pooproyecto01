package controlador;

import dao.PedidoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import modelo.Pedido;
import utilidades.Conexion;
import vista.ConsultarPedidosForm;
import vista.ConsultarUsuariosForm;

/**
 * @author catas
 */
public class ControladorConsultarPedidos implements ActionListener{
  public ConsultarPedidosForm vista;
  public PedidoDAO dao;
  public Pedido modelo;
  
  
  public ControladorConsultarPedidos(){
    this.vista = new ConsultarPedidosForm();
    this.vista.btnCancelar.addActionListener(this);
    cargarTablaPedidos();
  }
  
  
  /*
  * método que "controla" los botones de la vista, según el botón que se selecciona,
  * la aplicación ejecutará otro método
  */
  @Override
  public void actionPerformed(ActionEvent e){
    switch(e.getActionCommand()){
      case "Volver":
        cerrarVentanaConsultar();  
        break;  
      default:
        break;  
    }  
  }
  
  
  public void cerrarVentanaConsultar(){
    vista.setVisible(false);
    ControladorMenuPrincipalAdministrador M1 =  new ControladorMenuPrincipalAdministrador();
    M1.vista.setVisible(true);
  }
  
  
  public void cargarTablaPedidos(){
    ResultSet res;  
    DefaultTableModel mod = (DefaultTableModel)vista.tablaPedidos.getModel();
    mod.setColumnCount(6);
    res = Conexion.consulta("select identificador, estado, fecha, fechaEntrega, montoTotal from "
       + "administrador");
    try{
      while(res.next()){
        Vector v = new Vector();
        v.add(res.getString(1));
        v.add(res.getString(2));
        v.add(res.getString(3));
        v.add(res.getDate(4));
        v.add(res.getDate(5));
        v.add(res.getDouble(6));
        mod.addRow(v);
        vista.tablaPedidos.setModel(mod);
      }  
    }
    catch(SQLException e){   
      System.out.print(e);
    }
  }
}