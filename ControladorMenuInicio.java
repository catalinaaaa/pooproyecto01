package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.MenuInicioForm;

/**
 * @author catas
 */

public class ControladorMenuInicio implements ActionListener{
  public MenuInicioForm vista;
  
  
  public ControladorMenuInicio(){
    this.vista = new MenuInicioForm();
    this.vista.btnAdmin.addActionListener(this);
    this.vista.btnCliente.addActionListener(this);
    this.vista.btnProveedor.addActionListener(this);
    this.vista.btnCancelar.addActionListener(this);
  }
    
    
  /*
  * método que "controla" los botones de la vista, según el botón que se selecciona,
  * la aplicación ejecutará otro método
  */
  public void actionPerformed(ActionEvent e){
    switch (e.getActionCommand()) {
      case "Administrador":
        abrirLogInAdmin();
        break;
      case "Cliente":
        abrirLogInCliente();
        break;
      case "Proveedor":
        abrirLogInProveedor();
        break;
      case "Cancelar":
        cancelar();
        break;  
      default:
        break;
    }
  }
  
  
  public void abrirLogInAdmin(){
    vista.setVisible(false);
    ControladorLogInAdmi CLogInAdmi = new ControladorLogInAdmi();
    CLogInAdmi.vista.setVisible(true);
  }
  
  
  public void abrirLogInCliente(){
    vista.setVisible(false);
    ControladorLogInCliente LogCliente = new ControladorLogInCliente();
    LogCliente.vista.setVisible(true);
  }
  
  
  public void abrirLogInProveedor(){
    vista.setVisible(false);
    ControladorLogInProveedor LogProv = new ControladorLogInProveedor();
    LogProv.vista.setVisible(true);
  }
  
  public void cancelar(){
      System.exit(0);
  } 
}