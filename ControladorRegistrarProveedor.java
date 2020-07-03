package controlador;

import dao.ProveedorDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Proveedor;
import vista.RegistrarProveedorForm;

/**
 * @author catas
 */

public class ControladorRegistrarProveedor implements ActionListener{
  public RegistrarProveedorForm vista;
  public ProveedorDAO dao;
  public Proveedor modelo;
  
  
  public ControladorRegistrarProveedor(){
    this.vista = new RegistrarProveedorForm();
    this.vista.btCancelar.addActionListener(this);
    this.vista.btRegistrar.addActionListener(this);
  }
  
  
  public void actionPerformed(ActionEvent e){
    switch (e.getActionCommand()) {
      case "Registrar":
        registro();
        break;
      case "Volver atrás":
        cerrarVentanaRegistro();
        break;
      default:
        break;
    }
  }
  
  
  public void registro(){
    if(vista.registroClienteDatosCorrectos()){
      int cedula = Integer.parseInt(vista.txtCedula.getText());
      String identificador = vista.txtIdentificador.getText();
      String nombre = vista.txtNombre.getText();
      String contrasenia = vista.txtContrasenia.getText();
      String correo = vista.txtCorreo.getText();
      String usuario = vista.txtUsuario.getText();
      String provincia = vista.txtProvincia.getText();
      String canton = vista.txtCanton.getText();
      String distrito = vista.txtDistrito.getText();
      String senias = vista.txtSenias.getText();
      int telefono = Integer.parseInt(vista.txtTelefono.getText());
      String sitioWeb = vista.txtSitioWeb.getText();
      String horarioAtencion = vista.txtHorario.getText();
      String ubicacion = "https://www.google.com/maps/search/?api=1&query=" + distrito + "," +
         canton + "," + provincia;
      String redesSociales = vista.txtRedesSociales.getText();
      String tipoProveedor = vista.comboTipoProveedor.getSelectedItem().toString();
      modelo = new Proveedor(cedula, identificador, nombre, contrasenia, correo, usuario, provincia,
         canton, distrito, senias, telefono, sitioWeb, horarioAtencion, ubicacion, redesSociales,
         tipoProveedor);
      try{
        ProveedorDAO.nuevoProveedor(modelo);
        JOptionPane.showMessageDialog(vista, "Los datos han sido guardados correctamente");
      }
      catch(SQLException ex){
        System.out.print(ex);
        JOptionPane.showMessageDialog(vista, "Todos los datos son requeridos");
      }
    }
  }
   
  
  
  public void cerrarVentanaRegistro(){
    vista.setVisible(false);
    ControladorMenuPrincipalAdministrador M1 =  new ControladorMenuPrincipalAdministrador();
    M1.vista.setVisible(true);
  }
}