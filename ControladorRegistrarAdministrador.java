package controlador;

import dao.AdministradorDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Administrador;
import vista.RegistrarAdministradorForm;
import vista.RegistrarCategoriaForm;

/**
 * @author catas
 */

public class ControladorRegistrarAdministrador implements ActionListener {
  public RegistrarAdministradorForm vista;
  public AdministradorDAO dao;
  public Administrador modelo;
  
  
  public ControladorRegistrarAdministrador(){
    this.vista = new RegistrarAdministradorForm();
    this.vista.btVolver.addActionListener(this);
    this.vista.btRegistrar.addActionListener(this);
  }

  
  @Override
  public void actionPerformed(ActionEvent e){
    switch (e.getActionCommand()){
      case "Registrar":
        registro();
        break;
      case "Volver":
        cerrarVentanaRegistro();
    }
  }
  
  
  public void cerrarVentanaRegistro(){
    vista.setVisible(false);
    ControladorMenuPrincipalAdministrador M1 =  new ControladorMenuPrincipalAdministrador();
    M1.vista.setVisible(true);
  }
  
  
  public void registro(){
    if(vista.registroAdmiDatosCorrectos()){
      String nombre = vista.txtNombre.getText();
      String contrasenia = vista.txtContrasenia.getText();
      String correoElectronico = vista.txtCorreoElectronico.getText();
      String usuario = vista.txtUsuario.getText();
      modelo = new Administrador(nombre, contrasenia, correoElectronico, usuario);
      try{
        AdministradorDAO.nuevoAdministrador(modelo);
        JOptionPane.showMessageDialog(vista, "Los datos han sido guardados correctamente.");
      }
      catch(SQLException ex){
        Logger.getLogger(RegistrarCategoriaForm.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    else{
      JOptionPane.showMessageDialog(vista, "Por favor ingrese todos los datos");
    }
  }
}