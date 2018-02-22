//利用两个栈实现队列

import java.util.Stack;

class Myqueue{
    public Stack<Integer> stackpush;
    public Stack<Integer> stackpop;

    public Myqueue(){
        stackpush=new Stack<Integer>();
        stackpop=new Stack<Integer>();
    }

    public void add(int num){
        stackpush.push(num);
    }

    public int poll(){
        if(stackpush.isEmpty() && stackpop.isEmpty()){
            throw new RuntimeException("Empty");
        }else if(stackpop.isEmpty()){
            while(!stackpush.isEmpty()){
                stackpop.push(stackpush.pop());
            }
        }
        return stackpop.pop();
    }

    public int peek(){
        if(stackpush.isEmpty() && stackpop.isEmpty()){
            throw new RuntimeException("Empty");
        }else if(stackpop.isEmpty()){
            while(!stackpush.isEmpty()){
                stackpop.push(stackpush.pop());
            }
        }
        return stackpop.peek();
    }
}

public class Q2 {
    public static void main(String[] args){
        Myqueue newqueue= new Myqueue();
        newqueue.add(1);
        newqueue.add(2);
        newqueue.add(3);
        newqueue.add(4);
        System.out.println(newqueue.poll());
        System.out.println(newqueue.poll());
        System.out.println(newqueue.poll());
        System.out.println(newqueue.peek());
        System.out.println(newqueue.poll());
    }
}
