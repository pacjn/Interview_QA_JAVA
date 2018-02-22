//给定两个有序链表的头指针 打印两个链表的公共部分
// 从本题开始进入链表问题

class Node11{
    public int value;
    public Node11 next;
    public Node11(int data){
        this.value=data;
    }
}

public class Q11 {
    public static void printCommonPart(Node11 a1,Node11 a2){
        System.out.print("Common Part: ");
        while(a1 != null && a2 != null){
            if(a1.value < a2.value){
                a1=a1.next;
            }else if(a1.value > a2.value){
                a2=a2.next;
            }else{
                System.out.print(a1.value);
                a1=a1.next;
                a2=a2.next;
            }
        }
        System.out.println();
    }
    public static void main(String[] args){
        Node11 a1=new Node11(1);
        Node11 a2=new Node11(2);
        a1.next=new Node11(2);
        a1.next.next=new Node11(3);
        a2.next=new Node11(4);
        printCommonPart(a1,a2);
    }
}
