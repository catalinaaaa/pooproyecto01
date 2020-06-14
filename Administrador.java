package modelo;

/**
 * @author catas
 */

public class Administrador extends Usuario{
  private int id = 0;
  
  public Administrador(int pId, String pNombre, String pContrasenia, String pCorreoElectronico, 
     String pNombreUsuario) {
    super(pNombre, pContrasenia, pCorreoElectronico, pNombreUsuario);
    setId(pId);
  }

  
  public int getId() {
    return id;
  }

  
  public void setId(int id) {
    this.id = id;
  }
}