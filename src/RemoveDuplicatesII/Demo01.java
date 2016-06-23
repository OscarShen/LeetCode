package removeDuplicatesII;
/**
 * ��ָ���쳣
 * @author Administrator
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(1);
		ListNode n3=new ListNode(2);
		ListNode n4=new ListNode(2);
		ListNode n5=new ListNode(2);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		ListNode newHead = Demo02.deleteDuplicates(n1);
		ListNode temp=newHead;
		while(temp!=null){
			System.out.println(temp.val);
			temp=temp.next;
		}
		
	}

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode fakeHead = new ListNode(-1);
		
		fakeHead.next = head;
		
		ListNode pr1 = fakeHead;
		ListNode pr2 = fakeHead.next;
		while(pr2!=null&&pr2.next!=null){
			pr1.next=single(pr2);
			pr1=pr1.next;
			if(pr1!=null){
				pr2=pr1.next;
			}
		}
		return fakeHead.next;
	}
	
	public static ListNode single(ListNode pr){
		
			boolean i=true;
			while(pr.next.val==pr.val){
					pr.next=pr.next.next;
					i=false;
					if(pr.next==null){
						return null;
					}
			};
			if(i){
				return pr;
			}
			if(pr.next!=null&&pr!=null){
				pr=pr.next;
				ListNode temp = single(pr);
				return temp;
			}
		return pr;
	}

}
