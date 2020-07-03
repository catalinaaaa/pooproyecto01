package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.MenuPrincipalAdministradorForm;

/**
 * @author catas
 */

public class ControladorMenuPrincipalAdministrador implements ActionListener{
  public MenuPrincipalAdministradorForm vista;
  
  
  public ControladorMenuPrincipalAdministrador(){
    this.vista = new MenuPrincipalAdministradorForm();
    this.vista.btnRegistroProveedor.addActionListener(this);
    this.vista.btConsultarProveedor.addActionListener(this);
    this.vista.btnActualizarProveedor.addActionListener(this);
    this.vista.btnEliminarProveedor.addActionListener(this);
    this.vista.btnRegistrarCategoria.addActionListener(this);
    this.vista.btnConsultarCategoria.addActionListener(this);
    this.vista.btnRegistrarPedido.addActionListener(this);
    this.vista.btnVolver.addActionListener(this);
    this.vista.btnActualizarCategoria.addActionListener(this);
    this.vista.btnEliminarCategoria.addActionListener(this);
    this.vista.btnConsultarUsuarios.addActionListener(this);
    this.vista.btnEditarUsuarios.addActionListener(this);
    this.vista.btnConsultarPedidos.addActionListener(this);
    this.vista.btnEstadisticas.addActionListener(this);
    this.vista.btnActualizarPedido.addActionListener(this);
    this.vista.btnEliminarPedido.addActionListener(this);
    this.vista.btnNuevoAdmi.addActionListener(this);
    this.vista.btnNuevoCliente.addActionListener(this);
  }
    
    
  /**
   * método que "controla" los botones de la vista, según el botón que se selecciona, la aplicación
   * ejecutará otro método
   * @param e 
   */
  @Override
  public void actionPerformed(ActionEvent e){
    switch (e.getActionCommand()) {
      case "Registrar proveedor":
        abrirRegistrarProveedor();
        break;
      case "Consultar proveedor":
        abrirConsultarProveedor();
        break;
      case "Actualizar información proveedor":
        abrirActualizarProveedor();
        break;
      case "Eliminar proveedor":
        abrirEliminarProveedor();
        break;
      case "Registrar categoría":
        abrirRegistrarCategoria();
        break;  
      case "Consultar categoría":
        abrirConsultarCategoria();
        break;  
      case "Registrar nuevo pedido":
        abrirRegistrarPedido();
        break;  
      case "Registrar nuevo administrador":
        abrirRegistrarAdministrador();
        break;  
      case "Volver al LogIn":
        abrirVentanaLogIn();  
        break;  
      case "Actualizar categoría":
        abrirActualizarCategoria();
        break;  
      case "Eliminar categoría":
        abrirEliminarCategoria();
        break;    
      case "Consultar usuarios":
        abrirConsultarUsuarios();
        break;
      case "Editar información de usuarios":
        abrirEditarUsuarios();
        break;
      case "Consultar pedidos":
        abrirConsultarPedidos();
        break;
      case "Estadísticas":
        abrirVentanaEstadisticas();
        break;
      case "Actualizar pedido":
        abrirActualizarPedido();
        break;
      case "Eliminar pedido":
        abrirEliminarPedido();
        break;
      case "Registrar nuevo cliente":
        abrirRegistrarCliente();
        break;
      default:
        break;
    }
  }
  
  
  public void abrirRegistrarProveedor(){
    vista.setVisible(false);
    ControladorRegistrarProveedor controladorRegistrarProv = new ControladorRegistrarProveedor();
    controladorRegistrarProv.vista.setVisible(true); 
  }
  
  
  public void abrirConsultarProveedor(){
    vista.setVisible(false);
    ControladorConsultarProveedor controladorConsultarProv = new ControladorConsultarProveedor();
    controladorConsultarProv.vista.setVisible(true);
  }
  
  
  public void abrirActualizarProveedor(){
    vista.setVisible(false);
    ControladorActualizarProveedor controladorActualizarProv = new ControladorActualizarProveedor();
    controladorActualizarProv.vista.setVisible(true); 
  }
  
  
  public void abrirEliminarProveedor(){
    vista.setVisible(false);
    ControladorEliminarProveedor controladorEliminarProv = new ControladorEliminarProveedor();
    controladorEliminarProv.vista.setVisible(true); 
  }
  
  
  public void abrirRegistrarCategoria(){
    vista.setVisible(false);
    ControladorRegistrarCategoria controladorRegistrarCateg = new ControladorRegistrarCategoria();
    controladorRegistrarCateg.vista.setVisible(true); 
  }
  
  
  public void abrirConsultarCategoria(){
    vista.setVisible(false);
    ControladorConsultarCategoria controladorConsultarCateg = new ControladorConsultarCategoria();
    controladorConsultarCateg.vista.setVisible(true); 
  }
  
  /**falta*/
  public void abrirRegistrarPedido(){
    vista.setVisible(false);
    ControladorRegistrarProveedor controladorRegistrarProveedor = new ControladorRegistrarProveedor();
    controladorRegistrarProveedor.vista.setVisible(true); 
  }
  

  public void abrirVentanaLogIn(){
    vista.setVisible(false);
    ControladorMenuInicio M1 =  new ControladorMenuInicio();
    M1.vista.setVisible(true);
  }
  
  
  
  public void abrirActualizarCategoria(){
    vista.setVisible(false);
    ControladorActualizarCategoria controladorActualizarCateg = new ControladorActualizarCategoria();
    controladorActualizarCateg.vista.setVisible(true); 
  }
  
  
  public void abrirEliminarCategoria(){
    vista.setVisible(false);
    ControladorEliminarCategoria controladorEliminarCategoria = new ControladorEliminarCategoria();
    controladorEliminarCategoria.vista.setVisible(true); 
  }
  
  
  public void abrirConsultarUsuarios(){
    vista.setVisible(false);
    ControladorConsultarUsuarios controladorConsultarUsuarios = new ControladorConsultarUsuarios();
    controladorConsultarUsuarios.vista.setVisible(true); 
  }
  
  /**falta*/
  public void abrirEditarUsuarios(){
    vista.setVisible(false);
    ControladorRegistrarProveedor controladorRegistrarProveedor = new ControladorRegistrarProveedor();
    controladorRegistrarProveedor.vista.setVisible(true); 
  }
  

  public void abrirConsultarPedidos(){
    vista.setVisible(false);
    ControladorConsultarPedidos controladorConsultarPedidos = new ControladorConsultarPedidos();
    controladorConsultarPedidos.vista.setVisible(true); 
  }  
  
  /**falta*/
  public void abrirVentanaEstadisticas(){
    vista.setVisible(false);
    ControladorRegistrarProveedor controladorRegistrarProveedor = new ControladorRegistrarProveedor();
    controladorRegistrarProveedor.vista.setVisible(true); 
  }
  
  /**falta*/
  public void abrirActualizarPedido(){
    vista.setVisible(false);
    ControladorRegistrarProveedor controladorRegistrarProveedor = new ControladorRegistrarProveedor();
    controladorRegistrarProveedor.vista.setVisible(true); 
  }
  
  
  public void abrirEliminarPedido(){
    vista.setVisible(false);
    ControladorEliminarPedido controladorEliminarPedido = new ControladorEliminarPedido();
    controladorEliminarPedido.vista.setVisible(true); 
  }
  
  
  public void abrirRegistrarAdministrador(){
    vista.setVisible(false);
    ControladorRegistrarAdministrador controladorRegAdmi = new ControladorRegistrarAdministrador();
    controladorRegAdmi.vista.setVisible(true); 
  }
  
  
  public void abrirRegistrarCliente(){
    vista.setVisible(false);
    ControladorRegistrarCliente controladorRegistrarCliente = new ControladorRegistrarCliente();
    controladorRegistrarCliente.vista.setVisible(true); 
  }
}