package company.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Algorithm
 * @description:146. LRU 缓存
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * @author: he-zx
 * @create: 2022-04-10 23:35
 **/
public class LRUCache {
	
	class DLinkedNode{
		int key;
		int value;
		DLinkedNode prev;
		DLinkedNode next;
		public DLinkedNode(){}
		public DLinkedNode(int key, int value){
			this.key = key;
			this.value = value;
		}
	}
	
	private Map<Integer, DLinkedNode> cache = new HashMap<>();
	private int size;
	private int capacity;
	private DLinkedNode head, tail;
	
	public LRUCache(int capacity) {
		this.size = 0;
		this.capacity = capacity;
		this.head = new DLinkedNode();
		this.tail = new DLinkedNode();
		head.next = tail;
		tail.prev = head;
	}
	
	public int get(int key) {
		DLinkedNode node = cache.get(key);
		if (node == null) {
			return -1;
		}
		//将节点移动至链表头
		moveToHead(node);
		return node.value;
	}
	
	private void moveToHead(DLinkedNode node) {
		removeNode(node);
		addToHead(node);
	}
	
	private void addToHead(DLinkedNode node) {
		node.prev = head;
		node.next = head.next;
		node.next.prev = node;
		head.next = node;
	}
	
	private void removeNode(DLinkedNode node) {
		node.next.prev = node.prev;
		node.prev.next = node.next;
	}
	
	public void put(int key, int value) {
		DLinkedNode node = cache.get(key);
		if (node == null) {
			//节点不存在
			DLinkedNode newNode = new DLinkedNode(key, value);
			addToHead(newNode);
			cache.put(key, newNode);
			size ++;
			//如果节点数量大于容量，将链表尾部的节点删除
			if (size > capacity) {
				DLinkedNode tail = removeTail();
				cache.remove(tail.key);
				size --;
			}
		} else {
			node.value = value;
			moveToHead(node);
		}
	}
	
	private DLinkedNode removeTail() {
		DLinkedNode node = tail.prev;
		removeNode(node);
		return node;
	}
	
	
}
