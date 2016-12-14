

struct ListNode
{
	int val;
	ListNode *next;
	ListNode(int x) :val(x), next(nullptr) {}
};


ListNode* reverseList(ListNode *head)
{
	if (head == nullptr || head->next == nullptr)
		return head;
	ListNode *cur1 = head;
	ListNode *cur2 = head->next;
	ListNode *cur3 = head->next->next;
	cur1->next = nullptr;
	while (cur2 != nullptr)
	{
		cur3 = cur2->next;

		cur2->next = cur1;
		cur1 = cur2;
		cur2 = cur3;
	}
	return cur1;
}