import java.util.List;

public class ReverseListNode {
    public ListNode reverse(ListNode listNode){
        if(listNode == null || listNode.next == null) return listNode;

        ListNode pre = null;

        while (listNode != null){
            ListNode tempNode = listNode.next;
            listNode.next = pre;
            pre = listNode;
            listNode = tempNode;

        }

        return pre;
    }
}
