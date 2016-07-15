package removeDuplicatesFromSortedList;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedList {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(3);
		ListNode l5 = new ListNode(3);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		ListNode res = new RemoveDuplicatesFromSortedList().deleteDuplicates(l1);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

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