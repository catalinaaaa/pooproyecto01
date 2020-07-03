package modelo;

/**
 * @author catas
 */

public class Servicio {
  private String identificador = "";
  private String nombre = "";
  private String descripcion = "";
  private int categoria = 0;
  private double costo = 0;
  private int proveedor = 0;
  private byte[] fotografia;

  public Servicio(String pIdentificador, String pNombre, String pDescripcion, int pCategoria, 
     double pCosto, int pProveedor) {
    setIdentificador(pIdentificador);
    setNombre(pNombre);
    setDescripcion(pDescripcion);
    setCategoria(pCategoria);
    setCosto(pCosto);
    setProveedor(pProveedor);
  }


  public String getIdentificador() {
    return identificador;
  }

  
  public void setIdentificador(String identificador) {
    this.identificador = identificador;
  }

  
  public String getNombre() {
    return nombre;
  }

  
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  
  public String getDescripcion() {
    return descripcion;
  }

  
  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  
  public int getCategoria() {
    return categoria;
  }

  
  public void setCategoria(int categoria) {
    this.categoria = categoria;
  }

  
  public double getCosto() {
    return costo;
  }

  
  public void setCosto(double costo) {
    this.costo = costo;
  }

  
  public byte[] getFotografia() {
    return fotografia;
  }
  

  public void setFotografia(byte[] fotografia) {
    this.fotografia = fotografia;
  }

  
  public int getProveedor() {
    return proveedor;
  }

  
  public void setProveedor(int proveedor) {
    this.proveedor = proveedor;
  }
}