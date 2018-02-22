//使用数组构造一个二叉树使得父节点始终大于子节点，且复杂度及额外空间复杂度为O(n)
import java.util.Stack;
import java.util.HashMap;

class Node{
    public int value;
    public Node left;
    public Node right;
    public Node(int data){
        this.value =data;
    }
}

public class Q8 {
    public static void popStackSetMap(Stack<Node> stack,HashMap<Node,Node> map){
        Node popNode=stack.pop();
        if(stack.isEmpty()){
            map.put(popNode,null);
        }else{
            map.put(popNode,stack.peek());
        }
    }
    public static Node getMaxTree(int[] arr){
        Node[] nArr=new Node[arr.length];
        for(int i=0; i != arr.length; i++){
            nArr[i]=new Node(arr[i]);
        }
        Stack<Node> stack=new Stack<Node>();
        HashMap<Node,Node> lmap=new HashMap<Node,Node>();
        HashMap<Node,Node> rmap=new HashMap<Node,Node>();
        for(int i=0;i!=arr.length;i++){
            Node curNode=nArr[i];
            if((!stack.isEmpty())&&curNode.value>stack.peek().value){
                popStackSetMap(stack,lmap);
            }
            stack.push(curNode);
        }
        while(!stack.isEmpty()){
            popStackSetMap(stack,lmap);
        }
        for(int i=arr.length-1;i!=-1;i--){
            Node curNode=nArr[i];
            if((!stack.isEmpty())&&curNode.value>stack.peek().value){
                popStackSetMap(stack,rmap);
            }
            stack.push(curNode);
        }
        while(!stack.isEmpty()){
            popStackSetMap(stack,rmap);
        }
        Node head=null;
        for(int i=0;i!=nArr.length;i++){
            Node curNode =nArr[i];
            Node left=lmap.get(curNode);
            Node right=rmap.get(curNode);
            if(left ==null &&right==null){
                head=curNode;
            }else if(left==null){
               if(right.left==null){
                   right.left=curNode;
               }else{
                   right.right=curNode;
               }
            }else if(right==null){
                if(left.left==null){
                    left.left=curNode;
                }else{
                    left.right=curNode;
                }
            }else{
                Node parent=left.value<right.value? left:right;
                if(parent.left==null){
                    parent.left=curNode;
                }else{
                    parent.right=curNode;
                }
            }
        }
        return head;
    }
    public static void printtree(Node t){
        if(t ==null){
            return;
        }
        printtree(t.left);
        System.out.print(t.value);
        printtree(t.right);
        //System.out.print(t.value);

    }
    public static void main(String[] args){
        int[] arr={1,2,3,6,5,4};
        Node tree = getMaxTree(arr);
        //System.out.print(tree.value);
        printtree(tree);
    }
}
