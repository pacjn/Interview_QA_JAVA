//判断链表是否为回文
//普通解法，将后半部分入栈，再出栈与前半部分对比
//进阶解法 将后半部分逆序 使用两个链头开始对比 再将链表恢复

class Node17{
    int value;
    Node17 next;
    Node17(int data){
        this.value=data;
    }
}

public class Q17 {
    public static boolean isPalindrome(){
        return true;
    }
}
