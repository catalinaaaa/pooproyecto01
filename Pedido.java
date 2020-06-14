package modelo;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author catas
 */

public class Pedido {
  private int identificador = 0;
  private Proveedor proveedor = null;
  private String estado = "En proceso";
  private Date fecha = null;
  private String fechaEntrega = "";
  private Categoria categoria = null;
  private Cliente duenio = null;
  private double montoTotal = 0;
  private ArrayList<Producto> productos = null;
  private ArrayList<Servicio> servicio = null;

  
  public Pedido(int pIdentificador, Proveedor pProveedor, String pFechaEntrega, 
     Categoria pCategoria, Cliente pDuenio, int pMontoTotal) {
    setIdentificador(pIdentificador);
    setProveedor(pProveedor);
    setEstado("En proceso");
    setFecha();
    setFechaEntrega("averiguar google maps");
    setCategoria(pCategoria);
    setDuenio(pDuenio);
    setMontoTotal(pMontoTotal);
  }

  
  public int getIdentificador() {
    return identificador;
  }

  
  public void setIdentificador(int identificador) {
    this.identificador = identificador;
  }

  
  public Proveedor getProveedor() {
    return proveedor;
  }

  
  public void setProveedor(Proveedor proveedor) {
    this.proveedor = proveedor;
  }
  

  public String getEstado() {
    return estado;
  }

  
  public void setEstado(String estado) {
    this.estado = estado;
  }

  
  private void setFecha() {
    Calendar calendario;
    calendario = Calendar.getInstance();
    fecha = calendario.getTime();
  }

  
  public String getFechaCreacion() {
    SimpleDateFormat mascara = new SimpleDateFormat("dd/MM/yy");
    return mascara.format(fecha);
  }

  
  public String getFechaEntrega() {
    return fechaEntrega;
  }

  
  public void setFechaEntrega(String fechaEntrega) {
    this.fechaEntrega = fechaEntrega;
  }

  
  public Categoria getCategoria() {
    return categoria;
  }

  
  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }

  
  public Cliente getDuenio() {
    return duenio;
  }

  
  public void setDuenio(Cliente duenio) {
    this.duenio = duenio;
  }

  
  public double getMontoTotal() {
    return montoTotal;
  }

  
  public void setMontoTotal(double montoTotal) {
    this.montoTotal = montoTotal;
  }
  

  public ArrayList<Producto> getProductos() {
    return productos;
  }

  
  public void setProductos(ArrayList<Producto> productos) {
    this.productos = productos;
  }

  
  public ArrayList<Servicio> getServicio() {
    return servicio;
  }
 
  
  public void setServicio(ArrayList<Servicio> servicio) {
    this.servicio = servicio;
  }
}