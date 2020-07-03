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
  private String estado = "En proceso";
  private Date fecha = null;
  private String fechaEntrega = "";
  private double montoTotal = 0;
  private int duenio = 0;
  private int proveedor = 0;
  private String distancia = "";
  private ArrayList<Producto> productos = null;
  private ArrayList<Servicio> servicio = null;

  
  public Pedido(int pIdentificador, int pProveedor, String pFechaEntrega, 
     int pDuenio, int pMontoTotal) {
    setIdentificador(pIdentificador);
    setProveedor(pProveedor);
    setEstado("En proceso");
    setFecha();
    setFechaEntrega(pFechaEntrega);
    setDuenio(pDuenio);
    setMontoTotal(pMontoTotal);
  }

  
  public int getIdentificador() {
    return identificador;
  }

  
  public void setIdentificador(int identificador) {
    this.identificador = identificador;
  }

  
  public int getProveedor() {
    return proveedor;
  }

  
  public void setProveedor(int proveedor) {
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

  
  public int getDuenio() {
    return duenio;
  }

  
  public void setDuenio(int duenio) {
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

  
  public String getDistancia() {
    return distancia;
  }

  
  public void setDistancia(String distancia) {
    this.distancia = distancia;
  }
}