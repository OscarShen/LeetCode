package linkedList.addTwoNumbers;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		boolean flag = false;// 记录是否需要进位
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode fakeHead = new ListNode(-1);
		ListNode cur = fakeHead;
		int count;
		ListNode temp;
		while (l1 != null && l2 != null) {
			count = l1.val + l2.val;
			if (count > 9) {
				temp = new ListNode(count - 10);
				flag = true;
			} else {
				temp = new ListNode(count);
				flag = false;
			}
			cur.next = temp;
			cur = cur.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		if(flag){
			
		}

		return fakeHead.next;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
