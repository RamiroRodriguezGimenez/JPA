
package libreria.servicios;

import java.util.List;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import persistencia.LibroDAO;


public class LibroServicio {
    
    private LibroDAO dao;
    
    public LibroServicio(){
        dao = new LibroDAO();
    }
    
    public void crear(String titulo, Long isbn, Integer anio, Integer ejemplares, Integer ejemplaresPrestados, Integer ejemplaresRestantes, Boolean alta, Autor autor, Editorial editorial){
        Libro l = new Libro();
        
        l.setIsbn(isbn);
        l.setTitulo(titulo);
        l.setAlta(alta);
        l.setAnio(anio);
        l.setEditorial(editorial);
        l.setEjemplares(ejemplares);
        l.setEjemplaresPrestados(ejemplaresPrestados);
        l.setEjemplaresRestantes(ejemplaresRestantes);
        
        dao.guardar(l);
    }
    
    public void modificar(String titulo, String id){
        Libro l = dao.buscarPorID(id);
        l.setTitulo(titulo);
        dao.editar(l);
    }
    
    public void elimnar(String id){
        Libro l=dao.buscarPorID(id);
        dao.eliminar(l);
    }
    
    public List<Libro> buscarPorAutor(Autor autor){
        return dao.buscarPorAutor(autor);
    }
    
    public List<Libro> buscarPorEditorial(Editorial editorial){
        return dao.buscarPorEditorial(editorial.getNombre());
    }
}
