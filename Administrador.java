package modelo;

/**
 * @author catas
 */

public class Administrador{
  private String nombre = "";
  private String contrasenia = "";
  private String correoElectronico = "";
  private String nombreUsuario = "";
  private int id = 0;
  
  public Administrador(String pNombre, String pContrasenia, String pCorreoElectronico, 
     String pNombreUsuario) {
    setNombre(pNombre);
    setContrasenia(pContrasenia);
    setCorreoElectronico(pCorreoElectronico);
    setNombreUsuario(pNombreUsuario);
  }
  
  
  public Administrador(){
    
  }

  
  public String getNombre() {
    return nombre;
  }

  
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  
  public String getContrasenia() {
    return contrasenia;
  }

  
  public void setContrasenia(String contrasenia) {
    this.contrasenia = contrasenia;
  }
  

  public String getCorreoElectronico() {
    return correoElectronico;
  }

  
  public void setCorreoElectronico(String correoElectronico) {
    this.correoElectronico = correoElectronico;
  }

  
  public String getNombreUsuario() {
    return nombreUsuario;
  }

  
  public void setNombreUsuario(String nombreUsuario) {
    this.nombreUsuario = nombreUsuario;
  }

  
  public int getId() {
    return id;
  }

  
  public void setId(int id) {
    this.id = id;
  }
}