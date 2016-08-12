package linkedList.insertionSortList;

import utils.ListNode;

public class InsertionSortList {
	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		ListNode head2 = new ListNode(2);
		ListNode head3 = new ListNode(4);
		head.next = head2;
		head2.next = head3;

		ListNode sortList = new InsertionSortList().insertionSortList(head);
		while (sortList != null) {
			System.out.println(sortList.val);
			sortList = sortList.next;
		}
	}

	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode fakeHead = new ListNode(Integer.MIN_VALUE);
		fakeHead.next = head;// head不仅代表fakeHead的下一个节点，还用来表示扫描排序链表的指针
		ListNode cur = head.next;// 用来存储将要还未被排序的链表
		head.next = null;
		ListNode pre;// 用来存储扫描中的head节点的前一个节点

		ListNode temp;// 用来存储当前需要插入的节点

		while (cur != null) {
			temp = cur;
			head = fakeHead.next;
			pre = fakeHead;
			while (true) {
				if (temp.val <= head.val) {// 已经找到需要插入的位置
					pre.next = temp;
					temp.next = head;
					break;
				} else {// 不是当前需要插入的位置，继续往后遍历
					pre = pre.next;
					head = head.next;
				}
				if (head == null) {// 查询到最后一个，于是将temp插到最后。
					pre.next = temp;
					temp.next = null;
					break;
				}
			}
			cur = cur.next;
		}

		return fakeHead.next;
	}
}
