package linkedList.removeDuplicatesII;

public class Demo02 {
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;

		ListNode pr0 = fakeHead;
		ListNode pr1 = head;
		ListNode pr2 = head.next;
		boolean flag = false;
		while (pr2 != null) {
			if (pr1.val == pr2.val) {
				pr2 = pr2.next;
				flag = true;
				if (pr2 == null) {
					pr0.next = null;
				}
			} else {
				if (flag) {
					pr0.next = pr2;
					flag = false;
					pr1 = pr2;
					pr2 = pr2.next;
				} else {
					pr0 = pr1;
					pr1 = pr2;
					pr2 = pr2.next;
				}
			}
		}
//		if (flag) {
//			pr0.next = pr2;
//		}
		return fakeHead.next;
	}
}
