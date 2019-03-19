import java.util.*;
public class bd {
    public static int minnum(int numOFGS, int[] distOFGS, int[] allowedGasoline, int distance, int initialGasoline){
    int iter = 0;
    int lo = 0;
    while(initialGasoline<distance){
//        System.out.println(initialGasoline);
        if (lo == numOFGS || initialGasoline < distOFGS[lo] ){
            return -1;
        }
        int max = 0;
        int new_lo = 0;
        for(; lo< numOFGS;lo++){
            if (initialGasoline >= distOFGS[lo]){
                if (max <= allowedGasoline[lo]){
                    max = allowedGasoline[lo];
                    new_lo = lo;
                }
            }else
                {break;}
        }
        initialGasoline += max;
        lo = new_lo+1;
        if(distance != distOFGS[numOFGS-1])
            iter +=1;
    }

    return iter;

};

    public static void main(String[] args) {
        int res = minnum(3, new int[]{5,7,10},new int[]{2,3,5}, 15,5);
        System.out.println(res);

    }
}
