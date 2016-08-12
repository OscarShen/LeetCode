package linkedList.reverseLinkedList;

public class ReverseLinkedList01 {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode t = null;
		ListNode t1 = null;
		ListNode t2 = null;

		t = head;
		t1 = head.next;
		t2 = t1.next;
		head.next = null;

		while (t2 != null) {
			t1.next = t;
			t = t1;
			t1 = t2;
			t2 = t2.next;
		}
		t1.next = t;
		return t1;
	}
}
