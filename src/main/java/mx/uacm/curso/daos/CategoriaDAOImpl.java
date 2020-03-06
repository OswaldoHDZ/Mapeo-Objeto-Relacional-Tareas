/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos;

import javax.persistence.EntityManager;
import mx.uacm.curso.entidades.Categoria;

/**
 *
 * @author Alumno
 */
public class CategoriaDAOImpl extends GenericDAOImpl<Categoria,Integer> implements CategoriaDAO{
    
    public CategoriaDAOImpl(EntityManager em) {
        super(em, Categoria.class);
    }
    
}
