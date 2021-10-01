/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Estructura.ListaSimple;

/**
 *
 * @author Brayan Angarita
 */
public class Departamento {
    
    private String nombre;
    private ListaSimple municipios;

    public Departamento(String nombre, ListaSimple municipios) {
        this.nombre = nombre;
        this.municipios = municipios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaSimple getMunicipios() {
        return municipios;
    }

    public void setMunicipios(ListaSimple municipios) {
        this.municipios = municipios;
    }

    @Override
    public String toString() {
        return "Departamento{" + "nombre=" + nombre + ", municipios=" + municipios + '}';
    }
    
}
