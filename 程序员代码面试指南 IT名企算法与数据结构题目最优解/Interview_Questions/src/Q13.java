//删除链表的中间节点和a/b处的节点

class Node13{
    public int value;
    public Node13 next;
    public Node13(int data){
        this.value=data;
    }
}

public class Q13 {
    public Node13 removeMidNode(Node13 head){
        if(head==null || head.next==null){
            return head;
        }
        Node13 cur=head;
        Node13 prev;
        if(cur.next.next==null){
            return head.next;
        }else{
            prev=head;
            cur=cur.next.next;
        }
        while(cur.next.next!=null && cur.next!=null){
            cur=cur.next.next;
            prev=prev.next;
        }
        prev.next=prev.next.next;
        return head;
    }
    public Node13 removeabNode(Node13 head,int a,int b){
        if(a<1 || a>b){
            return head;
        }
        int n=0;
        Node13 cur=head;
        while(cur!=null){
            n++;
            cur=cur.next;
        }

        n=(int)Math.ceil((double)a*n/(double)b);
        if(n==1){
            head=head.next;
        }else{
            cur=head;
            while(--n!=1){
                cur=cur.next;
            }
            cur.next=cur.next.next;
        }

        return head;
    }
}
