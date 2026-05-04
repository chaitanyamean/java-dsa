class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(0);
        ListNode current = dummyNode;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummyNode.next;
    }

    // Helper to build a linked list from an array
    static ListNode build(int[] vals) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int v : vals) {
            cur.next = new ListNode(v);
            cur = cur.next;
        }
        return dummy.next;
    }

    // Helper to print a linked list
    static String print(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append(", ");
            head = head.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(print(sol.mergeTwoLists(build(new int[]{1, 2, 4}), build(new int[]{1, 3, 4})))); // [1, 1, 2, 3, 4, 4]
        System.out.println(print(sol.mergeTwoLists(build(new int[]{}), build(new int[]{}))));                // []
        System.out.println(print(sol.mergeTwoLists(build(new int[]{}), build(new int[]{0}))));               // [0]
    }
}
