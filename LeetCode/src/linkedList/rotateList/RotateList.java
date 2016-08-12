package linkedList.rotateList;

import tree.node.ListNode;

public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode t = head;
		int size = 1;
		while (t.next != null) {
			size++;
			t = t.next;
		}
		k %= size;
		if (k == 0) {
			return head;
		}
		ListNode t1 = head;
		ListNode t2;
		for (int j = 0; j < size - k - 1; j++) {
			t1 = t1.next;
		}
		t2 = t1.next;
		t1.next = null;
		t1 = t2;
		while (t1.next != null) {
			t1 = t1.next;
		}
		t1.next = head;
		return t2;
	}
}
