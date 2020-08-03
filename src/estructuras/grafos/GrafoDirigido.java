package estructuras.grafos;

import estructuras.grafos.Grafo;
import estructuras.grafos.Vertice;

import java.util.*;

public class GrafoDirigido<T> extends Grafo<T> {

    public GrafoDirigido(){
        super();
    }

   public boolean existeCaminoRec(T init,T fin){
        if(getAdyacentes(init).contains(fin)){
            return true;
        }else {
            for (T ver : getAdyacentes(init)) {
                return existeCaminoRec(ver,fin);
            }
        }
        return false;
    }
    public boolean existeCaminoRec(T init,T fin,int N){
        if(getAdyacentes(init).contains(fin) && N == 1){
            return true;
        }else {
            for (T ver : getAdyacentes(init)) {
                return existeCaminoRec(ver,fin,N-1);
            }
        }
        return false;
    }

    public boolean existeCaminoIt(T init,T fin){
        HashSet marcados = new HashSet();
        List ady = getAdyacentes(init);

        marcados.add(init);
        if(ady.contains(fin)){return true;}

        T unNodo;
        while(!ady.isEmpty()){
            unNodo = (T) ady.get(0);
            marcados.add(unNodo);
            if(getAdyacentes(unNodo).contains(fin)){return true;}
            for (T adys: getAdyacentes(unNodo)){
                if(!marcados.contains(adys)){ady.add(unNodo);}
            }
            ady.remove(unNodo);
        }
        return false;
    }
    public boolean existeCaminoIt(T init,T fin,int N){
        HashSet marcados = new HashSet();
        Queue ady = new LinkedList();
        ady.addAll(getAdyacentes(init));
        int cont =1;

        marcados.add(init);
        if(ady.contains(fin) ){return true;}
        int i = ady.size();
        T unNodo;
        cont++;
        while(!ady.isEmpty()){
            unNodo = (T) ady.poll();
            if(i == 0){
                cont++;
                i = ady.size();
            }
            i--;
            marcados.add(unNodo);
            if(getAdyacentes(unNodo).contains(fin)){return true;}

            for (T adys: getAdyacentes(unNodo)){
                if(!marcados.contains(adys)){ady.add(unNodo);}
            }

        }
        return false;
    }
}
