public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);



        var res = addTwoNumbers.addTwoNumbers(l1, l2);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode res = new ListNode();

        ListNode currentRes = res;
        int left = 0;
        do {
            int val1 = 0;
            int val2 = 0;

            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }

            int sum = val1 + val2 + left;

            if (sum < 10) {
                currentRes.val = sum;
                left = 0;
            } else {
                currentRes.val = sum - 10;
                left = 1;
            }

            if (l1 != null || l2 != null || left != 0) {
                currentRes.next = new ListNode();
                currentRes = currentRes.next;
            }
        } while (l1 != null || l2 != null || left != 0);

        return res;
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
