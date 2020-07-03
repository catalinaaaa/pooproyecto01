package controlador;

import dao.AdministradorDAO;
import dao.ClienteDAO;
import dao.ProveedorDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Administrador;
import modelo.Cliente;
import modelo.Proveedor;
import utilidades.Conexion;
import vista.ConsultarUsuariosForm;

/**
 * @author catas
 */
public class ControladorConsultarUsuarios implements ActionListener{
  public ConsultarUsuariosForm vista;
  public AdministradorDAO daoAdministrador;
  public ClienteDAO daoCliente;
  public ProveedorDAO daoProveedor;
  public Administrador modeloAdministrador;
  public Cliente modeloCliente;
  public Proveedor modeloProveedor;
  
  
  public ControladorConsultarUsuarios(){
    this.vista = new ConsultarUsuariosForm();
    this.vista.btnCancelar.addActionListener(this);
    cargarTablaAdministradores();
    cargarTablaProveedores();
    cargarTablaClientes();
  }
  
  
  /*
  * método que "controla" los botones de la vista, según el botón que se selecciona,
  * la aplicación ejecutará otro método
  */
  @Override
  public void actionPerformed(ActionEvent e){
    switch(e.getActionCommand()){
      case "Volver":
        cerrarVentanaConsultar();  
        break;  
      default:
        break;  
    }  
  }
  
  
  public void cerrarVentanaConsultar(){
    vista.setVisible(false);
    ControladorMenuPrincipalAdministrador M1 =  new ControladorMenuPrincipalAdministrador();
    M1.vista.setVisible(true);
  }
  
  
  public void cargarTablaAdministradores(){
    ResultSet res;  
    DefaultTableModel mod = (DefaultTableModel)vista.tablaAdministradores.getModel();
    mod.setColumnCount(3);
    res = Conexion.consulta("select nombre, correoElectronico, nombreUsuario from administrador");
    try{
      while(res.next()){
        Vector v = new Vector();
        v.add(res.getString(1));
        v.add(res.getString(2));
        v.add(res.getString(3));
        mod.addRow(v);
        vista.tablaAdministradores.setModel(mod);
      }  
    }
    catch(SQLException e){   
      System.out.print(e);
    }
  }
  
  
  public void cargarTablaProveedores(){
    ResultSet res;  
    DefaultTableModel mod = (DefaultTableModel)vista.tablaProveedores.getModel();
    mod.setColumnCount(3);
    res = Conexion.consulta("select nombre, correoElectronico, tipo_proveedor from proveedor");
    try{
      while(res.next()){
        Vector v = new Vector();
        v.add(res.getString(1));
        v.add(res.getString(2));
        v.add(res.getString(3));
        mod.addRow(v);
        vista.tablaProveedores.setModel(mod);
      }  
    }
    catch(SQLException e){   
      System.out.print(e);
    }
  }
  
  
  public void cargarTablaClientes(){
    ResultSet res;  
    DefaultTableModel mod = (DefaultTableModel)vista.tablaClientes.getModel();
    mod.setColumnCount(3);
    res = Conexion.consulta("select nombre, correoElectronico, nombreUsuario from proveedor");
    try{
      while(res.next()){
        Vector v = new Vector();
        v.add(res.getString(1));
        v.add(res.getString(2));
        v.add(res.getString(3));
        mod.addRow(v);
        vista.tablaClientes.setModel(mod);
      }  
    }
    catch(SQLException e){   
      System.out.print(e);
    }
  }
}