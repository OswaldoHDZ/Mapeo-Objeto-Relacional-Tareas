/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.uacm.curso.entidades.Articulo;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 *
 * @author Alumno
 */
//configuramos junit para ordenar usando annotations
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ArticuloDAOTest {
    
    private static EntityManager em;
    private static ArticuloDAO articuloDAO;
    
    //ArticuloDAOTest.inicializar();
    //junit al usar el annotation @BeforeAll necesita que
    //sea estatico el metodo
    @BeforeAll
    public static void inicializar() {
        System.out.println("inicializar");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-pruebas-memoria");
        em = emf.createEntityManager();
        em.getTransaction().begin(); //iniciamos transaccion
        articuloDAO = new ArticuloDAOImpl(em);
    }
    
    @AfterAll
    //ejecuta despues de todos los tests
    public static void terminar(){
        //rollback es para deshacer todos los cambios
        //dentro de la transaccion
        System.out.println("terminar");
        em.getTransaction().rollback();
    }
    
    @Test
    @Order(1)
    public void buscarArticuloTest(){
        
        Articulo a = articuloDAO.buscarPorId(1);
        //checamos que la variable a no sea NULL
        Assertions.assertNotNull(a);
        //revisamos que el id del objeto sea el correcto
        //primer argumento = el valor esperado
        //segundo argumento = el valor real
        Assertions.assertEquals(1,a.getId());
    }
    
    @Test
    @Order(2)
    public void guardarArticuloTest(){
        
        Articulo a = new Articulo();
        a.setContenido("contenido test");
        a.setTitulo("titulo test");
        a.setFechaCreacion(new Date());
        
        Articulo a2 = articuloDAO.guardar(a);
        //verificamos que el articulo se guardo
        //revisamos que no sea null
        Assertions.assertNotNull(a2);
        //revisamos que tenga un id
        Assertions.assertNotNull(a2.getId());
        //revisamos que el contenido se guardo bien
        Assertions.assertEquals(a.getContenido(),a2.getContenido());
        Assertions.assertEquals(a.getTitulo(),a2.getTitulo());
        Assertions.assertEquals(a.getFechaCreacion(),a2.getFechaCreacion());
    }
    
    @Test
    @Order(3)
    public void removerArticuloTest(){
        //verifique que funciona el remover con el renglon
        //que insertaron en la base        
        //el renglon 3 siempre se genera en la base de datos
        //en memoria ram
        Articulo a = articuloDAO.buscarPorId(3);
        articuloDAO.remover(a);
        Articulo a2 = articuloDAO.buscarPorId(3);
        //revisamos que el articulo se haya borrado
        Assertions.assertNull(a2);        
    }

}
