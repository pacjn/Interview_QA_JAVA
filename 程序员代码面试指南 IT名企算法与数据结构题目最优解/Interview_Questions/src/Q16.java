//环形单链表的约瑟夫问题

class Node16{
    int value;
    Node16 next;
    Node16(int data){
        this.value=data;
    }
}

public class Q16 {
    public static Node16 josephusKill1(Node16 head, int m){
        if(head==null || head.next==head || m<1){
            return head;
        }
        Node16 last=head;
        while(last.next!=head){
            last=last.next;
        }
        int count=0;
        while(head!=last){
            if(++count==m){
                last.next=head.next;
                count=0;
            }else{
                last=last.next;
            }
            head=last.next;
        }
        return head;
    }

    public static Node16 josephusKill2(Node16 head,int m){
        if(head==null || head.next==head || m<1){
            return head;
        }
        Node16 cur=head.next;
        int live=1;
        while(cur!=head){
            live++;
            cur=cur.next;
        }
        live=getLivenum(live,m);
        while(--live!=0){
            head=head.next;
        }
        head.next=head;
        return head;
    }
    //利用old=(new+m-1)%i+1 判断最终存活的位置
    public static int getLivenum(int i,int m){
        if(i==1){
            return 1;
        }else{
            return (getLivenum(i-1,m)+m-1)%i+1;
        }
    }

}
