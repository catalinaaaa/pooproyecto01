package controlador;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.EngineOptions;
import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;
import com.teamdev.jxbrowser.view.swing.BrowserView;
import dao.ProveedorDAO;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import modelo.Proveedor;
import utilidades.Conexion;
import vista.ConsultarProveedorForm;

/**
 * @author catas
 */

public class ControladorConsultarProveedor implements ActionListener{
  public ConsultarProveedorForm vista;
  public ProveedorDAO dao;
  public Proveedor modelo;
  
  
  public ControladorConsultarProveedor(){
    this.vista = new ConsultarProveedorForm();
    this.vista.btnBuscar.addActionListener(this);
    this.vista.btCancelar.addActionListener(this);
    this.vista.btnMostrarUbicacion.addActionListener(this);
  }
  
  
  /*
  * método que "controla" los botones de la vista, según el botón que se selecciona,
  * la aplicación ejecutará otro método
  */
  @Override
  public void actionPerformed(ActionEvent e){
    switch(e.getActionCommand()){
      case "Buscar":
        buscarProveedor();  
        break;
      case "Mostrar ubicación":
        mostrar();  
        break;
      case "Volver":
        volverMenu();
        break;  
      default:
        break;  
    }  
  }
  
  
  public void buscarProveedor(){
    if(vista.registroCategoriaDatosCorrectos() == false){
      JOptionPane.showMessageDialog(null, "Por favor introduzca el nombre del proveedor", "Error",
         JOptionPane.ERROR_MESSAGE);
      vista.txtNombreBuscar.setText("");
      vista.txtNombreBuscar.requestFocus();
    }
    else{
      try{
        String nombre;
        ProveedorDAO.buscarProveedor(vista.txtNombreBuscar.getText());
        nombre = vista.txtNombreBuscar.getText();
        ResultSet res = Conexion.consulta("select * from proveedor");
        while(res.next()){
          if(res.getString(3).equals(nombre)){
            JOptionPane.showMessageDialog(null, "Datos encontrados");
            vista.txtCedu.setText((res.getString(1)));
            vista.txtIdentificador.setText(res.getString(2));
            vista.txtNombre.setText((res.getString(3)));
            vista.txtCorreoElectronico.setText(res.getString(5));
            vista.txtNombreUsuario.setText((res.getString(6)));
            vista.txtProvincia.setText(res.getString(7));
            vista.txtCanton.setText((res.getString(8)));
            vista.txtDistrito.setText(res.getString(9));
            vista.txtSenias.setText((res.getString(10)));
            vista.txtTelefono.setText(res.getString(11));
            vista.txtSitioWeb.setText((res.getString(12)));
            vista.txtHorario.setText(res.getString(13));
            vista.txtRedesSociales.setText(res.getString(15));
            vista.txtCalificacion.setText((res.getString(16)));
            vista.txtTipoProveedor.setText(res.getString(17));
          }  
        }
      }
      catch(SQLException e){
        JOptionPane.showMessageDialog(null, "No se encontraron datos");
      }
    }
  } 
  
  
  public void mostrar(){
    EngineOptions options = EngineOptions.newBuilder(HARDWARE_ACCELERATED).licenseKey
       ("1BNDHFSC1FVUOYX43HYU5P37VKX2TXSLQ2HJKPJ1ULC6IRXN65KGAXNMZSXX22CU4U1ACJ ").build();
    com.teamdev.jxbrowser.engine.Engine engine = com.teamdev.jxbrowser.engine.Engine.newInstance
       (options);
    Browser browser = engine.newBrowser();

    SwingUtilities.invokeLater(() -> {
      // Creating Swing component for rendering web content
      // loaded in the given Browser instance.
      BrowserView view = BrowserView.newInstance(browser);

      // Creating and displaying Swing app frame.
      JFrame frame = new JFrame("Ubicación");
      // Close Engine and onClose app window
      frame.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
          engine.close();
        }
      });
      frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
      JTextField addressBar = new JTextField("https://www.google.com/maps/search/?api=1&query=" 
         + vista.txtCanton.getText() + "," + vista.txtProvincia.getText());
      addressBar.setEditable(false);
      addressBar.addActionListener(e ->
              browser.navigation().loadUrl(addressBar.getText()));
      frame.add(addressBar, BorderLayout.NORTH);
      frame.add(view, BorderLayout.CENTER);
      frame.setSize(800, 500);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
    });
  }
  
  
  public void volverMenu(){
    vista.setVisible(false);
    ControladorMenuPrincipalAdministrador M1 =  new ControladorMenuPrincipalAdministrador();
    M1.vista.setVisible(true);
  }
}