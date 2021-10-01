package Estructura;

import Nodos.Nodo;

public class ListaSimple {

    private Nodo inicio;
    private Nodo ultimo;
    private int tamanio;

    public ListaSimple() {
        inicio = null;
        ultimo = null;
        tamanio = 0;
    }

    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public boolean vacio() {
        return inicio == null && ultimo == null;
    }

    public void agregarInicio(int dato) {
        inicio = new Nodo(dato, inicio);
        if (ultimo == null) {
            ultimo = inicio;
        }
        tamanio++;
    }

    public void agregarUltimo(int dato) {
        if (vacio()) {
            inicio = ultimo = new Nodo(dato);
        } else {
            ultimo.setSiguiente(new Nodo(dato));
            ultimo = ultimo.getSiguiente();
        }
        tamanio++;
    }

    public void eliminarInicio() {
        if (!vacio()) {
            if (inicio == ultimo) {
                inicio = ultimo = null;
            } else {
                inicio = inicio.getSiguiente();
            }
            tamanio--;
        }
    }

    public void eliminarUltimo() {
        if (!vacio()) {
            if (inicio == ultimo) {
                inicio = ultimo = null;
            } else {
                Nodo aux = inicio;
                while (aux.getSiguiente() != ultimo) {
                    aux = aux.getSiguiente();
                }
                aux.setSiguiente(null);
                ultimo = aux;
            }
            tamanio--;
        }
    }

    public String mostrar() {
        String mostrar = "LISTA VACIA\n";
        if (!vacio()) {
            mostrar = "";
            Nodo aux = inicio;
            while (aux != null) {
                mostrar += "[ " + aux.getDato() + " ] ";
                aux = aux.getSiguiente();
            }
        }
        return mostrar;
    }

    public boolean buscar(int ref) {
        if (!vacio()) {
            Nodo aux = inicio;
            while (aux != null) {
                if (aux.getDato() == ref) {
                    return true;
                }
                aux = aux.getSiguiente();
            }
        }
        return false;
    }

    public Nodo buscarNodo(int ref) {
        if (!vacio()) {
            Nodo aux = inicio;
            while (aux != null) {
                if (aux.getSiguiente().getDato() == ref) {
                    return aux;
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }

    public void eliminarDato(int ref) {
        if (!vacio()) {
            Nodo aux = buscarNodo(ref);
            aux.setSiguiente(aux.getSiguiente().getSiguiente());
            tamanio--;
        }
    }

    public ListaSimple punto1() {
        ListaSimple i2 = new ListaSimple();
        Nodo aux = inicio;
        if (!vacio()) {
            while (aux != null) {
                if (aux.getDato() % 2 != 0) {
                    i2.agregarUltimo(aux.getDato());
                }
                aux = aux.getSiguiente();
            }
        }
        return i2;
    }

    public ListaSimple punto2() {
        ListaSimple i2 = new ListaSimple();
        if (!vacio()) {
            Nodo aux = inicio;
            while (aux.getSiguiente() != null) {
                if (inicio.getDato() % 2 != 0) {
                    i2.agregarUltimo(inicio.getDato());
                    eliminarInicio();
                    aux = aux.getSiguiente();
                } else if (aux.getSiguiente().getDato() % 2 != 0) {
                    if (aux.getSiguiente().equals(ultimo)) {
                        i2.agregarUltimo(ultimo.getDato());
                        ultimo = aux;
                        ultimo.setSiguiente(null);
                    } else {
                        i2.agregarUltimo(aux.getSiguiente().getDato());
                        aux.setSiguiente(aux.getSiguiente().getSiguiente());
                    }
                    tamanio--;
                } else {
                    aux = aux.getSiguiente();
                }
            }
        }
        return i2;
    }

    public void borrarPosiciones() {
        if (!vacio()) {
            int tam = tamanio;
            Nodo aux = inicio;
            if (tam % 2 == 0) {
                eliminarInicio();
                aux = inicio;
            }
            while (aux.getSiguiente() != null) {
                aux.setSiguiente(aux.getSiguiente().getSiguiente());
                aux = aux.getSiguiente();
                tamanio--;
            }
        }
    }

    //METODOS DE LA TAREA
    public boolean punto3() {
        int par, impar;
        par = impar = 0;
        if (!vacio()) {
            boolean flag = true;
            Nodo aux = inicio;
            while (aux != null) {
                if (flag) {
                    impar += aux.getDato();
                } else {
                    par += aux.getDato();
                }
                aux = aux.getSiguiente();
                flag = !flag;
            }
        }
//        System.out.println("IMPAR: " + impar + "\nPAR: " + par);
        borrarModificaciones(impar != par);
        return par == impar;
    }

    public void borrarModificaciones(boolean band) {
        if (!vacio()) {
            int tam = tamanio;
            Nodo aux = inicio;
            if (band) {
                eliminarInicio();
                aux = inicio;
            }
            if ((band && tam % 2 == 0) || (!band && tam % 2 != 0)) {
                while (aux.getSiguiente() != null) {
                    aux.setSiguiente(aux.getSiguiente().getSiguiente());
                    aux = aux.getSiguiente();
                    tamanio--;
                }
            } else {
                while (aux != null) {
                    if (aux.getSiguiente() == ultimo) {
                        ultimo = aux;
                    }
                    aux.setSiguiente(aux.getSiguiente().getSiguiente());
                    aux = aux.getSiguiente();
                    tamanio--;
                }
            }
        }
    }
}
