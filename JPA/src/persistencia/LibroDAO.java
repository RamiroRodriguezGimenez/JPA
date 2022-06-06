
package persistencia;

import java.util.List;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;


public class LibroDAO extends DAO {
    
    public void guardar(Libro libro){
        conectar();
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
        desconectar();
    }
    
    public void editar(Libro libro){
        conectar();
        em.getTransaction().begin();
        Libro l = em.merge(libro);
        em.getTransaction().commit();
        desconectar();
    }
    
    public void eliminar(Libro libro){
        conectar();
        em.getTransaction().begin();
        em.remove(libro);
        em.getTransaction().commit();
        desconectar();
    }
    
    public Libro buscarPorISBN(Long ISBN){
        return em.find(Libro.class, ISBN);
    }
    
    public Libro buscarPorTitulo (String titulo){
        return em.find(Libro.class, titulo);
    }
    public Libro buscarPorID (String id){
        return em.find(Libro.class,id);
    }
    
    public List<Libro> buscarPorAutor(Autor autor){
        return em.createQuery("SELECT l FROM Libro l, Autor a WHERE a=l.autor AND a.Nombre LIKE :autor")
                .setParameter("autor", autor.getNombre())
                .getResultList();
        
    }
    
    public List<Libro> buscarPorEditorial(String editorial){
        return em.createQuery("SELECT l FROM Libro l, Editorial e WHERE e=l.editorial AND e.nombre LIKE :editorial")
                .setParameter("editorial", "%"+editorial+"%")
                .getResultList();
    }
    
}
