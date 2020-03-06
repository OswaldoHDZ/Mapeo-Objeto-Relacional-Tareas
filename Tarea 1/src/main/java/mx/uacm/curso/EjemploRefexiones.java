/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import mx.uacm.curso.entidades.Articulo;
import mx.uacm.curso.entidades.Usuario;

/**
 *
 * @author Alumno
 */
public class EjemploRefexiones {

    public static void main(String[] args) {
        
        //en JAVA CADA CLASE TIENE ASOCIADA OTRA CLASE
        //CON EXTENSION .class
        Class clase = Articulo.class;
        Class claseU = Usuario.class;
        
        //usando reflexiones preguntamos por los campos de la clase
        Field[] campos = clase.getDeclaredFields();
        
        for(Field campo:campos){
            System.out.println("nombre campo:" + campo.getName());
            //usando reflexiones obtenemos los annotations de la clase
            for(Annotation anotacion:campo.getAnnotations() ){
                System.out.println("anotacion:" + anotacion);
            }
                       
        }
    }
    
}
