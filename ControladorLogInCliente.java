package controlador;

import dao.ClienteDAO;
import modelo.Cliente;
import vista.LogInClienteForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import vista.MenuInicioForm;
import vista.MenuPrincipalClienteForm;

/**
 * @author Dell
 */

public class ControladorLogInCliente implements ActionListener{
  public LogInClienteForm vista;
  public ClienteDAO dao;
  public Cliente modelo;
  public int cont;
    

  public ControladorLogInCliente(){
    this.vista = new LogInClienteForm();
    this.vista.btIngresarLogIn.addActionListener(this);
    this.vista.btCancelarLogIn.addActionListener(this);
  }

   
  public void actionPerformed(ActionEvent e){
    switch (e.getActionCommand()) {
      case "Ingresar":
        ingresarCliente();
        break;
      case "Cancelar":
        cerrarVentanaLogIn();
        break;
      default:
        break;
    }
  }
   
   
  public void ingresarCliente(){
    String consulta = "select count(nombreUsuario) from cliente where nombreUsuario = '" 
       + this.vista.txtCorreo.getText() + "' and convert(char(200), "
       + "DecryptByPassPhrase('llave', contrasenia)) = '" + this.vista.txtContraseña.getText() + "'";
    ResultSet res = utilidades.Conexion.consulta(consulta);
    String correoElectronico = vista.txtCorreo.getText();
    Cliente hola = ClienteDAO.buscarClienteCorreo(correoElectronico);
    try{
      while (res.next()){
        cont = res.getInt(1);
      }
    }
    catch (SQLException e){
    }
    if (cont >= 1){
      vista.setVisible(false);
      ControladorMenuPrincipalCliente menuCliente = new ControladorMenuPrincipalCliente();
      menuCliente.vista.setVisible(true);
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