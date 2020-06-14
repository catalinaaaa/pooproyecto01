package modelo;

/**
 * @author catas
 */
public class Categoria {
  private int codigo = 0;
  private String nombreCateg = "";
  private String descripcion = "";
  private String estado = "";

  
  public Categoria(int pCodigo, String pNombreCateg, String pDescripcion, String pEstado) {
    setCodigo(pCodigo);
    setNombreCateg(pNombreCateg);
    setDescripcion(pDescripcion);
    setEstado(pEstado);
  }
 
  
  public int getCodigo() {
    return codigo;
  }

  
  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  
  public String getNombreCateg() {
    return nombreCateg;
  }
  

  public void setNombreCateg(String nombreCateg) {
    this.nombreCateg = nombreCateg;
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