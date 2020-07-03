package controlador;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.EngineOptions;
import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;
import com.teamdev.jxbrowser.view.swing.BrowserView;
import dao.ClienteDAO;
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
import modelo.Cliente;
import utilidades.Conexion;
import vista.ConsultarDatosPersonalesClienteForm;

/**
 * @author catas
 */

public class ControladorConsultarDatosPersonalesCliente implements ActionListener{
  public ConsultarDatosPersonalesClienteForm vista;
  public ClienteDAO dao;
  public Cliente modelo;
  
  public ControladorConsultarDatosPersonalesCliente(){
    this.vista = new ConsultarDatosPersonalesClienteForm();
    this.vista.btVolver.addActionListener(this);
    this.vista.btnMostrarUbicacion.addActionListener(this);
    buscarCliente();
  }
  
  
  @Override
  public void actionPerformed(ActionEvent e){
    switch(e.getActionCommand()){
//      case "Volver":
//        buscarProveedor();  
//        break;
      case "Mostrar ubicación":
        mostrar();
      default:
        break;  
    }  
  }
  
  
  public void buscarCliente(){
    try{
      String correo = "hola";
//      ClienteDAO.buscarClienteCorreo(correo);
      ResultSet res = Conexion.consulta("select * from cliente where correoElectronico = '" + correo + "'");
      while(res.next()){
          JOptionPane.showMessageDialog(null, "Datos encontrados");
          vista.txtCedula.setText((res.getString(1)));
          vista.txtNombre.setText(res.getString(2));
          vista.txtContraseña.setText((res.getString(3)));
          vista.txtCorreoElectronico.setText(res.getString(4));
          vista.txtNombreUsuario.setText((res.getString(5)));
          vista.txtProvincia.setText(res.getString(6));
          vista.txtCanton.setText((res.getString(7)));
          vista.txtDistrito.setText(res.getString(8));
          vista.txtSenias.setText((res.getString(9)));
          vista.txtTelefono.setText(res.getString(10));
        }  

    }
    catch(SQLException e){
      System.out.print(e);
      JOptionPane.showMessageDialog(null, "No se encontraron datos");
    }
  }
  
  
  public void mostrar(){
    EngineOptions options =
       EngineOptions.newBuilder(HARDWARE_ACCELERATED).licenseKey("1BNDHFSC1FVUOYX43HYU5P37VKX2TXSLQ2HJKPJ1ULC6IRXN65KGAXNMZSXX22CU4U1ACJ ").build();
    com.teamdev.jxbrowser.engine.Engine engine = com.teamdev.jxbrowser.engine.Engine.newInstance(options);
    Browser browser = engine.newBrowser();

        SwingUtilities.invokeLater(() -> {
            // Creating Swing component for rendering web content
            // loaded in the given Browser instance.
            BrowserView view = BrowserView.newInstance(browser);

            // Creating and displaying Swing app frame.
            JFrame frame = new JFrame("Hello World");
            // Close Engine and onClose app window
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    engine.close();
                }
            });
            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            //JTextField addressBar = new JTextField("https://www.google.com/maps/search/?api=1&query=Sarchi");
            JTextField addressBar = new JTextField("https://www.google.com/maps/search/?api=1&query=" 
         + vista.txtCanton.getText() + ","+ vista.txtProvincia.getText());
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
} 