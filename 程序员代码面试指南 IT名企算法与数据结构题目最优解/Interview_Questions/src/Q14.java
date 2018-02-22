//实现反转单向链表和反转双向链表的函数

class Node14{
    public int value;
    public Node14 next;
    public Node14(int data){
        this.value=data;
    }
}

class Node14_D{
    public int value;
    public Node14_D prev;
    public Node14_D next;
    public Node14_D(int data){
        this.value=data;
    }
}

public class Q14 {
    public Node14 reverseList(Node14 head){
        Node14 pre=null;
        Node14 next=null;
        while(head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }

    public Node14_D reverseDList(Node14_D head){
        Node14_D pre=null;
        Node14_D next=null;
        while(head!=null){
            next=head.next;
            head.next=pre;
            head.prev=next;
            pre=head;
            head=next;
        }
        return pre;
    }
}
