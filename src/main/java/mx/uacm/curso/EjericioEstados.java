/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.uacm.curso.entidades.Usuario;

/**
 *
 * @author Alumno
 */
public class EjericioEstados {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-pruebas");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Usuario u = new Usuario();
        u.setNombre("Pedro Paramo 2");
        Usuario u2 = em.merge(u);
        //¿porque no se actualiza automaticamente el campo email?
        u2.setEmail("pedropa@mail.com");
        em.getTransaction().commit();
    }

}
