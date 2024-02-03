public class RemoveNthNodeFromEndofList {

    public static void main(String[] args) {
        var removeNthNodeFromEndofList = new RemoveNthNodeFromEndofList();

        var head = create(1, 1);

        printNode(head);
        head = removeNthNodeFromEndofList.removeNthFromEnd(head, 1);

        printNode(head);
    }

    public static void printNode(ListNode listNode) {
        if (listNode == null) {
            System.out.println("null");
            return;
        }

        var head = listNode;
        System.out.print(head + " ");
        while (head.next != null) {
            head = head.next;
            System.out.print(head + " ");
        }

        System.out.println();
    }

    public static ListNode create(int size, int i) {
        ListNode listNode = new ListNode(i);
        if (size != 1) {
            listNode.next = create(size-1, i + 1);
        }

        return listNode;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {



        // CASE ONE ELEMENT
        if (head.next == null && n == 1) {
            return null;
        }

        // CASE LAST ELEMENT
        if (n == 1) {
            var first = head;

            while (head.next.next != null) {
                head = head.next;
            }

            head.next = null;

            return first;
        }

        // GENERAL CASE
        var first = head;

        int counter = 1;
        ListNode tail = head;
        boolean moved = false;

        while (head.next != null) {
            head = head.next;
            counter++;
            if (counter > n + 1) {
                tail = tail.next;
                moved = true;
            }
            if (counter == n + 1) {
                moved = true;
            }
        }

        if (moved) {
            tail.next = tail.next.next;
            return first;
        } else {
            first = tail.next;
            return first;
        }
    }
}
