//有一个整形数组arr和大小为w的窗口从数组左侧划向右侧，返回每一个窗口中的最大值

import java.util.LinkedList;
import java.util.Arrays;

public class Q7 {
    public static int[] getMaxwindow(int[] arr,int w){
        if(arr==null ||w<1 || arr.length<w){
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int[] res = new int[arr.length-w+1];
        int index=0;
        for(int i=0;i<arr.length;i++){
            while(!qmax.isEmpty()&&arr[qmax.peekLast()]<=arr[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);
            if(qmax.peekFirst()==i-w){
                qmax.pollFirst();
            }
            if(i>=w-1){
                res[index++]=arr[qmax.peekFirst()];
            }
        }

        return res;
    }
    public static void main(String[] args){
        int[] arr={3,4,3,5,4,3,3,6,7};
        int[] b=getMaxwindow(arr,3);
        System.out.println(Arrays.toString(b));
    }

}
