package linkedList.removeDuplicatesFromSortedList;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode cur1 = new ListNode(Integer.MAX_VALUE);
		ListNode cur2 = head;
		Set<Integer> set = new HashSet<>();

		while (cur2 != null) {
			if (set.contains(cur2.val)) {
				cur2 = cur2.next;
			} else {
				set.add(cur2.val);
				cur1.next = cur2;
				cur1 = cur2;
				cur2 = cur2.next;
			}
		}
		cur1.next = null;

		return head;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}