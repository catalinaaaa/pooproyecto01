package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.MenuPrincipalClienteForm;

/**
 * @author catas
 */

public class ControladorMenuPrincipalCliente implements ActionListener{
  public MenuPrincipalClienteForm vista;
  
  
  public ControladorMenuPrincipalCliente(){
    this.vista = new MenuPrincipalClienteForm();
    this.vista.btConsultarInfo.addActionListener(this);
    this.vista.btnActualizarInfo.addActionListener(this);
    this.vista.btnConsultarPedidos.addActionListener(this);
    this.vista.btnBuscarProductos.addActionListener(this);
    this.vista.btnBuscarServicios.addActionListener(this);
    this.vista.btnVolver.addActionListener(this);
  }
    
    
  /*
  * método que "controla" los botones de la vista, según el botón que se selecciona,
  * la aplicación ejecutará otro método
  */
  public void actionPerformed(ActionEvent e){
    switch (e.getActionCommand()) {
      case "Consultar información":
        abrirConsultarInformacion();
        break;
      case "Actualizar información":
        abrirActualizarInformacion();
        break;
      case "Consultar pedidos":
        abrirConsultarPedidos();
        break;  
      case "Buscar productos":
        abrirBuscarProductos();
        break;  
      case "Buscar servicios":
        abrirBuscarServicios();
        break;  
      case "Volver al LogIn":
        abrirVentanaLogIn();  
        break;  
      default:
        break;
    }
  }
  
  
  
  public void abrirConsultarInformacion(){
//    vista.setVisible(false);
    ControladorConsultarDatosPersonalesCliente controladorDatosCliente = new ControladorConsultarDatosPersonalesCliente();
    controladorDatosCliente.vista.setVisible(true); 
  }
  
  
  /**falta*/
  public void abrirActualizarInformacion(){
    vista.setVisible(false);
    ControladorConsultarProveedor controladorConsultarProv = new ControladorConsultarProveedor();
    controladorConsultarProv.vista.setVisible(true); 
  }
  
  
  /**falta*/
  public void abrirConsultarPedidos(){
    vista.setVisible(false);
    ControladorConsultarProveedor controladorConsultarProv = new ControladorConsultarProveedor();
    controladorConsultarProv.vista.setVisible(true); 
  }
  
  
  /** falta*/
  public void abrirBuscarProductos(){
    vista.setVisible(false);
    ControladorRegistrarProveedor controladorRegistrarProv = new ControladorRegistrarProveedor();
    controladorRegistrarProv.vista.setVisible(true); 
  }
  
  
  /**falta*/
  public void abrirBuscarServicios(){
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