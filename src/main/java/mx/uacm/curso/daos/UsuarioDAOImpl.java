/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos;

import javax.persistence.EntityManager;
import mx.uacm.curso.entidades.Articulo;
import mx.uacm.curso.entidades.Usuario;

/**
 *
 * @author Alumno
 */
public class UsuarioDAOImpl extends GenericDAOImpl<Usuario,Integer> implements UsuarioDAO{
    
    public UsuarioDAOImpl(EntityManager em) {
        super(em, Usuario.class);
    }
    
}
