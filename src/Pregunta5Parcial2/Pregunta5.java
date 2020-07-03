package Pregunta5Parcial2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Pregunta5 {

    /*
    public static int detectarArreglos(int[] V1, int[] V2){
        int agregado = detectarArreglosAux(V1,V2);
        int rtn=-1;
        for (int i=0;i<V1.length;i++){
            if(V1[i] == agregado){rtn=i;}
        }
        return rtn;
    }
    public static int detectarArreglosAux(int[] V1, int[] V2){
        if(V1[0] == V2[0]){
            return detectarArreglosAux(Arrays.copyOfRange(V1,1,V1.length),Arrays.copyOfRange(V2,1,V2.length));
        }else{
            return V1[0];
        }
    }
         */
    public static int detectarArreglos(int[] V1, int[] V2){
        int agregado = detectarArreglosAux(V1,V2);
        int rtn=-1;
        for (int i=0;i<V1.length;i++){
            if(V1[i] == agregado){rtn=i;}
        }
        return rtn;
    }
    public static int detectarArreglosAux(int[] V1, int[] V2){
        if(V2.length ==1) {
            if (V1.length == 1) {
                if (V1[0] == V2[0]) {
                    return 0;
                } else {
                    return V1[0];
                }
            } else if (V1.length == 2) {
                if (V1[0] == V2[0]) {
                    if (V1[1] == V2[0]) {
                        return 0;
                    } else {
                        return V1[1];
                    }

                } else {
                    return V1[0];
                }
            }
        }
        return detectarArreglosAux(Arrays.copyOfRange(V1,0,V1.length/2),Arrays.copyOfRange(V2,0,V2.length/2))
                + detectarArreglosAux(Arrays.copyOfRange(V1,(V1.length/2),V1.length),Arrays.copyOfRange(V2,(V2.length/2),V2.length));
    }
}

