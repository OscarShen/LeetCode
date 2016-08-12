package linkedList.reverseLinkedList;

public class ReverseLinkedList02 {
	public ListNode reverseList(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;

		ListNode t = null;
		ListNode t1 = null;
		t = head.next;
		t1 = reverseList(t);
		
		head.next = null;
		t.next = head;
		return t1;
	}
}
