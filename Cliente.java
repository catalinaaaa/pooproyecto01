package modelo;

/**
 * @author catas
 */
public class Cliente {
  private int numeroCedula = 0;
  private String nombre = "";
  private String contrasenia = "";
  private String correoElectronico = "";
  private String nombreUsuario = "";
  private String provincia = "";
  private String canton = "";
  private String distrito = "";
  private String senias = "";
  private int telefono = 0;
  private String ubicacion = "";

  
  public Cliente(int pNumeroCedula, String pNombre, String pContrasenia, String pCorreoElectronico, 
     String pNombreUsuario, String pProvincia, String pCanton, String pDistrito,
     String pSenias, int pTelefono, String pUbicacion) {
    setNumeroCedula(pNumeroCedula);
    setNombre(pNombre);
    setContrasenia(pContrasenia);
    setCorreoElectronico(pCorreoElectronico);
    setNombreUsuario(pNombreUsuario);
    setProvincia(pProvincia);
    setCanton(pCanton);
    setDistrito(pDistrito);
    setSenias(pSenias);
    setTelefono(pTelefono);
    setUbicacion(pUbicacion);
  }

  
  public int getNumeroCedula() {
    return numeroCedula;
  }

  
  public void setNumeroCedula(int numeroCedula) {
    this.numeroCedula = numeroCedula;
  }

  
  public String getProvincia() {
    return provincia;
  }

  
  public void setProvincia(String provincia) {
    this.provincia = provincia;
  }

  
  public String getCanton() {
    return canton;
  }

  
  public void setCanton(String canton) {
    this.canton = canton;
  }

  
  public String getDistrito() {
    return distrito;
  }
  

  public void setDistrito(String distrito) {
    this.distrito = distrito;
  }

  
  public String getSenias() {
    return senias;
  }

  
  public void setSenias(String senias) {
    this.senias = senias;
  }

  
  public int getTelefono() {
    return telefono;
  }

  
  public void setTelefono(int telefono) {
    this.telefono = telefono;
  }
  

  public String getUbicacion() {
    return ubicacion;
  }

  
  public void setUbicacion(String ubicacion) {
    this.ubicacion = ubicacion;
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
}