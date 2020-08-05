import estructuras.grafos.Grafo;
import estructuras.grafos.GrafoDirigido;
import estructuras.grafos.Vertice;

public class Main {

    public static void main(String[] args) {

       /* PRUEBA EJERCICIO PARCIAL: metodo nodosAlcanzables()


        */

        GrafoDirigido<Integer> g1 = new GrafoDirigido<>();

        g1.addNodo(1);
        g1.addNodo(2);
        g1.addNodo(3);
        g1.addNodo(4);
        g1.addNodo(5);
        g1.addNodo(6);
        g1.addNodo(7);
        g1.addNodo(8);
        g1.addNodo(9);
        g1.addNodo(10);
        g1.addNodo(11);

        g1.conectar(1,2);
        g1.conectar(1, 3);
        g1.conectar(1,4);
        g1.conectar(2,5);
        g1.conectar(2,6);
        g1.conectar(3,7);
        g1.conectar(4,8);
        g1.conectar(6,10);
        g1.conectar(10,9);
        g1.conectar(7,9);
        g1.conectar(8,9);
        g1.conectar(9,11);

        /**             5
         *            /
         *          /
         *        2 ---- 6 ---10
         *      /              \
         *    /                 \
         *  1   --- 3 --- 7 ---- 9 --- 11
         *    \                /
         *     \             /
         *      4 -------- 8
         *
         *
         */
        System.out.println(g1.nodosAlcanzables(new Vertice<>(1),4));
    }
}
