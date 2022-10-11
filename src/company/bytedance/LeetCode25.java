package company.bytedance;

/**
 * @program: Algorithm
 * @description: K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 进阶：
 *
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * @author: he-zx
 * @create: 2022-04-11 00:16
 **/
public class LeetCode25 {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode cur = head;
		ListNode prev = null;
		ListNode next = null;
		ListNode check = head;
		int r = 0;
		int count = 0;
		//检查长度是否足够进行翻转
		while (r < k && check != null) {
			check = check.next;
			r ++;
		}
		
		if (r == k) { //进行翻转
			while (count < k && cur != null) {
				next = cur.next;
				cur.next = prev;
				prev = cur;
				cur = next;
				count ++;
			}
			if (next != null) {
				head.next = reverseKGroup(next, k);
			}
			return prev;
		} else { //不进行翻转
			return head;
		}
	}
}
