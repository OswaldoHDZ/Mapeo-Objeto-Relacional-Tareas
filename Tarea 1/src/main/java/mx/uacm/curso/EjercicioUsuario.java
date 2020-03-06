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
public class EjercicioUsuario {

    public static void main(String[] args) {

        //EJERCICIO:
        // ACTUALIZAR EL USUARIO CUYO ID=2 CAMBIANDO
        //NOMBRE="Homero simpson"
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-pruebas");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        Usuario u = em.find(Usuario.class,2);
        u.setNombre("homero simpson");
        em.getTransaction().commit();

    }

}
