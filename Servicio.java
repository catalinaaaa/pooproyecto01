package modelo;

/**
 * @author catas
 */

public class Servicio {
  private String identificador = "";
  private String nombre = "";
  private String descripcion = "";
  private String tipo = "";
  private Categoria categoria = null;
  private double costo = 0;
  private double costoEntrega = 0;
  private byte[] fotografia;

  public Servicio(String pIdendificador, String pNombre, String pDescripcion, String pTipo,
     Categoria pCategoria, double pCosto, double pCostoEntrega, byte[] pFotografia) {
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
  

  public String getTipo() {
    return tipo;
  }

  
  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  
  public Categoria getCategoria() {
    return categoria;
  }

  
  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }

  
  public double getCosto() {
    return costo;
  }

  
  public void setCosto(double costo) {
    this.costo = costo;
  }

  
  public double getCostoEntrega() {
    return costoEntrega;
  }
  

  public void setCostoEntrega(double costoEntrega) {
    this.costoEntrega = costoEntrega;
  }

  
  public byte[] getFotografia() {
    return fotografia;
  }
  

  public void setFotografia(byte[] fotografia) {
    this.fotografia = fotografia;
  }
  
}