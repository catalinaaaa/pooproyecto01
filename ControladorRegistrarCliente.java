package controlador;

import dao.ClienteDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Cliente;
import vista.RegistrarClienteForm;

/**
 * @author catas
 */

public class ControladorRegistrarCliente implements ActionListener{
  public RegistrarClienteForm vista;
  public ClienteDAO dao;
  public Cliente modelo;
  
  
  public ControladorRegistrarCliente(){
    this.vista = new RegistrarClienteForm();
    this.vista.btCancelar.addActionListener(this);
    this.vista.btRegistrar.addActionListener(this);
  }
  
  
  public void actionPerformed(ActionEvent e){
    switch (e.getActionCommand()) {
      case "Registrar":
        registro();
        break;
      case "Volver":
        abrirVentanaLogIn();
        break;
      default:
        break;
    }
  }
  
  
  public void registro(){
    if(vista.registroClienteDatosCorrectos()){
      int cedula = Integer.parseInt(vista.txtCedula.getText());
      String nombre = vista.txtNombre.getText();
      String contrasenia = vista.txtContrasenia.getText();
      String correo = vista.txtCorreoElectronico.getText();
      String usuario = vista.txtUsuario.getText();
      String provincia = vista.txtProvincia.getText();
      String canton = vista.txtCanton.getText();
      String distrito = vista.txtDistrito.getText();
      String senias = vista.txtSenias.getText();
      int telefono = Integer.parseInt(vista.txtTelefono.getText());
      String ubicacion = "https://www.google.com/maps/search/?api=1&query=" + canton + ","
         + provincia;
      modelo = new Cliente(cedula, nombre, contrasenia, correo, usuario, provincia, canton, 
         distrito, senias, telefono, ubicacion);
      try{
        ClienteDAO.nuevoCliente(modelo);
        JOptionPane.showMessageDialog(vista, "Los datos han sido guardados correctamente");
      }
      catch(SQLException ex){
        JOptionPane.showMessageDialog(vista, "Todos los datos son requeridos");
      }
    }
    else{
      JOptionPane.showMessageDialog(vista, "Por favor ingrese todos los datos");
    }
  }
   
  
  public void abrirVentanaLogIn(){
    vista.setVisible(false);
    ControladorMenuInicio M1 =  new ControladorMenuInicio();
    M1.vista.setVisible(true);
  }
}