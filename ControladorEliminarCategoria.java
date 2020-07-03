package controlador;

import dao.CategoriaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Categoria;
import utilidades.Conexion;
import vista.EliminarCategoriaForm;

/**
 * @author catas
 */

public class ControladorEliminarCategoria implements ActionListener{
  public EliminarCategoriaForm vista;
  public CategoriaDAO dao;
  public Categoria modelo;
  
  public ControladorEliminarCategoria(){
    this.vista = new EliminarCategoriaForm();
    this.vista.btnBorrar.addActionListener(this);
    this.vista.btnCancelar.addActionListener(this);
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
        case "Volver":
        abrirVolverVentanaAnterior();  
        break;  
        default:
          break;
    }  
  }
  
  
  public void abrirVolverVentanaAnterior(){
    vista.setVisible(false);
    ControladorMenuPrincipalAdministrador M1 =  new ControladorMenuPrincipalAdministrador();
    M1.vista.setVisible(true);
  }
  
  
  public void cargarDatos(){
    ResultSet res;  
    DefaultTableModel mod = (DefaultTableModel)vista.tablaCategoría.getModel();
    mod.setColumnCount(4);
    res = Conexion.consulta("select codigo, nombre, descripcion, estado from categoria");
    try{
      while(res.next()){
        Vector v = new Vector();
        v.add(res.getString(1));
        v.add(res.getString(2));
        v.add(res.getString(3));
        v.add(res.getString(4));
        mod.addRow(v);
        vista.tablaCategoría.setModel(mod);
      }  
    }
    catch(SQLException e){      
    }
  }
  
  
  public void borrarCategoria(){
    int row = vista.tablaCategoría.getSelectedRow();
    int opic = JOptionPane.showConfirmDialog(null, "Está seguro de eliminar la categoría "
       + "seleccionada?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if(opic == JOptionPane.YES_OPTION){
      try{
        CategoriaDAO.eliminarCategoria(Integer.parseInt(vista.tablaCategoría.getValueAt(row, 0).
           toString()));
      }  
      catch(SQLException e){
      }
    }  
  }
}
