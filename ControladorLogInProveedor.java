package controlador;

import dao.ProveedorDAO;
import modelo.Proveedor;
import vista.LogInProovedorForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import vista.MenuInicioForm;
import vista.MenuPrincipalProveedorPForm;
import vista.MenuPrincipalProveedorSForm;

/**
 * @author Dell
 */

public class ControladorLogInProveedor implements ActionListener{
  public LogInProovedorForm vista;
  public ProveedorDAO dao;
  public Proveedor modelo;
  public int cont;
    
  
  public ControladorLogInProveedor(){
    this.vista = new LogInProovedorForm();
    this.vista.btIngresarLogIn.addActionListener(this);
    this.vista.btCancelarLogIn.addActionListener(this);
    this.vista.CbTipo.addActionListener(this);
  }
   
     
  public void actionPerformed(ActionEvent e){
    switch (e.getActionCommand()) {
      case "Ingresar":
        ingresarProveedor();
        break;
      case "Cancelar":
        cerrarVentanaLogIn();
        break;
      default:
        break;
    }
  } 
     
   
  public void ingresarProveedor(){
    String consulta = "select count(nombreUsuario) from proveedor where nombreUsuario = '"
       + this.vista.txtCorreo.getText() + "' and convert(char(200),"
       + "DecryptByPassPhrase('llave', contrasenia))= '" + this.vista.txtContraseña.getText() + "'";
    ResultSet res = utilidades.Conexion.consulta(consulta);
    try{
      while (res.next()){
        cont = res.getInt(1);
      }
    }
    catch (SQLException e){
    }
    if (cont >= 1){
      if ("Servicios".equals(String.valueOf(vista.CbTipo.getSelectedItem()))){
        vista.setVisible(false);
        ControladorMenuPrincipalProveedorS menuAdmi = new ControladorMenuPrincipalProveedorS();
        menuAdmi.vista.setVisible(true);
      }
      if ("Productos".equals(String.valueOf(vista.CbTipo.getSelectedItem()))){
        vista.setVisible(false);
        ControladorMenuPrincipalProveedorP menuAdmi = new ControladorMenuPrincipalProveedorP();
        menuAdmi.vista.setVisible(true);
      }
    }
    else{
      JOptionPane.showMessageDialog(this.vista, "Este usuario no existe", "Informacion",
         JOptionPane.INFORMATION_MESSAGE);
    }
  }
    
  
  public void cerrarVentanaLogIn(){
    vista.setVisible(false);
    MenuInicioForm c1 = new MenuInicioForm();
    ControladorMenuInicio M1 =  new ControladorMenuInicio();
    M1.vista.setVisible(true);
  } 
}