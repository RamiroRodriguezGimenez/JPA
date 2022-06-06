
package libreria.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Autor implements Serializable {

    //private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "uuid")
    private String id;
    private String Nombre;
    private Boolean alta;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    public Autor() {
       // id="0";
    }

    public Autor(String id, String Nombre, Boolean alta) {
        this.id = id;
        this.Nombre = Nombre;
        this.alta = alta;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

   

    

    @Override
    public String toString() {
        return "libreria.entidades.Autor[ id=" + id + " ]";
    }
    
}
