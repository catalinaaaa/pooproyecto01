package modelo;

/**
 * @author catas
 */

public class Producto {
  private String idProducto = "";
  private String nombre = "";
  private String descripcion = "";
  private int categoria = 0;
  private int cantidad = 0;
  private double costoUnitario = 0;
  private double costoEntrega = 0;
  private String estado = "";
  private int vendedor = 0;
  private byte[] fotografia;
  
  public Producto(String pIdProducto, String pNombre, String pDescripcion, int pCategoria, 
     int pCantidad, double pCostoUnitario, double pCostoEntrega, String pEstado, 
     int pProveedor, byte[] pFoto) {
    setIdProducto(pIdProducto);
    setNombre(pNombre);
    setDescripcion(pDescripcion);
    setCategoria(pCategoria);
    setCantidad(pCantidad);
    setCostoUnitario(pCostoUnitario);
    setCostoEntrega(pCostoEntrega); //averiguar, google maps 
    setEstado(pEstado);
    setVendedor(pProveedor);
    setFotografia(pFoto);
  }

  
  public String getIdProducto() {
    return idProducto;
  }

  
  public void setIdProducto(String idProducto) {
    this.idProducto = idProducto;
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

  
  public int getVendedor() {
    return vendedor;
  }

  
  public void setVendedor(int vendedor) {
    this.vendedor = vendedor;
  }
}