/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodos;

/**
 *
 * @author Brayan Angarita
 */
public class Nodo_arbol {

    private int dato;
    private Nodo_arbol hijo_izquierdo;
    private Nodo_arbol hijo_derecho;

    public Nodo_arbol(int dato) {
        this.dato = dato;
        this.hijo_izquierdo = null;
        this.hijo_derecho = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo_arbol getHijo_izquierdo() {
        return hijo_izquierdo;
    }

    public void setHijo_izquierdo(Nodo_arbol hijo_izquierdo) {
        this.hijo_izquierdo = hijo_izquierdo;
    }

    public Nodo_arbol getHijo_derecho() {
        return hijo_derecho;
    }

    public void setHijo_derecho(Nodo_arbol hijo_derecho) {
        this.hijo_derecho = hijo_derecho;
    }

    @Override
    public String toString() {
        return "Nodo_arbol{" + "dato=" + dato + ", hijo_izquierdo=" + hijo_izquierdo + ", hijo_derecho=" + hijo_derecho + '}';
    }

}
