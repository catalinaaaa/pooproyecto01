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
import vista.ActualizarProveedorForm;

/**
 * @author catas
 */

public class ControladorActualizarProveedor implements ActionListener{
  public ActualizarProveedorForm vista;
  public ProveedorDAO dao;
  public Proveedor modelo;
  
  
  public ControladorActualizarProveedor(){
    this.vista = new ActualizarProveedorForm();
    this.vista.btnBuscar.addActionListener(this);
    this.vista.btnActualizarNombre.addActionListener(this);
    this.vista.btnActualizarTelefono.addActionListener(this);
    this.vista.btnActualizarCorreo.addActionListener(this);
    this.vista.btnActualizarWeb.addActionListener(this);
    this.vista.btnActualizarRedes.addActionListener(this);
    this.vista.btnVolver.addActionListener(this);
    this.vista.btnCargarDatos.addActionListener(this);
  }
  
  
  public void actionPerformed(ActionEvent e){
    switch(e.getActionCommand()){
      case "Buscar":
        buscarProveedor();  
        break;
      case "Actualizar nombre":
        actualizarNombre();  
        break;
      case "Actualizar teléfono":
        actualizarTelefono();  
        break;
      case "Actualizar correo":
        actualizarCorreo();  
        break;
      case "Actualizar sitio":
        actualizarSitioWeb();  
        break;
      case "Actualizar redes":
        actualizarRedes();  
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
  
  
  public void cargarDatos(){
    if(!vista.txtNuevoNombre.getText().equals("")){
      cargarDatosNombre();
    }  
    if(vista.txtNuevoNombre.getText().equals("") && !vista.txtNuevoTelefono.getText().equals("")){
      cargarDatosTelefono();
    }
    if(vista.txtNuevoNombre.getText().equals("") && vista.txtNuevoTelefono.getText().equals("") &&
       !vista.txtNuevoCorreo.getText().equals("")){
      cargarDatosCorreo();
    }
    if(vista.txtNuevoNombre.getText().equals("") && vista.txtNuevoTelefono.getText().equals("") && 
    vista.txtNuevoCorreo.getText().equals("") && !vista.txtNuevoSitio.getText().equals("")){
      cargarDatosSitio();
    }
    if(vista.txtNuevoNombre.getText().equals("") && vista.txtNuevoTelefono.getText().equals("") && 
    vista.txtNuevoCorreo.getText().equals("") && vista.txtNuevoSitio.getText().equals("")
      && !vista.txtNuevasRedes.getText().equals("")){
      cargarDatosRedes();
    }    
  }
  
  
  public void cargarDatosNombre(){
    String nombre = vista.txtNuevoNombre.getText(); 
    DefaultTableModel mod = (DefaultTableModel)vista.tablaProveedores.getModel();
    mod.setColumnCount(6);
    ResultSet res = Conexion.consulta("select cedula, correoElectronico, nombre, telefono, "
       + "sitioWeb, redesSociales from proveedor where nombre = '" + nombre + "'");
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
      System.out.println(e);
    }
  }
  
  
  public void cargarDatosTelefono(){
    int telefono = Integer.parseInt(vista.txtNuevoTelefono.getText()); 
    DefaultTableModel mod = (DefaultTableModel)vista.tablaProveedores.getModel();
    mod.setColumnCount(6);
    ResultSet res = Conexion.consulta("select cedula, correoElectronico, nombre, telefono, "
       + "sitioWeb, redesSociales from proveedor where telefono = '" + telefono + "'");
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
      System.out.println(e);
    }
  }
  
  
  public void cargarDatosCorreo(){
    String correo = vista.txtNuevoCorreo.getText(); 
    DefaultTableModel mod = (DefaultTableModel)vista.tablaProveedores.getModel();
    mod.setColumnCount(6);
    ResultSet res = Conexion.consulta("select cedula, correoElectronico, nombre, telefono, "
       + "sitioWeb, redesSociales from proveedor where correoElectronico = '" + correo + "'");
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
      System.out.println(e);
    }
    catch(Exception ex){
      System.out.println(ex);
    }
  }
  
  
  public void cargarDatosSitio(){
    String sitio = vista.txtNuevoSitio.getText(); 
    DefaultTableModel mod = (DefaultTableModel)vista.tablaProveedores.getModel();
    mod.setColumnCount(6);
    ResultSet res = Conexion.consulta("select cedula, correoElectronico, nombre, telefono, "
       + "sitioWeb, redesSociales from proveedor where sitioWeb = '" + sitio + "'");
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
      System.out.println(e);
    }
    catch(Exception ex){
      System.out.println(ex);
    }
  }
  
  
  public void cargarDatosRedes(){
    String redes = vista.txtNuevasRedes.getText(); 
    DefaultTableModel mod = (DefaultTableModel)vista.tablaProveedores.getModel();
    mod.setColumnCount(6);
    ResultSet res = Conexion.consulta("select cedula, correoElectronico, nombre, telefono, "
       + "sitioWeb, redesSociales from proveedor where redesSociales = '" + redes + "'");
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
      System.out.println(e);
    }
    catch(Exception ex){
      System.out.println(ex);
    }
  }
  
  
  public void buscarProveedor(){
    if(vista.actualizarProveedorDatosCorrectos() == false){
      JOptionPane.showMessageDialog(null, "Por favor introduzca el nombre del proveedor", "Error",
         JOptionPane.ERROR_MESSAGE);
      vista.txtNombreBuscar.setText("");
      vista.txtNombreBuscar.requestFocus();
    }
    else{
      String nombre = vista.txtNombreBuscar.getText(); 
      DefaultTableModel mod = (DefaultTableModel)vista.tablaProveedores.getModel();
      mod.setColumnCount(6);
      ResultSet res = Conexion.consulta("select cedula, correoElectronico, nombre, telefono, "
         + "sitioWeb, redesSociales from proveedor where nombre = '" + nombre + "'");
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
        System.out.println(e);
      }
    }
  } 
  
  
  public void actualizarNombre(){
    if(vista.nombreNuevoDatosCorrectos() == true){
      String nombre = vista.txtNuevoNombre.getText();  
      String nombreViejo = vista.txtNombreBuscar.getText();
      try{
        ProveedorDAO.actualizarProveedorNombre(nombre, nombreViejo);
        JOptionPane.showMessageDialog(vista, "El nombre ha sido actualizado correctamente");
        vista.txtNuevoTelefono.setText("");
        vista.txtNuevoTelefono.requestFocus();
        vista.txtNuevoCorreo.setText("");
        vista.txtNuevoCorreo.requestFocus();
        vista.txtNuevoSitio.setText("");
        vista.txtNuevoSitio.requestFocus();
        vista.txtNuevasRedes.setText("");
        vista.txtNuevasRedes.requestFocus();
      }
      catch(SQLException e){   
      }
    }
    else{
      JOptionPane.showMessageDialog(vista, "Por favor ingrese el nuevo nombre");
    }
  }
  
  
  public void actualizarTelefono(){
    if(vista.telefonoNuevoDatosCorrectos() == true){
      int telefono = Integer.parseInt(vista.txtNuevoTelefono.getText());
      String nombreViejo = vista.txtNombreBuscar.getText();
      try{
        ProveedorDAO.actualizarProveedorTelefono(telefono, nombreViejo);
        JOptionPane.showMessageDialog(vista, "El teléfono ha sido actualizado correctamente");
        vista.txtNuevoNombre.setText("");
        vista.txtNuevoNombre.requestFocus();
        vista.txtNuevoCorreo.setText("");
        vista.txtNuevoCorreo.requestFocus();
        vista.txtNuevoSitio.setText("");
        vista.txtNuevoSitio.requestFocus();
        vista.txtNuevasRedes.setText("");
        vista.txtNuevasRedes.requestFocus();
      }
      catch(SQLException e){   
      }
    }
    else{
      JOptionPane.showMessageDialog(vista, "Por favor ingrese el nuevo número telefónico");
    }
  } 
  
  
  public void actualizarCorreo(){
    if(vista.correoNuevoDatosCorrectos() == true){
      String correo = vista.txtNuevoCorreo.getText(); 
      String nombreViejo = vista.txtNombreBuscar.getText();
      try{
        ProveedorDAO.actualizarProveedorCorreo(correo, nombreViejo);
        JOptionPane.showMessageDialog(vista, "El correo ha sido actualizado correctamente");
        vista.txtNuevoNombre.setText("");
        vista.txtNuevoNombre.requestFocus();
        vista.txtNuevoTelefono.setText("");
        vista.txtNuevoTelefono.requestFocus();
        vista.txtNuevoSitio.setText("");
        vista.txtNuevoSitio.requestFocus();
        vista.txtNuevasRedes.setText("");
        vista.txtNuevasRedes.requestFocus();
      }
      catch(SQLException e){   
      }
    }
    else{
      JOptionPane.showMessageDialog(vista, "Por favor ingrese el nuevo correo electrónico");
    }
  } 
  
  
  public void actualizarSitioWeb(){
    if(vista.sitioNuevoDatosCorrectos() == true){
      String sitioWeb = vista.txtNuevoSitio.getText();  
      String nombreViejo = vista.txtNombreBuscar.getText();
      try{
        ProveedorDAO.actualizarProveedorSitio(sitioWeb, nombreViejo);
        JOptionPane.showMessageDialog(vista, "El sitio web ha sido actualizado correctamente");
        vista.txtNuevoNombre.setText("");
        vista.txtNuevoNombre.requestFocus();
        vista.txtNuevoTelefono.setText("");
        vista.txtNuevoTelefono.requestFocus();
        vista.txtNuevoCorreo.setText("");
        vista.txtNuevoCorreo.requestFocus();
        vista.txtNuevasRedes.setText("");
        vista.txtNuevasRedes.requestFocus();
      }
      catch(SQLException e){   
      }
    }
    else{
      JOptionPane.showMessageDialog(vista, "Por favor ingrese el nuevo sitio web");
    }
  }
  
  
  public void actualizarRedes(){
    if(vista.redesNuevoDatosCorrectos() == true){
      String redes = vista.txtNuevasRedes.getText(); 
      String nombre = vista.txtNombreBuscar.getText();
      try{
        ProveedorDAO.actualizarProveedorRedes(redes, nombre);
        JOptionPane.showMessageDialog(vista, "Las redes sociales han sido actualizado correctamente");
        vista.txtNuevoNombre.setText("");
        vista.txtNuevoNombre.requestFocus();
        vista.txtNuevoTelefono.setText("");
        vista.txtNuevoTelefono.requestFocus();
        vista.txtNuevoCorreo.setText("");
        vista.txtNuevoCorreo.requestFocus();
        vista.txtNuevoSitio.setText("");
        vista.txtNuevoSitio.requestFocus();
      }
      catch(SQLException e){   
      }
    }
    else{
      JOptionPane.showMessageDialog(vista, "Por favor ingrese el nuevo @ de las redes sociales");
    }
  }
  
  
  public void abrirVolverVentanaAnterior(){
    vista.setVisible(false);
    ControladorMenuPrincipalAdministrador M1 =  new ControladorMenuPrincipalAdministrador();
    M1.vista.setVisible(true);
  }
}