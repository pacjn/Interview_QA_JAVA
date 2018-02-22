//实现两个函数，一，把单链表中删除倒数第K个节点，二，从双链表中删除倒数第K个节点

class Node12{
    public int value;
    public Node12 next;
    public Node12(int data){
        this.value=data;
    }
}

class Node12_D{
    public int value;
    public Node12_D prev;
    public Node12_D next;
    public Node12_D(int data){
        this.value=data;
    }
}

public class Q12 {
    public static Node12 removeReverseKth(Node12 head,int k){
        if(head==null || k<0){
            return head;
        }
        Node12 cur=head;
        while(cur!=null){
            cur=cur.next;
            k--;
        }
        if(k>0){
            return head;
        }else if(k==0){
            head=head.next;
        }else{
            cur=head;
            k++;
            while(k!=0){
                cur=cur.next;
                k++;
            }
            cur.next=cur.next.next;
        }
        return head;
    }

    public static Node12_D removeReverseKth_D(Node12_D head,int k){
        if(head==null || k<0){
            return head;
        }
        Node12_D cur=head;
        while(cur!=null){
            cur=cur.next;
            k--;
        }
        if(k>0){
            return head;
        }else if(k==0){
            head=head.next;
            head.prev=null;
        }else{
            cur=head;
            k++;
            while(k!=0){
                cur=cur.next;
                k++;
            }
            if(cur.next.next!=null){
                cur.next.next.prev=cur;
            }
            cur.next=cur.next.next;
        }
        return head;
    }


    public static void main(String[] args){
        Node12 ll=new Node12(0);
        Node12 cur=ll;
        cur.next=new Node12(1);
        cur=cur.next;
        cur.next=new Node12(2);
        cur=cur.next;
        cur.next=new Node12(3);
        cur=cur.next;
        cur.next=new Node12(4);
        cur=cur.next;
        cur.next=new Node12(5);
        cur=cur.next;
        cur.next=new Node12(6);
        cur=cur.next;
        cur=removeReverseKth(ll,6);
        while(cur!=null){
            System.out.print(cur.value);
            cur=cur.next;
        }
    }
}
