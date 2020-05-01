package mx.uacm.tarea.daos;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.uacm.tarea.daos.impl.PeliculaDAOImpl;
import mx.uacm.tarea.entidades.Pelicula;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PeliculaDAOTest {

    private static EntityManager em;

    private static PeliculaDAO peliculaDAO;

    @BeforeAll
    public static void inicializar() {
        System.out.println("inicializando");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("base-pruebas-memoria");
        //Para usar la base de datos "de verdad", comente la linea de arriba y descomente la siguiente linea.
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("base-pruebas");
        em = emf.createEntityManager();
        peliculaDAO = new PeliculaDAOImpl(em);
    }

    @AfterAll
    public static void terminar() {
        System.out.println("terminando");
    }

    @BeforeEach
    public void antesDeCadaTest() {
        System.out.println("antes del test");
        em.getTransaction().begin(); //iniciamos transaccion
    }

    @AfterEach
    public void despuesDeCadaTest() {
        System.out.println("despues del test");
        em.flush();
        em.getTransaction().rollback();
    }

    @Test
    public void buscarPorId() {
        Pelicula d = peliculaDAO.buscarPorId(1);
        Assertions.assertNotNull(d);
        
        assertNotNull(d.getGeneros());
        assertEquals(1, d.getGeneros().size());      
    }
    
    
    //Test de PeliculaDAOImplemet
    @Test
    public void obtenPeliculasPorFecha(){
        GregorianCalendar cal = new GregorianCalendar(1976,0,18); 
        Date fechaMinima = cal.getTime();
        GregorianCalendar cal2 = new GregorianCalendar(2017,6,27);
        Date fechaMaxima = cal2.getTime();
        
        List<Pelicula> peliculas = peliculaDAO.peliculasPorFecha(fechaMinima, fechaMaxima);
        assertNotNull(peliculas);
        
        assertEquals(7, peliculas.size());
    }
    
    @Test
    public void obtenPeliculaPorNombre(){
        List<Pelicula> peliculas = peliculaDAO.peliculasPorNombre("gran");
        for (Pelicula pelicula : peliculas){
            System.out.println("Nombre de la pelicula es: "+pelicula.getTitulo());
        }
        assertNotNull(peliculas);
    }
    
    @Test
    public void obtenPeliculasSinGenero(){
        List<Pelicula> peliculas = peliculaDAO.peliculasSinGenero();
        
        for(Pelicula pelicula:peliculas){
            System.out.println("La pelicula ---- "+pelicula);
        }
        
        Assertions.assertNotNull(peliculas);
        Assertions.assertEquals(2, peliculas.size());
    }
}
