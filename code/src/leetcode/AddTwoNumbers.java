package leetcode;

/**
 * 2. Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */

class AddTwoNumbersSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curNode = null;
        ListNode headNode = null;
        ListNode curL1 = l1;
        ListNode curL2 = l2;
        int carry = 0;
        while (curL1 != null || curL2 != null) {
            int sum = getNodeValue(curL1) + getNodeValue(curL2) + carry;
            carry = sum / 10;
            ListNode temp = new ListNode(sum % 10);
            if (curNode == null) {
                curNode = temp;
                headNode = curNode;
            } else {
                curNode.next = temp;
                curNode = temp;
            }

            curL1 = getNextNode(curL1);
            curL2 = getNextNode(curL2);
        }
        if (carry != 0) {
            curNode.next = new ListNode(carry);
        }
        return headNode;
    }

    private int getNodeValue(ListNode l){
        if (l == null) {
            return 0;
        }
        return l.val;
    }

    private ListNode getNextNode(ListNode l) {
        if (l == null) {
            return null;
        }
        return l.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
