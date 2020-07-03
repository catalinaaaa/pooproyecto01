package controlador;

import dao.CategoriaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Categoria;
import utilidades.Conexion;
import vista.ConsultarCategoriaForm;

/**
 * @author catas
 */
public class ControladorConsultarCategoria implements ActionListener{
  public ConsultarCategoriaForm vista;
  public CategoriaDAO dao;
  public Categoria modelo;
  
  
  public ControladorConsultarCategoria(){
    this.vista = new ConsultarCategoriaForm();
    this.vista.btnBuscar.addActionListener(this);
    this.vista.btCancelar.addActionListener(this);
  }
  
  
  /*
  * método que "controla" los botones de la vista, según el botón que se selecciona,
  * la aplicación ejecutará otro método
  */
  @Override
  public void actionPerformed(ActionEvent e){
    switch(e.getActionCommand()){
      case "Buscar":
        buscarCategoria();  
        break;
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
  
  
  public void buscarCategoria(){
    if(vista.consultarCategoriaDatosCorrectos() == false){
      JOptionPane.showMessageDialog(null, "Por favor introduzca el nombre de la categoría por"
         + " consultar", "Error", JOptionPane.ERROR_MESSAGE);
      vista.txtNombreBuscar.setText("");
      vista.txtNombreBuscar.requestFocus();
    }
    else{
      try{
        String nombre;
        nombre = vista.txtNombreBuscar.getText();
        ResultSet res = Conexion.consulta("select * from categoria where nombre = '" + nombre + "'");
        while(res.next()){
          if(res.getString(2).equals(nombre)){
            JOptionPane.showMessageDialog(null, "Datos encontrados");
            vista.txtCodigo.setText(res.getString(1));
            vista.txtNombre.setText(res.getString(2));
            vista.txtDescripcion.setText(res.getString(3));
            vista.txtEstado.setText(res.getString(4));
          }  
        }
      }
      catch(SQLException e){
        JOptionPane.showMessageDialog(null, "No se encontraron datos");
      }
    }
  } 
}