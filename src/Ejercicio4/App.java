package Ejercicio4;

import estructuras.grafos.Arista;
import estructuras.grafos.Grafo;
import estructuras.grafos.Vertice;

public class App {
    public Grafo<Integer> g1 = new Grafo<Integer>();

		g1.addNodo(4);
		g1.addNodo(8);
		g1.addNodo(12);
		g1.addNodo(16);
		g1.conectar(4, 8);
		g1.conectar(4, 12);
		g1.conectar(12, 16);
		g1.conectar(8, 12);
		g1.conectar(12, 4);

    /**     8
     *    / |
     *  4   |
     *    \ |
     *      12 ---> 16
     *
     *
     */

		System.out.println(g1.hayCamino(new Vertice<Integer>(4), new Vertice<Integer>(16)));
		System.out.println(g1.hayCamino(new Vertice<Integer>(16), new Vertice<Integer>(8)));
		System.out.println(g1.hayCamino(new Vertice<Integer>(8), new Vertice<Integer>(4)));
}
