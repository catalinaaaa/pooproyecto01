package controlador;

import dao.ServicioDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Servicio;
import vista.RegistrarServicioForm;

/**
 * @author catas
 */

public class ControladorRegistrarServicio implements ActionListener {
  public RegistrarServicioForm vista;
  public ServicioDAO dao;
  public Servicio modelo;
  
  
  public ControladorRegistrarServicio(){
    this.vista = new RegistrarServicioForm();
    this.vista.btCancelar.addActionListener(this);
    this.vista.btRegistrar.addActionListener(this);
  }
  
  
  public void actionPerformed(ActionEvent e){
    switch (e.getActionCommand()) {
      case "Registrar":
        registro();
        break;
      case "Cancelar":
        cerrarVentanaRegistro();
        break;
      default:
        break;
    }
  }
  
  
  public void registro(){
    if (vista.registroServicioDatosCorrectos() == true){
      String identificador = vista.txtIdentificador.getText();
      String nombre = vista.txtNombre.getText();
      String descripcion = vista.txtDescripcion.getText();
      int categoria = Integer.parseInt(vista.txtCategoria.getText());
      double costo = Integer.parseInt(vista.txtCosto.getText());
      int proveedor = Integer.parseInt(vista.txtProveedor.getText());
      modelo = new Servicio(identificador, nombre, descripcion, categoria, costo, proveedor);
      try{
        ServicioDAO.nuevoServicio(modelo);  
        JOptionPane.showMessageDialog(vista, "Los datos han sido guardados correctamente");
      }
      catch(SQLException ex) {
        Logger.getLogger(RegistrarServicioForm.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    else{
      JOptionPane.showMessageDialog(vista, "Todos los datos son requeridos");
    }
  }
  
 
  public void cerrarVentanaRegistro(){
    vista.cancelarRegistro();
  }
}