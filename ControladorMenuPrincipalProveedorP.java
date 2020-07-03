package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.MenuPrincipalProveedorPForm;

/**
 * @author catas
 */

public class ControladorMenuPrincipalProveedorP implements ActionListener{
  public MenuPrincipalProveedorPForm vista;
  
  
  public ControladorMenuPrincipalProveedorP(){
    this.vista = new MenuPrincipalProveedorPForm();
    this.vista.btnRegistrarProducto.addActionListener(this);
    this.vista.btnConsultarProducto.addActionListener(this);
    this.vista.btnEliminarProducto.addActionListener(this);
    this.vista.btnInformacionClientes.addActionListener(this);
    this.vista.btnActualizarProducto.addActionListener(this);
    this.vista.btnBitacoraPedidos.addActionListener(this);
    this.vista.btnVolver.addActionListener(this);
  }
    
    
  /*
  * método que "controla" los botones de la vista, según el botón que se selecciona,
  * la aplicación ejecutará otro método
  */
  public void actionPerformed(ActionEvent e){
    switch (e.getActionCommand()) {
      case "Registrar producto":
        abrirRegistrarProducto();
        break;
      case "Consultar productos":
        abrirConsultarProductos();
        break;
      case "Eliminar producto":
        abrirEliminarProducto();
        break;  
      case "Información de clientes":
        abrirInformacionClientes();
        break;  
      case "Actualizar información producto":
        abrirActualizarInfoProductos();
        break;  
      case "Listado de pedidos":
        abrirConsultarPedidos();
        break;
      case "Volver al LogIn":
        abrirVentanaLogIn();  
        break;  
      default:
        break;
    }
  }
  
  
  /**falta especificar*/
  public void abrirRegistrarProducto(){
    vista.setVisible(false);
    ControladorRegistrarProveedor controladorRegistrarProv = new ControladorRegistrarProveedor();
    controladorRegistrarProv.vista.setVisible(true); 
  }
  
  
  /**falta especificar*/
  public void abrirConsultarProductos(){
    vista.setVisible(false);
    ControladorConsultarProveedor controladorConsultarProv = new ControladorConsultarProveedor();
    controladorConsultarProv.vista.setVisible(true); 
  }
  
  
  /**falta*/
  public void abrirEliminarProducto(){
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
  public void abrirActualizarInfoProductos(){
    vista.setVisible(false);
    ControladorRegistrarProveedor controladorRegistrarProv = new ControladorRegistrarProveedor();
    controladorRegistrarProv.vista.setVisible(true); 
  }
  
  
  /**falta*/
  public void abrirConsultarPedidos(){
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