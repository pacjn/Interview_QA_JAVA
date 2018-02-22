//求最大子矩阵的大小
//给一个整型矩阵，求其中最大的全是1的矩阵面积

import java.util.Stack;
import java.math.*;

public class Q9 {
    public static int maxRecFromBottom(int[] height){
        if(height==null ||height.length==0){
            return 0;
        }
        int maxArea=0;
        Stack<Integer> s=new Stack<Integer>();
        for(int i=0;i< height.length;i++){
            while(!s.isEmpty() && height[i]<=height[s.peek()]){
                int j=s.pop();
                int k=s.isEmpty()?-1:s.peek();
                int curArea=(i-k-1)*height[j];
                maxArea=Math.max( maxArea,curArea);
            }
            s.push(i);
        }
        while(!s.isEmpty()) {
            int j = s.pop();
            int k = s.isEmpty() ? -1 : s.peek();
            int curArea = (height.length - k - 1) * height[j];
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }
    public static int maxRecSize(int [][] map){
        if(map==null ||map.length==0||map[0].length==0){
            return 0;
        }
        int maxArea=0;
        int[] height=new int[map[0].length];
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                height[j]=map[i][j]==0?0:height[j]+1;
            }
            maxArea=Math.max(maxArea,maxRecFromBottom(height));
        }
        return maxArea;
    }
    public static void main(String[] args){
        int[][] map={
                {1,0,1,1},
                {1,1,1,1},
                {1,1,1,0},
                {0,1,1,1}
        };
        System.out.print(maxRecSize(map));
    }
}
