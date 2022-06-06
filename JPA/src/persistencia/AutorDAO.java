
package persistencia;

import libreria.entidades.Autor;


public class AutorDAO extends DAO{
    
    
    public void guardar(Autor autor){
        conectar();
        em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
        desconectar();
    }
    
    public void modificar(Autor autor){
        conectar();
        em.getTransaction().begin();
        em.merge(autor);
        em.getTransaction().commit();
        desconectar();
    }
    
    public void eliminar(Autor autor){
        conectar();
        em.getTransaction().begin();
        em.remove(autor);
        em.getTransaction().commit();
        desconectar();
    }
    
    public Autor buscarPorID(Long id){
        return em.find(Autor.class, id);
    }
}
