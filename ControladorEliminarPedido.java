package controlador;

import dao.PedidoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Pedido;
import utilidades.Conexion;
import vista.EliminarPedidoForm;

/**
 * @author catas
 */

public class ControladorEliminarPedido implements ActionListener{
  public EliminarPedidoForm vista;
  public PedidoDAO dao;
  public Pedido modelo;
  
  
  public ControladorEliminarPedido(){
    this.vista = new EliminarPedidoForm();
    this.vista.btnBorrar.addActionListener(this);
    this.vista.btActualizarDatos.addActionListener(this);
    cargarDatos();
  }
  
  
  @Override
  public void actionPerformed(ActionEvent e){
    switch(e.getActionCommand()){
      case "Actualizar datos":
          cargarDatos();
          break;
        case "Eliminar":
          borrarCategoria();
          break;
        default:
          break;
    }  
  }
  
  public void cargarDatos(){
    ResultSet res;  
    DefaultTableModel mod = (DefaultTableModel)vista.tablaPedidos.getModel();
    mod.setColumnCount(5);
    res = Conexion.consulta("select identificador, estado, fecha, fechaEntrega, montoTotal from"
       + "pedido");
    try{
      while(res.next()){
        Vector v = new Vector();
        v.add(res.getString(1));
        v.add(res.getString(2));
        v.add(res.getString(3));
        v.add(res.getString(4));
        mod.addRow(v);
        vista.tablaPedidos.setModel(mod);
      }  
    }
    catch(SQLException e){      
    }
  }
  
  
  public void borrarCategoria(){
    int row = vista.tablaPedidos.getSelectedRow();
    int opic = JOptionPane.showConfirmDialog(null, "Está seguro de eliminar la categoría "
       + "seleccionada?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if(opic == JOptionPane.YES_OPTION){
      try{
          PedidoDAO.eliminarPedido(Integer.parseInt(vista.tablaPedidos.getValueAt(row, 0).
             toString()));
        }           
      catch(SQLException e){
      }
    }
  }
  
  
  public boolean revisarEstado(String pEstado){
    if(pEstado.equals("En proceso") || pEstado.equals("Procesado")){
      return true;
    }
    else{
      return false;
    }
  }
}