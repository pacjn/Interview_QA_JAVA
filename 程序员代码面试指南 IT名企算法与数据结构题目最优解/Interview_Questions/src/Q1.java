import java.util.Stack;

class Mystack1{
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;
    public Mystack1(){
        this.stackData=new Stack<Integer>();
        this.stackMin=new Stack<Integer>();
    }
    public void push(int NewNum){
        if(this.stackMin.isEmpty()){
            this.stackMin.push(NewNum);
        }else if(NewNum<=this.getmin()) {
            this.stackMin.push(NewNum);
        }
    }

    public int pop() {
        if(this.stackData.isEmpty()){
            throw new RuntimeException("Your stack is Empty!");
        }
        int value=this.stackData.pop();
        if(value==this.stackMin.peek()) {
            this.stackMin.pop();
        }
        return value;
    }

    public int getmin(){
        if (this.stackMin.isEmpty()){
            throw new RuntimeException("Your stack is Empty!");
        }else{
            return this.stackMin.peek();
        }
    }
}
public class Q1 {

    public static void main(String[] args){
        Mystack1 s=new Mystack1();
        s.push(10);
        System.out.println(s.getmin());
        s.push(9);
        System.out.println(s.getmin());
        s.push(8);
        System.out.println(s.getmin());
        s.push(7);
        System.out.println(s.getmin());
    }

}