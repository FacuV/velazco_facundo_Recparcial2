package arboles;

import java.util.ArrayList;
import java.util.List;

public class ArbolBinarioBusqueda<E extends Comparable<E>> extends Arbol<E> {

    protected Arbol<E> izquierdo;
    protected Arbol<E> derecho;

    public ArbolBinarioBusqueda(){
        this.valor=null;
        this.izquierdo=new ArbolVacio<E>();
        this.derecho=new ArbolVacio<E>();
    }

    public ArbolBinarioBusqueda(E e){
        this.valor=e;
        this.izquierdo=new ArbolVacio<E>();
        this.derecho=new ArbolVacio<E>();
    }

    public ArbolBinarioBusqueda(E e,Arbol<E> i,Arbol<E> d){
        this.valor=e;
        this.izquierdo=i;
        this.derecho=d;
    }

    @Override
    public List<E> preOrden() {
        List<E> lista = new ArrayList<E>();
        lista.add(this.valor);
        lista.addAll(this.izquierdo.preOrden());
        lista.addAll(this.derecho.preOrden());
        return lista;
    }
    @Override
    public List<E> inOrden() {
        List<E> lista = new ArrayList<E>();
        lista.addAll(this.izquierdo.preOrden());
        lista.add(this.valor);
        lista.addAll(this.derecho.preOrden());
        return lista;
    }
    @Override
    public List<E> posOrden() {
        List<E> lista = new ArrayList<E>();
        lista.addAll(this.izquierdo.preOrden());
        lista.addAll(this.derecho.preOrden());
        lista.add(this.valor);
        return lista;

    }
    @Override
    public boolean esVacio() {
        return false;
    }

    @Override
    public E valor() {
        return this.valor;
    }

    @Override
    public Arbol<E> izquierdo() {
        return this.izquierdo;
    }

    @Override
    public Arbol<E> derecho() {
        return this.derecho;
    }


    @Override
    public void agregar(E a) {
        if(this.valor.compareTo(a)<1) {
            if (this.derecho.esVacio()) this.derecho = new ArbolBinarioBusqueda<E>(a);
            else this.derecho.agregar(a);
        }else {
            if (this.izquierdo.esVacio()) this.izquierdo= new ArbolBinarioBusqueda<E>(a);
            else this.izquierdo.agregar(a);
        }
    }

    @Override
    public boolean equals(Arbol<E> unArbol) {
        return this.valor.equals(unArbol.valor()) && this.izquierdo.equals(unArbol.izquierdo()) && this.derecho.equals(unArbol.derecho());
    }

    @Override
    public boolean contiene(E unValor) {
        // TODO Auto-generated method stub
        return false;
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
