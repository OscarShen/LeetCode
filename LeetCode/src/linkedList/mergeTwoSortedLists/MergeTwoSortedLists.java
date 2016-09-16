package linkedList.mergeTwoSortedLists;

import utils.ListNode;

public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode fakeHead = new ListNode(Integer.MIN_VALUE);
		ListNode cur = fakeHead;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				cur.next = l1;
				cur = cur.next;
			} else {
				cur.next = l2;
				cur = cur.next;
			}
		}

		if (l1 != null)
			cur.next = l1;
		if (l2 != null)
			cur.next = l2;
		return fakeHead.next;
	}
}
