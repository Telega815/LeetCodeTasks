public class SwapNodesInPairs {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode create(int[] arr, int index) {
        if (arr == null) {
            return new ListNode();
        }

        if (arr.length > index + 1){
            return new ListNode(arr[index], create(arr, index + 1));
        }


        return new ListNode(arr[index]);
    }

    public static void main(String[] args) {
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();



//        int [] arr = {1,2,3,4};
//        ListNode head = create(arr, 0);

        int [] arr = {1};
        ListNode head = create(arr, 0);

        var pointer = head;
        do {
            System.out.print(pointer.val + " ");
            pointer = pointer.next;
        } while (pointer != null);
        System.out.println();

        head = swapNodesInPairs.swapPairs(head);

        pointer = head;
        do {
            System.out.print(pointer.val + " ");
            pointer = pointer.next;
        } while (pointer != null);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }


        if (head.next == null) {
            return head;
        }

        if (head.next.next == null) {
            var y = head.next;
            y.next = head;
            head.next = null;
            return y;
        }

        var y = head.next;
        var z = y.next;
        y.next = head;
        head.next = swapPairs(z);
        return y;
    }

}
