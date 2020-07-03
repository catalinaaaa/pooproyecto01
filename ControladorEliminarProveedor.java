package controlador;

import dao.ProveedorDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Proveedor;
import utilidades.Conexion;
import vista.EliminarProveedorForm;

/**
 * @author catas
 */

public class ControladorEliminarProveedor implements ActionListener{
  public EliminarProveedorForm vista;
  public ProveedorDAO dao;
  public Proveedor modelo;
  
  public ControladorEliminarProveedor(){
    this.vista = new EliminarProveedorForm();
    this.vista.btnBorrar.addActionListener(this);
    this.vista.btActualizarDatos.addActionListener(this);
    this.vista.btnCancelar.addActionListener(this);
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
        case "Volver":
          cerrarVentanaRegistro();
          break;  
        default:
          break;
    }  
  }
  
  public void cargarDatos(){
    ResultSet res;  
    DefaultTableModel mod = (DefaultTableModel)vista.tablaProveedores.getModel();
    mod.setColumnCount(6);
    res = Conexion.consulta("select cedula, identificador, nombre, telefono, "
       + "sitioWeb, calificacion from proveedor");
    try{
      while(res.next()){
        Vector v = new Vector();
        v.add(res.getInt(1));
        v.add(res.getString(2));
        v.add(res.getString(3));
        v.add(res.getInt(4));
        v.add(res.getString(5));
        v.add(res.getString(6));
        mod.addRow(v);
        vista.tablaProveedores.setModel(mod);
      }  
    }
    catch(SQLException e){   
      System.out.print(e);
    }
  }
  
  
  public void borrarCategoria(){
    int row = vista.tablaProveedores.getSelectedRow();
    int opic = JOptionPane.showConfirmDialog(null, "Está seguro de eliminar la categoría "
       + "seleccionada?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if(opic == JOptionPane.YES_OPTION){
      try{
        ProveedorDAO.eliminarProveedor(Integer.parseInt(vista.tablaProveedores.getValueAt(row, 0).
           toString()));
      }  
      catch(SQLException e){
      }
    }  
  }
  
  
  public void cerrarVentanaRegistro(){
    vista.setVisible(false);
    ControladorMenuPrincipalAdministrador M1 =  new ControladorMenuPrincipalAdministrador();
    M1.vista.setVisible(true);
  }
}