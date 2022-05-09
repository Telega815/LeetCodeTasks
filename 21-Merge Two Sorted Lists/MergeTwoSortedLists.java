import java.util.List;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();


        ListNode listNode1 = null;
//        ListNode listNode1 = new ListNode(1);
//        listNode1.next = new ListNode(2);
//        listNode1.next.next = new ListNode(4);

        ListNode listNode2 = new ListNode(0);
//        listNode2.next = new ListNode(3);
//        listNode2.next.next = new ListNode(4);


        var res = mergeTwoSortedLists.mergeTwoLists(listNode1, listNode2);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }



    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();

        ListNode cur = res;

        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null) {
            cur.val = list2.val;
            list2 = list2.next;
        } else if (list2 == null) {
            cur.val = list1.val;
            list1 = list1.next;
        } else if (list1.val < list2.val) {
            cur.val = list1.val;
            list1 = list1.next;
        } else {
            cur.val = list2.val;
            list2 = list2.next;
        }

        if (list1 != null || list2 != null) {
            cur.next = new ListNode();
            cur = cur.next;
        }

        while (true) {
            if (list1 == null && list2 == null) {
                break;
            } else if (list1 == null) {
                cur.val = list2.val;
                list2 = list2.next;
            } else if (list2 == null) {
                cur.val = list1.val;
                list1 = list1.next;
            } else if (list1.val < list2.val) {
                cur.val = list1.val;
                list1 = list1.next;
            } else {
                cur.val = list2.val;
                list2 = list2.next;
            }

            if (list1 == null && list2 == null) {
                break;
            }

            cur.next = new ListNode();
            cur = cur.next;
        }

        return res;
    }


     static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
