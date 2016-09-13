package linkedList.removeNthNodeFromEndOfList;

import java.util.Stack;

import utils.ListNode;

public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || head.next == null)
			return null;
		Stack<ListNode> stack = new Stack<>();
		ListNode cur = head;
		while (cur != null) {
			stack.push(cur);
			cur = cur.next;
		}

		if (n == 1) {
			stack.pop();
			stack.peek().next = null;
			return head;
		}

		for (int i = 1; i < n - 1; i++) {
			stack.pop();
		}
		ListNode temp = stack.pop();
		stack.pop();
		if (!stack.isEmpty())
			stack.peek().next = temp;
		else
			return temp;
		return head;
	}
}
