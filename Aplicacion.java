package controlador;

import javax.swing.JOptionPane;
import vista.MenuInicioForm;

/**
 * @author Dell
 */

public class Aplicacion {

  public static void main(String[] args) {
    utilidades.Conexion.getConexion();
    ControladorMenuInicio M1 =  new ControladorMenuInicio();
    MenuInicioForm vista =  new MenuInicioForm();
    JOptionPane.showMessageDialog(null, "La conexión ha sido exitosa");
    M1.vista.setVisible(true);
    }
}