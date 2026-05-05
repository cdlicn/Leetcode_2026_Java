public class Main_61 {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null) {
                return head;
            }
            ListNode node = head;
            int n = 1;
            while (node.next != null) {
                node = node.next;
                n++;
            }
            node.next = head;
            n = n - k % n - 1;
            while (n > 0) {
                head = head.next;
                n--;
            }
            ListNode tmp = head.next;
            head.next = null;
            return tmp;
        }
}
