//用一个栈实现另一个栈的排序
import java.util.Stack;

public class Q5 {
    public static void Stacksort(Stack<Integer> s){
        Stack<Integer> tmp= new Stack<Integer>();
        while(!s.isEmpty()){
            int cur=s.pop();

            while(!tmp.isEmpty()&&cur<tmp.peek()){
                s.push(tmp.pop());
            }
            tmp.push(cur);
        }
        while(!tmp.isEmpty()){
            s.push(tmp.pop());
        }
    }
    public static void main(String[] args){
        Stack<Integer> s= new Stack<Integer>();
        s.push(1);
        s.push(3);
        s.push(2);
        s.push(4);
        Stacksort(s);
        System.out.print(s.pop());
        System.out.print(s.pop());
        System.out.print(s.pop());
        System.out.print(s.pop());
    }
}
