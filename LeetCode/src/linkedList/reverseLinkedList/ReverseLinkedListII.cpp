

struct ListNode
{
	int val;
	ListNode *next;
	ListNode(int x) :val(x), next(nullptr) {}
};

ListNode* reverseList(ListNode *head,ListNode *after_tail)
{
	ListNode *cur1 = head;
	ListNode *cur2 = head->next;
	ListNode *cur3 = head->next->next;
	cur1->next = after_tail;
	while (cur2 != after_tail)
	{
		cur3 = cur2->next;

		cur2->next = cur1;
		cur1 = cur2;
		cur2 = cur3;
	}
	return cur1;
}

ListNode* reverseBetween(ListNode* head, int m, int n) {
	if (m == n)
		return head;
	ListNode *first = head, *pre_first = nullptr;
	int i = 1;
	for (; i < m; ++i) {
		pre_first = first;
		first = first->next;
	}
	ListNode *second = first;
	for (; i < n; ++i) {
		second = second->next;
	}
	auto temp = reverseList(first, second->next);
	if (pre_first != nullptr) {
		pre_first->next = temp;
		return head;
	}
	return temp;
}
