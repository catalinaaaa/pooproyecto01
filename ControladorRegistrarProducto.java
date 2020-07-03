package controlador;

import dao.ProductoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.Producto;
import vista.RegistrarProductoForm;

/**
 * @author catas
 */

public class ControladorRegistrarProducto implements ActionListener {
  public RegistrarProductoForm vista;
  public ProductoDAO dao;
  public Producto modelo;
  
  
  public ControladorRegistrarProducto(){
    this.vista = new RegistrarProductoForm();
    this.vista.btCancelar.addActionListener(this);
    this.vista.btRegistrar.addActionListener(this);
    this.vista.btCargar.addActionListener(this);
  }
  
  
  public void actionPerformed(ActionEvent e){
    switch (e.getActionCommand()) {
      case "Registrar":
        registro();
        break;
      case "Cancelar":
        cerrarVentanaRegistro();
        break;
      case "Cargar":
          System.out.println("1");
          buscarImagen();
          break;
      default:
        break;
    }
  }
  
  
  public void registro(){
    if (vista.registroProductoDatosCorrectos() == true){
      String identificador = vista.txtIdProducto.getText();
      String nombre = vista.txtNombre.getText();
      String descripcion = vista.txtDescripcion.getText();
      int categoria = Integer.parseInt(vista.txtCategoria.getText());
      int cantidad = Integer.parseInt(vista.txtCantidad.getText());   
      int costoUnitario = Integer.parseInt(vista.txtCostoUnitario.getText());
      int costoEntrega = Integer.parseInt(vista.txtCostoEntrega.getText());   
      String estado = vista.txtEstado.getText();
      int vendedor = Integer.parseInt(vista.txtProveedor.getText());
      File foto = new File(vista.txtRuta.getText());
      modelo = new Producto(identificador, nombre, descripcion, categoria, cantidad, costoUnitario, 
         costoEntrega, estado, vendedor, convertir(foto));
      try{
        ProductoDAO.nuevoProducto(modelo);  
        JOptionPane.showMessageDialog(vista, "Los datos han sido guardados correctamente");
      }
      catch(SQLException ex) {
        Logger.getLogger(RegistrarProductoForm.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    else{
      JOptionPane.showMessageDialog(vista, "Todos los datos son requeridos");
    }
  }
  
  
  public void buscarImagen(){
      JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG, PNG & GIF","jpg","png","gif");
        j.setFileFilter(fil);
        int s = j.showOpenDialog(vista);
        if(s == JFileChooser.APPROVE_OPTION){
            String ruta = j.getSelectedFile().getAbsolutePath();
            vista.txtRuta.setText(ruta);
  }
  }
  
  public byte[] convertir(File ruta){
      try{
            byte[] icono = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(icono);
            return icono;
        }catch(Exception ex){
            return null;
        }
  }
  
  public void cerrarVentanaRegistro(){
    vista.cancelarRegistro();
  }
} 