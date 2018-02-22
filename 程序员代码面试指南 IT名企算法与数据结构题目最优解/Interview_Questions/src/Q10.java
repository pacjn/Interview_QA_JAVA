//给定数组中 子数组最大值减最小值等于给定num的数量
//max(arr[i..j])-min(arr[i..j])<=num
import java.util.LinkedList;

public class Q10 {
    public static int getNum(int[] arr,int num){
        int res=0;
        if(arr==null||arr.length==0){
            return res;
        }
        LinkedList<Integer> qmin=new LinkedList<Integer>();
        LinkedList<Integer> qmax=new LinkedList<Integer>();
        int i=0;
        int j=0;
        while(i<arr.length){
            while(j<arr.length){
                while(!qmin.isEmpty()&&arr[qmin.peekLast()]>=arr[j]){
                    qmin.pollLast();
                }
                qmin.addLast(j);
                while(!qmax.isEmpty()&&arr[qmin.peekLast()]<=arr[j]){
                    qmax.pollLast();
                }
                qmax.addLast(j);
                if(arr[qmax.getFirst()]-arr[qmin.getFirst()]>num){
                    break;
                }
                j++;
            }
            if(qmin.peekFirst()==i){
               qmin.pollFirst();
            }
            if(qmax.peekFirst()==i){
                qmax.pollFirst();
            }
            res+=j-i;
            i++;
        }
        return res;
    }
    public static void main(String[] args){
        int[] arr={1,2,3,4,5};
        System.out.print(getNum(arr,5));
    }
}
