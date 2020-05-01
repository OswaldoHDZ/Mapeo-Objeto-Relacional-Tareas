/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.tarea.daos.impl;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import mx.uacm.tarea.daos.PeliculaDAO;
import mx.uacm.tarea.entidades.Pelicula;

public class PeliculaDAOImpl extends GenericDAOImpl<Pelicula, Integer> implements PeliculaDAO {

    public PeliculaDAOImpl(EntityManager em) {
        super(em);
    }
    
    @Override
    public List<Pelicula> peliculasPorFecha(Date fechaMin, Date fechaMax) {
        //Consulta parametrisada con parametros por nombre
        TypedQuery<Pelicula> consulta =  em.createQuery("SELECT p FROM Pelicula p WHERE p.fechaEstreno >=:fechaMin AND p.fechaEstreno <=:fechaMax",Pelicula.class);
        consulta.setParameter("fechaMin", fechaMin);
        consulta.setParameter("fechaMax", fechaMax);
        return consulta.getResultList();
    }

    @Override
    public List<Pelicula> peliculasPorNombre(String nombre) {
        TypedQuery<Pelicula> consulta = em.createQuery("SELECT p FROM Pelicula p WHERE p.titulo LIKE :nombre",Pelicula.class);
        consulta.setParameter("nombre", "%"+nombre+"%");
        return consulta.getResultList();
    }

    @Override
    public List<Pelicula> peliculasSinGenero() {
        TypedQuery<Pelicula> consulta = em.createQuery("SELECT p FROM Pelicula p WHERE p.generos IS EMPTY",Pelicula.class);
        return consulta.getResultList();
    }
    
}
