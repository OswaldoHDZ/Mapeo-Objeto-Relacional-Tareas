
package mx.uacm.curso.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.uacm.curso.entidades.Departamento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


public class DepartamentoDAOTest {
    
    private static EntityManager em;
    private static DepartamentoDAO departamentoDAO;
    
    @BeforeAll
    public static void inicializar() {
        System.out.println("inicializar");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-pruebas-memoria");
        em = emf.createEntityManager();
        em.getTransaction().begin(); //iniciamos transaccion
        departamentoDAO = new DepartamentoDAOImpl(em);
    }
    @Test
    @Order(1)
    public void buscarArticuloTest(){
        
        Departamento a = departamentoDAO.buscarPorId(1);
        //checamos que la variable a no sea NULL
        Assertions.assertNotNull(a);
        //revisamos que el id del objeto sea el correcto
        //primer argumento = el valor esperado
        //segundo argumento = el valor real
        Assertions.assertEquals(1,a.getId());
    }
}
