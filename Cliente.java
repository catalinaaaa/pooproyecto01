package modelo;

/**
 * @author catas
 */
public class Cliente extends Usuario {
  private int numeroCedula = 0;
  private String provincia = "";
  private String canton = "";
  private String distrito = "";
  private String senias = "";
  private int telefono = 0;
  private String ubicacion = "";

  
  public Cliente(int pNumeroCedula, String pProvincia, String pCanton, String pDistrito,
     String pSenias, int pTelefono, String pUbicacion, String pNombre, String pContrasenia, 
     String pCorreoElectronico, String pNombreUsuario) {
    super(pNombre, pContrasenia, pCorreoElectronico, pNombreUsuario);
    setNumeroCedula(pNumeroCedula);
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
}