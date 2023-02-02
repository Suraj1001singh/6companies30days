import java.util.*;

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        ListNode prehead = new ListNode(0);
        prehead.next = head;
        for (ListNode h = prehead; h != null; h = h.next) {
            sum += h.val;
            map.put(sum, h);
        }
        sum = 0;
        for (ListNode h = prehead; h != null; h = h.next) {
            sum += h.val;
            h.next = map.get(sum) != null ? map.get(sum).next : null;
        }
        return prehead.next;
    }
}