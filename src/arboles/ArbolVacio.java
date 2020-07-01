package arboles;

import java.util.ArrayList;
import java.util.List;

public class ArbolVacio<E extends Comparable<E>> extends Arbol<E> {

    public ArbolVacio(){
        this.valor=null;
    }

    @Override
    public List<E> preOrden() {
        return new ArrayList<E>();
    }

    @Override
    public List<E> inOrden() {
        return new ArrayList<E>();
    }

    @Override
    public List<E> posOrden() {
        return new ArrayList<E>();
    }

    @Override
    public boolean esVacio() {
        return true;
    }

    @Override
    public E valor() {
        return null;
    }

    @Override
    public Arbol<E> izquierdo() {
        return null;
    }

    @Override
    public Arbol<E> derecho() {
        return null;
    }

    @Override
    public boolean contiene(E unValor) {
        return false;
    }

    @Override
    public boolean equals(Arbol<E> unArbol) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void agregar(E a) {
        // TODO Auto-generated method stub

    }

    @Override
    public Integer altura() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer profundidad() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer cuentaHojas() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer cuentaNodosDeNivel(int nivel) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean esCompleto() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean esLleno() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Arbol<E> espejar() {
        // TODO Auto-generated method stub
        return null;
    }





}
