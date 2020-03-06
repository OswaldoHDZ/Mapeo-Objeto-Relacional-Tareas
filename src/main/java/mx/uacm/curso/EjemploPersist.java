/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.uacm.curso.entidades.Articulo;

/**
 *
 * @author Alumno
 */
public class EjemploPersist {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-pruebas");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //CREAR USANDO EL METODO persist        
        Articulo a = new Articulo();
        //a.setId(2); 
        //si se descomenta la linea de arriba EL OBJETO a esta en estado detached (DESACOPLADO)
        a.setTitulo("nuevo titulo (persist)");        
        //PERSIST RECIBE SOLO ENTIDADES ADMINISTRADAS CUANDO
        //QUIEREN ACTUALIZAR
        // EL MERGE PUEDE RECIBIR ENTIDADES NO ADMINISTRADAS
        em.persist(a);//creando nuevo renglon}
        //EL OBJETO QUE RECIBE PERSISTE LO PONE EN ESTADO
        //ADMINISTRADO
        a.setContenido("contenido actualizado");
        
        //ACTUALIZACION
        Articulo a2 = em.find(Articulo.class,1);
        a2.setTitulo("titulo actualizado (persist) 2");
        //em.persist(a2);
        
        //EJEMPLO MERGE VS PERSIST 
        Articulo a3 = new Articulo();
        a3.setTitulo("articulo titulo 3 ");
        //MERGE EL OBJETO QUE RECIBE NO LO PONE
        //EN ESTADO ADMINISTRADO A DIFERENCIA DE PERSIST
        Articulo a4=em.merge(a3);
        //a4 SI ESTA EN ESTADO ADMINISTRADO
        a3.setContenido("contenido nuevo");
        
        a4.setContenido("contenido nuevo usando a4");
        
        //EJEMPLO REMOVER 
        Articulo ar= em.find(Articulo.class,1);
        //REMOVE RECIBE OBJETOS EN ESTADO ADMINISTRADO
        em.remove(ar);
        
        em.getTransaction().commit();
        
        

    }

}
