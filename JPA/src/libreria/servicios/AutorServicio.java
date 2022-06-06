
package libreria.servicios;

import libreria.entidades.Autor;
import persistencia.AutorDAO;


public class AutorServicio {
    
    private AutorDAO dao;
    
    public void AutorServicio(){
        dao = new AutorDAO();
    }
    
    public void crear(String nombre, Boolean alta){
        Autor autor = new Autor();
        autor.setNombre(nombre);
        autor.setAlta(alta);
        System.out.println(autor);
         dao.guardar(autor);
         
        
    }
    
    public void eliminar(Long id){
        Autor autor = dao.buscarPorID(id);
        dao.eliminar(autor);
    }
    
    public void modificar(Long id, String nombre, Boolean alta){
        Autor autor =dao.buscarPorID(id);
        autor.setAlta(alta);
        autor.setNombre(nombre);
        dao.modificar(autor);
    }
}
