package everyday;

/**
 * @program: Algorithm
 * @description: 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @author: he-zx
 * @create: 2022-04-05 16:26
 **/
public class LeetCode21 {
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode res = new ListNode(-1);
		ListNode dummyHead = res;
		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				res.next = list1;
				list1 = list1.next;
			} else {
				res.next = list2;
				list2 = list2.next;
			}
			res = res.next;
		}
		
		if (list1 != null) {
			res.next = list1;
		}
		if (list2 != null) {
			res.next = list2;
		}
		return dummyHead.next;
	}
}
