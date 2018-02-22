//只使用栈及递归函数完成栈的逆序

import java.util.Stack;

public class Q3 {
    public static int getlast(Stack<Integer> s){
        int result = s.pop();
        if(s.isEmpty()){
            return result;
        }else{
            int last=getlast(s);
            s.push(result);
            return last;
        }
    }
    public static void stackreverse(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }else{
            int last =getlast(s);
            stackreverse(s);
            s.push(last);
        }
    }
    public static void main(String[] args){
        Stack<Integer> s= new Stack<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        stackreverse(s);
        System.out.print(s.peek());
    }

}
