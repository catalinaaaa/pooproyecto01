package controlador;

import dao.AdministradorDAO;
import modelo.Administrador;
import vista.LogInAdminForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import vista.MenuInicioForm;

/**
 * @author Dell
 */

public class ControladorLogInAdmi implements ActionListener{
  public LogInAdminForm vista;
  public AdministradorDAO dao;
  public Administrador modelo;
  public int cont;
    
  
  public ControladorLogInAdmi(){
    this.vista = new LogInAdminForm();
    this.vista.btIngresarLogIn.addActionListener(this);
    this.vista.btCancelarLogIn.addActionListener(this);
  }

   
  @Override
  public void actionPerformed(ActionEvent e){
    switch (e.getActionCommand()) {
      case "Ingresar":
        ingresarAdmi();
        break;
      case "Cancelar":
        cerrarVentanaLogIn();
        break;
      default:
        break;
    }
  }
   
   
  public void ingresarAdmi(){
    String consulta = "select count(nombreUsuario) from administrador where nombreUsuario = '"
       + this.vista.txtCorreo.getText() + "' and convert(char(200),"
       + " DecryptByPassPhrase('llave', contrasenia))= '" + this.vista.txtContraseña.getText() + "'";
    ResultSet res = utilidades.Conexion.consulta(consulta);
      try{
        while (res.next()){
          cont = res.getInt(1);
        }
      }
      catch (SQLException e){
      }
      if(cont >= 1){
        vista.setVisible(false);
        ControladorMenuPrincipalAdministrador menuAdmi = new ControladorMenuPrincipalAdministrador();
        menuAdmi.vista.setVisible(true);
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