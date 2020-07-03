package modelo;

/**
 * @author catas
 */

public class Categoria {
  private int codigo = 0;
  private String nombre = "";
  private String descripcion = "";
  private String estado = "";

  
  public Categoria(int pCodigo, String pNombre, String pDescripcion, String pEstado) {
    setCodigo(pCodigo);
    setNombre(pNombre);
    setDescripcion(pDescripcion);
    setEstado(pEstado);
  }
  
  
  public Categoria(String pNombre, String pDescripcion, String pEstado) {
    setNombre(pNombre);
    setDescripcion(pDescripcion);
    setEstado(pEstado);
  }

  
  public int getCodigo() {
    return codigo;
  }

  
  public void setCodigo(int codigo) {
    this.codigo = codigo;
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
  

  public String getEstado() {
    return estado;
  }
  

  public void setEstado(String estado) {
    this.estado = estado;
  }
}