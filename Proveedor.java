package modelo;

/**
 * @author catas
 */

public class Proveedor extends Usuario {
  private String identificador = "";
  private String provincia = "";
  private String canton = "";
  private String distrito = "";
  private String senias = "";
  private int telefono = 0;
  private String sitioWeb = "";
  private String horarioAtencion = "";
  private String ubicacion = "";
  private String redesSociales = "";
  private int calificacion = 0;  

  public Proveedor(String pIdentificador, String pProvincia, String pCanton, String pDistrito,
     String pSenias, int pTelefono, String pSitioWeb, String pHorarioAtencion, String pUbicacion, 
     String pRedesSociales, int pCalificacion, String pNombre, String pContrasenia, 
     String pCorreoElectronico, String pNombreUsuario) {
    super(pNombre, pContrasenia, pCorreoElectronico, pNombreUsuario);
    setIdentificador(pIdentificador);
    setProvincia(pProvincia);
    setCanton(pCanton);
    setDistrito(pDistrito);
    setSenias(pSenias);
    setTelefono(pTelefono);
    setSitioWeb(pSitioWeb);
    setHorarioAtencion(pHorarioAtencion);
    setUbicacion(pUbicacion);
    setRedesSociales(pRedesSociales);
    setCalificacion(pCalificacion);
  }

  
  public String getIdentificador() {
    return identificador;
  }

  
  public void setIdentificador(String identificador) {
    this.identificador = identificador;
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
  

  public String getSitioWeb() {
    return sitioWeb;
  }
  
  
  public void setSitioWeb(String sitioWeb) {
    this.sitioWeb = sitioWeb;
  }

  
  public String getHorarioAtencion() {
    return horarioAtencion;
  }

  
  public void setHorarioAtencion(String horarioAtencion) {
    this.horarioAtencion = horarioAtencion;
  }
  

  public String getUbicacion() {
    return ubicacion;
  }

  
  public void setUbicacion(String ubicacion) {
    this.ubicacion = ubicacion;
  }

  
  public String getRedesSociales() {
    return redesSociales;
  }
  

  public void setRedesSociales(String redesSociales) {
    this.redesSociales = redesSociales;
  }

  
  public int getCalificacion() {
    return calificacion;
  }
  

  public void setCalificacion(int calificacion) {
    this.calificacion = calificacion;
  }
}