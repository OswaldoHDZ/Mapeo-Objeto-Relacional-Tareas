/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos;

import javax.persistence.EntityManager;
import mx.uacm.curso.entidades.Articulo;

/**
 *
 * @author Alumno
 */
public class ArticuloDAOImpl extends GenericDAOImpl<Articulo, Integer> implements ArticuloDAO{

    public ArticuloDAOImpl(EntityManager em) {
        //invocamos al constructor del padre
        super(em, Articulo.class);
    }
}
