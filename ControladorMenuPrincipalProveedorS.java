package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.MenuPrincipalProveedorSForm;

/**
 * @author catas
 */

public class ControladorMenuPrincipalProveedorS implements ActionListener{
  public MenuPrincipalProveedorSForm vista;
  
  
  public ControladorMenuPrincipalProveedorS(){
    this.vista = new MenuPrincipalProveedorSForm();
    this.vista.btnRegistrarServicio.addActionListener(this);
    this.vista.btnConsultarServicio.addActionListener(this);
    this.vista.btnEliminarServicio.addActionListener(this);
    this.vista.btnInformacionClientes.addActionListener(this);
    this.vista.btnActualizarServicio.addActionListener(this);
    this.vista.btnBitacoraServicio.addActionListener(this);
    this.vista.btnVolver.addActionListener(this);
  }
    
    
  /*
  * método que "controla" los botones de la vista, según el botón que se selecciona,
  * la aplicación ejecutará otro método
  */
  public void actionPerformed(ActionEvent e){
    switch (e.getActionCommand()) {
      case "Registrar servicio":
        abrirRegistrarServicio();
        break;
      case "Administrar servicios":
        abrirAdministrarServicios();
        break;
      case "Eliminar servicio":
        abrirEliminarServicio();
        break;  
      case "Información de clientes":
        abrirInformacionClientes();
        break;  
      case "Actualizar información servicio":
        abrirActualizarInfoServicio();
        break;  
      case "Listado de servicios":
        abrirConsultarServicios();
        break;
      case "Volver al LogIn":
        abrirVentanaLogIn();  
        break;  
      default:
        break;
    }
  }
  

  public void abrirRegistrarServicio(){
    vista.setVisible(false);
    ControladorRegistrarServicio controladorRegistrarServicio = new ControladorRegistrarServicio();
    controladorRegistrarServicio.vista.setVisible(true); 
  }
  
  
  /**falta */
  public void abrirAdministrarServicios(){
    vista.setVisible(false);
    ControladorConsultarProveedor controladorConsultarProv = new ControladorConsultarProveedor();
    controladorConsultarProv.vista.setVisible(true); 
  }
  
  
  /**falta*/
  public void abrirEliminarServicio(){
    vista.setVisible(false);
    ControladorConsultarProveedor controladorConsultarProv = new ControladorConsultarProveedor();
    controladorConsultarProv.vista.setVisible(true); 
  }
  
  
  /** falta*/
  public void abrirInformacionClientes(){
    vista.setVisible(false);
    ControladorRegistrarProveedor controladorRegistrarProv = new ControladorRegistrarProveedor();
    controladorRegistrarProv.vista.setVisible(true); 
  }
  
  
  /**falta*/
  public void abrirActualizarInfoServicio(){
    vista.setVisible(false);
    ControladorRegistrarProveedor controladorRegistrarProv = new ControladorRegistrarProveedor();
    controladorRegistrarProv.vista.setVisible(true); 
  }
  
  
  /**falta*/
  public void abrirConsultarServicios(){
    vista.setVisible(false);
    ControladorRegistrarProveedor controladorRegistrarProv = new ControladorRegistrarProveedor();
    controladorRegistrarProv.vista.setVisible(true); 
  }
  
  
  /**falta*/
  public void abrirVentanaLogIn(){
    vista.setVisible(false);
    ControladorRegistrarProveedor controladorRegistrarProveedor = new ControladorRegistrarProveedor();
    controladorRegistrarProveedor.vista.setVisible(true); 
  }
}