package modelo;

/**
 * @author catas
 */

public class Producto {
  private String identificador = "";
  private String nombre = "";
  private String descripcion = "";
  private String tipo = "";
  private Categoria categoria = null;
  private int cantidad = 0;
  private double costoUnitario = 0;
  private double costoEntrega = 0;
  private byte[] fotografia;
  private String estado = "";

  
  public Producto(String pIdentificador, String pNombre, String pDescripcion, String pTipo, 
     Categoria pCategoria, int pCantidad, double pCostoUnitario, double pCostoEntrega, 
     String pEstado) {
    setIdentificador(pIdentificador);
    setNombre(pNombre);
    setDescripcion(pDescripcion);
    setTipo(pTipo);
    setCategoria(pCategoria);
    setCantidad(pCantidad);
    setCostoUnitario(pCostoUnitario);
    setCostoEntrega(pCostoEntrega); //averiguar, google maps 
    setEstado(pEstado);
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

  
  public int getCantidad() {
    return cantidad;
  }

  
  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  
  public double getCostoUnitario() {
    return costoUnitario;
  }

  
  public void setCostoUnitario(double costoUnitario) {
    this.costoUnitario = costoUnitario;
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
 
  
  public String getEstado() {
    return estado;
  }

  
  public void setEstado(String estado) {
    this.estado = estado;
  }
}