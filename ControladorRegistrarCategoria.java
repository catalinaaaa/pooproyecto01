package controlador;

import dao.CategoriaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Categoria;
import vista.RegistrarCategoriaForm;

/**
 * @author catas
 */

public class ControladorRegistrarCategoria implements ActionListener {
  public RegistrarCategoriaForm vista;
  public CategoriaDAO dao;
  public Categoria modelo;
  
  
  public ControladorRegistrarCategoria(){
    this.vista = new RegistrarCategoriaForm();
    this.vista.btCancelar.addActionListener(this);
    this.vista.btRegistrar.addActionListener(this);
  }

  
  @Override
  public void actionPerformed(ActionEvent e){
    switch (e.getActionCommand()){
      case "Registrar":
        registro();
        break;
      case "Volver":
        cerrarVentanaRegistro();
    }
  }
  
  
  public void cerrarVentanaRegistro(){
    vista.setVisible(false);
    ControladorMenuPrincipalAdministrador M1 =  new ControladorMenuPrincipalAdministrador();
    M1.vista.setVisible(true);
  }
  
  
  public void registro(){
    if(vista.registroCategoriaDatosCorrectos()){
      String nombre = vista.txtNombre.getText();
      String descripcion = vista.txtDescripcion.getText();
      modelo = new Categoria(nombre, descripcion, "Activo");
      try{
        CategoriaDAO.nuevaCategoria(modelo);
        JOptionPane.showMessageDialog(vista, "Los datos han sido guardados correctamente.");
      }
      catch(SQLException ex){
        Logger.getLogger(RegistrarCategoriaForm.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    else{
      JOptionPane.showMessageDialog(vista, "Por favor ingrese todos los datos");
    }
  }
}