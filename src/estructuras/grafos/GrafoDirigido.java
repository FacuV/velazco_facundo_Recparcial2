package estructuras.grafos;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        List ady = new ArrayList();
        ady.add(init);
        T unNodo;
        while(!ady.isEmpty()){
            unNodo = (T) ady.get(0);
            marcados.add(unNodo);
            List<T> aux = getAdyacentes(unNodo);
            if(aux.contains(fin)){return true;}
            for (T adys: aux){
                if(!marcados.contains(adys)){ady.add(adys);}
            }
            ady.remove(0);
        }
        return false;
    }
    public boolean existeCaminoIt(T init,T fin,int N){
        HashSet marcados = new HashSet();
        List ady = new ArrayList();
        int cont = 0,i = 0;
        ady.add(init);
        T unNodo;
        while(!ady.isEmpty()){
            unNodo = (T) ady.get(0);
            if(i == 0){
                cont++;
                i = ady.size();
            }
            i--;
            marcados.add(unNodo);
            if(getAdyacentes(unNodo).contains(fin) && cont == N){return true;}

            for (T adys: getAdyacentes(unNodo)){
                if(!marcados.contains(adys)){ady.add(adys);}
            }
            ady.remove(0);
        }
        return false;
    }
    /*
    public List<List<T>> todosLosCaminosIt(T init, T fin){
        List<List<T>> rtn = new ArrayList<>();
        List<T> ady = new ArrayList();
        int cont = 0, i = 0;
        ady.add(init);
        T unNodo;
        T anterior = null;
        while(!ady.isEmpty()){
            unNodo = (T) ady.get(0);
            if(i == 0){
                i = ady.size();
                cont = i;

            }
            i--;

            if(anterior == null){
                ArrayList aux = new ArrayList();aux.add(unNodo);rtn.add(aux);
            }else{
                while ()

            }
            ady.addAll(getAdyacentes(unNodo));
            ady.remove(0);
        }
        return rtn;
    }

     */
    public List<List> todosLosCamionosRec(T origen, T destino) {
        List aux1 = new ArrayList();
        List aux2 = new ArrayList();
        aux2.add(aux1);
        //Si llegue al destino
        if (origen.equals(destino)) {
            aux1.add(destino);
            return aux2;
        }
        //obtengo adyacentes
        List<T> ady = getAdyacentes(origen);
        //Si llegue a una rama muerta
        if (ady.isEmpty()) {
            return aux2;
        }

        List<List> caminosAdy = new ArrayList();
        //Recibo las listas de caminos posibles segun mis nodos adyasentes
        //Creo que tiene un problema, empaqueta el resultado en una lista de forma indeseada, mas abajo hago dos for para desempaquetar
        for (T p : ady) {
            caminosAdy.add((List) Stream.concat(aux1.stream(), todosLosCamionosRec(p, destino).stream()).collect(Collectors.toList()));
        }
        //por si estoy en una rama muerta
        if (caminosAdy.size() == 1 && caminosAdy.get(0).isEmpty()) {
            return aux2;
        }
        //Genero la lista con el origen del camino
        List resultado = new ArrayList();
        List listaA = new ArrayList();
        listaA.add(origen);
        //Agrego al inicio de todos los caminos el origen
        for (List<List> list : caminosAdy) {
            //solucionando el problema de desempaquetar los caminos
            for (List listaux : list) {
                //Si el camino no era camino muerto me agrego como inicio, de lo contrario lo ignoro
                if (!list.get(0).isEmpty()) {
                    resultado.add(Stream.concat(listaA.stream(), listaux.stream()).collect(Collectors.toList()));
                }
            }
        }
        return resultado;
    }

}
