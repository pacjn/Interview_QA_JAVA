//反转部分单向链表

class Node15{
    public int value;
    public Node15 next;
    public Node15(int data){
        this.value=data;
    }
}

public class Q15 {
    public static Node15 reversePart(Node15 head,int from, int to){
        int len=0;
        Node15 cur=head;
        Node15 fir=null;
        Node15 las=null;
        while(cur!=null){
            len++;
            fir= len==from-1? cur:fir;
            las= len==to+1? cur:las;
            cur=cur.next;
        }
        if(from>to || from<1 || to>len){
            return head;
        }
        cur= fir==null? head:fir.next;
        Node15 cur_next=cur.next;
        cur.next=las;
        Node15 next=null;
        while(cur_next!=las){
            next=cur_next.next;
            cur_next.next=cur;
            cur=cur_next;
            cur_next=next;
        }
        if(fir!=null){
            fir.next=cur;
            return head;
        }
        return cur;
    }
}
