class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode temp = dummy;

        while (head != null) {

            if (head.next != null && head.val == head.next.val) {

                int x = head.val;

                while (head != null && head.val == x) {
                    head = head.next;
                }

                temp.next = head;
            }
            else {
                temp = temp.next;
                head = head.next;
            }
        }

        return dummy.next;
    }
}