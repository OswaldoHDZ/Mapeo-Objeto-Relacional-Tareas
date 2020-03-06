/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.entidades;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Table(name = "articulos")
public class Articulo {

    @Id
    //el annotation @SequenceGenerator le a JPA el nombre de la secuencia generadora de la base de datos
    @SequenceGenerator(name = "sec_art", sequenceName = "articulo_id_seq", allocationSize = 1)
    //el annotation @GeneratedValue, le indica a JPA que tipo de estrategia generadora vamos a usar
    //en este caso le estamos indicando que vamos a usar una estrategia del tipo secuencia (GenerationType.SEQUENCE)
    @GeneratedValue(generator = "sec_art", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "contenido")
    private String contenido;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

}
