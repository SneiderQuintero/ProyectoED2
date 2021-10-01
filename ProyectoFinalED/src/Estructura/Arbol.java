/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import Nodos.Nodo_arbol;

/**
 *
 * @author Brayan Angarita
 */
public class Arbol {

    private Nodo_arbol raiz;

    public Arbol() {
        this.raiz = null;
    }

    public Nodo_arbol getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo_arbol raiz) {
        this.raiz = raiz;
    }

    @Override
    public String toString() {
        return "Arbol{" + "raiz=" + raiz + '}';
    }

    public boolean esVacia() {
        return raiz == null;
    }

    public void insertarDato(int dato) {
        Nodo_arbol nuevo = new Nodo_arbol(dato);
        if (esVacia()) {
            raiz = nuevo;
        } else {
            Nodo_arbol aux = raiz;
            Nodo_arbol padre;
            boolean hijo;
            while (true) {
                padre = aux;
                if (dato < aux.getDato()) {
                    aux = aux.getHijo_izquierdo();
                    if (aux == null) {
                        padre.setHijo_izquierdo(nuevo);
                        return;
                    }
                } else {
                    aux = aux.getHijo_derecho();
                    if (aux == null) {
                        padre.setHijo_derecho(nuevo);
                        return;
                    }
                }
            }
        }
    }

    public void insertarDatoBool(int dato) {
        Nodo_arbol nuevo = new Nodo_arbol(dato);
        if (esVacia()) {
            raiz = nuevo;
        } else {
            Nodo_arbol aux = raiz;
            Nodo_arbol padre = raiz;
            boolean hijo = true;
            while (aux != null) {
                padre = aux;
                if (dato < aux.getDato()) {
                    aux = aux.getHijo_izquierdo();
                    hijo = true;
                } else {
                    aux = aux.getHijo_derecho();
                    hijo = false;
                }
            }
            if (hijo) {
                padre.setHijo_izquierdo(nuevo);
            } else {
                padre.setHijo_derecho(nuevo);
            }
        }
    }

    public void inOrden(Nodo_arbol raiz) {
        if (raiz != null) {
            inOrden(raiz.getHijo_izquierdo());
            System.out.println(raiz.getDato());
            inOrden(raiz.getHijo_derecho());
        }
    }

    public String inOrdenR(Nodo_arbol raiz) {
        if (raiz == null) {
            return " -- ";
        }
        return inOrdenR(raiz.getHijo_izquierdo()) + raiz.getDato() + inOrdenR(raiz.getHijo_derecho());
    }

    public String inOrdenNumPar(Nodo_arbol raiz) {
        if (raiz == null) {
            return " -- ";
        }
        return inOrdenR(raiz.getHijo_izquierdo()) + ((raiz.getDato() % 2 == 0) ? raiz.getDato() : "") + inOrdenR(raiz.getHijo_derecho());
    }

    public boolean Eliminar(int d) {
        Nodo_arbol auxiliar = raiz;
        Nodo_arbol padre = raiz;
        boolean hijoizq = true;
        while ((int) auxiliar.getDato() != d) {
            padre = auxiliar;
            if (d < (int) auxiliar.getDato()) {
                hijoizq = true;
                auxiliar = auxiliar.getHijo_izquierdo();
            } else {
                hijoizq = false;
                auxiliar = auxiliar.getHijo_derecho();
            }
            if (auxiliar == null) {
                return false;
            }
        }
        if (auxiliar.getHijo_izquierdo() == null && auxiliar.getHijo_derecho() == null) {
            if (auxiliar == raiz) {
                raiz = null;
            } else if (hijoizq) {
                padre.setHijo_izquierdo(null);
            } else {
                padre.setHijo_derecho(null);
            }
        } else if (auxiliar.getHijo_derecho() == null) {
            if (auxiliar == raiz) {
                raiz = auxiliar.getHijo_izquierdo();
            } else if (hijoizq) {
                padre.setHijo_izquierdo(auxiliar.getHijo_izquierdo());
            } else {
                padre.setHijo_derecho(auxiliar.getHijo_izquierdo());
            }
        } else if (auxiliar.getHijo_izquierdo() == null) {
            if (auxiliar == raiz) {
                raiz = auxiliar.getHijo_derecho();
            } else if (hijoizq) {
                padre.setHijo_izquierdo(auxiliar.getHijo_derecho());
            } else {
                padre.setHijo_derecho(auxiliar.getHijo_derecho());
            }
        } else {
            Nodo_arbol reemplazo = ObtenerReemplazo(auxiliar);
            if (auxiliar == raiz) {
                raiz = reemplazo;
            } else if (hijoizq) {
                padre.setHijo_izquierdo(reemplazo);
            } else {
                padre.setHijo_derecho(reemplazo);
            }
            reemplazo.setHijo_izquierdo(auxiliar.getHijo_izquierdo());
        }
        return true;
    }

    public Nodo_arbol ObtenerReemplazo(Nodo_arbol nodoreemplazo) {
        Nodo_arbol reemplazarpadre = nodoreemplazo;
        Nodo_arbol reemplazo = nodoreemplazo;
        Nodo_arbol auxiliar = nodoreemplazo.getHijo_derecho();
        while (auxiliar != null) {
            reemplazarpadre = reemplazo;
            reemplazo = auxiliar;
            auxiliar = auxiliar.getHijo_izquierdo();
        }
        if (reemplazo != nodoreemplazo.getHijo_derecho()) {
            reemplazarpadre.setHijo_izquierdo(reemplazo.getHijo_derecho());
            reemplazo.setHijo_derecho(nodoreemplazo.getHijo_derecho());
        }
        return reemplazo;
    }
}
