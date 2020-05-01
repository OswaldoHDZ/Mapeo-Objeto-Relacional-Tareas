/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.tarea.daos;

import java.util.Date;
import java.util.List;
import mx.uacm.tarea.entidades.Pelicula;

public interface PeliculaDAO extends GenericDAO<Pelicula, Integer> {
    // Este metodo regresa 
    // las películas cuya fecha de estreno este en los 
    // rangos fechaMin y fechaMax.
    List<Pelicula> peliculasPorFecha(Date fechaMin, Date fechaMax);
    //Este metodo regresa
    //las películas cuyo titulo incluya el texto nombre. 
    //Por ejemplo, si el método recibe la palabra “gran”, entonces, 
    //la lista de películas a regresar debe incluir a “El gran Lebowski”

    List<Pelicula> peliculasPorNombre(String nombre);
    
    
    //El siguiente metodo regresa las películas que no 
    //tienen un género asignado (por ejemplo, las películas “Coherencia” y “Stalker” 
    //no tienen ningún género asociado). 
    List<Pelicula> peliculasSinGenero();
}
