package modelo;

/**
 * @author catas
 */

public class Proveedor{
  private int cedula = 0;
  private String identificador = "";
  private String nombre = "";
  private String contrasenia = "";
  private String correoElectronico = "";
  private String nombreUsuario = "";
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
  private String tipoProveedor = "";

  public Proveedor(int pCedula, String pIdentificador, String pNombre ,String pContrasenia, 
     String pCorreoElectronico, String pNombreUsuario, String pProvincia, String pCanton, 
     String pDistrito, String pSenias, int pTelefono, String pSitioWeb, String pHorarioAtencion, 
     String pUbicacion, String pRedesSociales, String pTipoProveedor) {
    setCedula(pCedula);
    setIdentificador(pIdentificador);
    setNombre(pNombre);
    setContrasenia(pContrasenia);
    setCorreoElectronico(pCorreoElectronico);
    setNombreUsuario(pNombreUsuario);
    setProvincia(pProvincia);
    setCanton(pCanton);
    setDistrito(pDistrito);
    setSenias(pSenias);
    setTelefono(pTelefono);
    setSitioWeb(pSitioWeb);
    setHorarioAtencion(pHorarioAtencion);
    setUbicacion(pUbicacion);
    setRedesSociales(pRedesSociales);
    setTipoProveedor(pTipoProveedor);
  }

  
  public Proveedor(int pCedula, String pIdentificador, String pNombre, String pCorreoElectronico,
     String pNombreUsuario, String pProvincia, String pCanton, String pDistrito, String pSenias, 
     int pTelefono, String pSitioWeb, String pHorarioAtencion, String pUbicacion, 
     String pRedesSociales, int pCalificacion, String pTipoProveedor) {
    setCedula(pCedula);
    setIdentificador(pIdentificador);
    setNombre(pNombre);
    setCorreoElectronico(pCorreoElectronico);
    setNombreUsuario(pNombreUsuario);
    setProvincia(pProvincia);
    setCanton(pCanton);
    setDistrito(pDistrito);
    setSenias(pSenias);
    setTelefono(pTelefono);
    setSitioWeb(pSitioWeb);
    setHorarioAtencion(pHorarioAtencion);
    setUbicacion(pUbicacion);
    setRedesSociales(pRedesSociales);
    setCalificacion(10);
    setTipoProveedor(pTipoProveedor);
  }
  
  
  public Proveedor(int pCedula, String pIdentificador, String pNombre, int pTelefono, String 
     pSitioWeb, String pRedesSociales){
    setCedula(pCedula);
    setIdentificador(pIdentificador);
    setNombre(pNombre);
    setTelefono(pTelefono);
    setSitioWeb(pSitioWeb);
    setRedesSociales(pRedesSociales);
    
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

  
  public int getCedula() {
    return cedula;
  }

  
  public void setCedula(int cedula) {
    this.cedula = cedula;
  }

  
  public String getTipoProveedor() {
    return tipoProveedor;
  }

  
  public void setTipoProveedor(String tipoProveedor) {
    this.tipoProveedor = tipoProveedor;
  }
}