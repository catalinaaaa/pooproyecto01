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
import vista.ActualizarCategoriaForm;

/**
 * @author catas
 */

public class ControladorActualizarCategoria implements ActionListener{
  public ActualizarCategoriaForm vista;
  public CategoriaDAO dao;
  public Categoria modelo;
  
  
  public ControladorActualizarCategoria(){
    this.vista = new ActualizarCategoriaForm();
    this.vista.btnBuscar.addActionListener(this);
    this.vista.btnActualizarNombre.addActionListener(this);
    this.vista.btnActualizarDescripcion.addActionListener(this);
    this.vista.btnCambiarEstado.addActionListener(this);
    this.vista.btnVolver.addActionListener(this);
    this.vista.btnCargarDatos.addActionListener(this);
  }
  
  
  public void actionPerformed(ActionEvent e){
    switch(e.getActionCommand()){
      case "Buscar":
        buscarCategoria();  
        break;
      case "Actualizar nombre":
        actualizarNombre();  
        break;
      case "Actualizar descripción":
        actualizarDescripcion();  
        break;
      case "Cambiar estado de categoría":
        cambiarEstadoCategoria();  
        break;
      case "Volver":
        abrirVolverVentanaAnterior();  
        break;  
      case "Cargar datos":
        cargarDatos();  
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
    if(!vista.txtNuevoNombre.getText().equals("")){
      cargarDatosNombre();
    }  
    if(vista.txtNuevoNombre.getText().equals("") && !vista.txtDescripcionNueva.getText().equals("")){
      cargarDatosDescripcion();
    }
    if(vista.txtNuevoNombre.getText().equals("") && vista.txtDescripcionNueva.getText().equals("")){
      cargarDatosEstado();
    }
  }
  
  
  public void cargarDatosNombre(){
    String nombre = vista.txtNuevoNombre.getText(); 
    DefaultTableModel mod = (DefaultTableModel)vista.tablaCategorias.getModel();
    mod.setColumnCount(4);
    ResultSet res = Conexion.consulta("select codigo, nombre, descripcion, estado from categoria"
         + " where nombre = '" + nombre + "'");
    try{
      while(res.next()){
        Vector v = new Vector();
        v.add(res.getInt(1));
        v.add(res.getString(2));
        v.add(res.getString(3));
        v.add(res.getString(4));
        mod.addRow(v);
        vista.tablaCategorias.setModel(mod);
      }  
    }
    catch(SQLException e){
      System.out.println(e);
    }
  }
  
  
  public void cargarDatosEstado(){
    String nombre = vista.txtNombreBuscar.getText(); 
    DefaultTableModel mod = (DefaultTableModel)vista.tablaCategorias.getModel();
    mod.setColumnCount(4);
    ResultSet res = Conexion.consulta("select codigo, nombre, descripcion, estado from categoria"
         + " where nombre = '" + nombre + "'");
    try{
      while(res.next()){
        Vector v = new Vector();
        v.add(res.getInt(1));
        v.add(res.getString(2));
        v.add(res.getString(3));
        v.add(res.getString(4));
        mod.addRow(v);
        vista.tablaCategorias.setModel(mod);
      }  
    }
    catch(SQLException e){
      System.out.println(e);
    }
  }
  
  
  public void cargarDatosDescripcion(){
    String descripcion = vista.txtDescripcionNueva.getText(); 
    DefaultTableModel mod = (DefaultTableModel)vista.tablaCategorias.getModel();
    mod.setColumnCount(4);
    ResultSet res = Conexion.consulta("select codigo, nombre, descripcion, estado from categoria"
         + " where descripcion = '" + descripcion + "'");
    try{
      while(res.next()){
        Vector v = new Vector();
        v.add(res.getInt(1));
        v.add(res.getString(2));
        v.add(res.getString(3));
        v.add(res.getString(4));
        mod.addRow(v);
        vista.tablaCategorias.setModel(mod);
      }  
    }
    catch(SQLException e){
      System.out.println(e);
    }
  }
  
  
  public void buscarCategoria(){
    if(vista.actualizarProveedorDatosCorrectos() == false){
      JOptionPane.showMessageDialog(null, "Por favor introduzca el nombre de la categoría", "Error",
         JOptionPane.ERROR_MESSAGE);
      vista.txtNombreBuscar.setText("");
      vista.txtNombreBuscar.requestFocus();
    }
    else{
      String nombre = vista.txtNombreBuscar.getText(); 
      DefaultTableModel mod = (DefaultTableModel)vista.tablaCategorias.getModel();
      mod.setColumnCount(4);
      ResultSet res = Conexion.consulta("select codigo, nombre, descripcion, estado from categoria"
         + " where nombre = '" + nombre + "'");
      try{
        while(res.next()){
          Vector v = new Vector();
          v.add(res.getInt(1));
          v.add(res.getString(2));
          v.add(res.getString(3));
          v.add(res.getString(4));
          mod.addRow(v);
          vista.tablaCategorias.setModel(mod);
        }  
      }
      catch(SQLException e){
        System.out.println(e);
      }
    }
  } 
  
  
  public void actualizarNombre(){
    if(vista.nombreNuevoDatosCorrectos() == true){
      String nombre = vista.txtNuevoNombre.getText();  
      String nombreViejo = vista.txtNombreBuscar.getText();
      try{
        CategoriaDAO.actualizarCategoriaNombre(nombre, nombreViejo);
        JOptionPane.showMessageDialog(vista, "El nombre ha sido actualizado correctamente");
        vista.txtDescripcionNueva.setText("");
        vista.txtDescripcionNueva.requestFocus();
      }
      catch(SQLException e){   
      }
    }
    else{
      JOptionPane.showMessageDialog(vista, "Por favor ingrese el nuevo nombre");
    }
  }
  
  
  public void actualizarDescripcion(){
    if(vista.descripcionNuevaDatosCorrectos() == true){
      String descripcion = vista.txtDescripcionNueva.getText();  
      String nombreViejo = vista.txtNombreBuscar.getText();
      try{
        CategoriaDAO.actualizarCategoriaDescripcion(descripcion, nombreViejo);
        JOptionPane.showMessageDialog(vista, "La descripción ha sido actualizada correctamente");
        vista.txtNuevoNombre.setText("");
        vista.txtNuevoNombre.requestFocus();
      }
      catch(SQLException e){   
      }
    }
    else{
      JOptionPane.showMessageDialog(vista, "Por favor ingrese la nueva descripción");
    }
  } 
  
  
  public void cambiarEstadoCategoria(){
    vista.txtNuevoNombre.setText("");
    vista.txtNuevoNombre.requestFocus();
    vista.txtDescripcionNueva.setText("");
    vista.txtDescripcionNueva.requestFocus();
    String nombre = vista.txtNombreBuscar.getText();
    String estado = CategoriaDAO.buscarCategoria(nombre).getEstado();
    if(estado.equals("Activa")){
      try{
        CategoriaDAO.actualizarCategoriaEstado("Inactiva", nombre);
        JOptionPane.showMessageDialog(vista, "El estado ha sido actualizado correctamente");
      }
      catch(SQLException e){   
        System.out.println(e);
      }      
    }
    if(estado.equals("Inactiva")){
      try{
        CategoriaDAO.actualizarCategoriaEstado("Activa", nombre);
        JOptionPane.showMessageDialog(vista, "El estado ha sido actualizado correctamente");
      }
      catch(SQLException e){ 
        System.out.println(e);
      }     
    }
  } 
}