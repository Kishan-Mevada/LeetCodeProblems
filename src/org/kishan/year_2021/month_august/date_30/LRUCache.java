package org.kishan.year_2021.month_august.date_30;

import java.util.HashMap;
import java.util.Map;

// Time : O(1)
public class LRUCache {
	private Map<Integer, DoublyNode> map;
	private DoublyLinkedList nodes;
	private int capacity;
	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<>();
		this.nodes = new DoublyLinkedList();
	}

	public int get(int key){
		if (!map.containsKey(key)) return -1;
		DoublyNode node = map.get(key);
		nodes.remove(node);
		nodes.addFirst(node);
		return node.value;
	}

	public void put(int key,int value){
		if(!map.containsKey(key)){
			DoublyNode node = new DoublyNode(key, value);
			map.put(key,node);
			nodes.addFirst(node);

			if(map.size() > capacity){
				DoublyNode lastNode = nodes.removeLast();
				map.remove(lastNode.key);
			}
		}
		else{
			DoublyNode node = map.get(key);
			nodes.remove(node);
			nodes.addFirst(node);
			node.value = value;
		}
	}

	private class DoublyNode{
		public int key,value;
		public DoublyNode next = null,prev = null;
		public DoublyNode(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	private class DoublyLinkedList{
		private DoublyNode head,tail;
		public DoublyLinkedList() {
			this.head = new DoublyNode(0,0);
			this.tail = new DoublyNode(0,0);
			this.head.next = this.tail;
			this.tail.prev = this.head;
		}

		public void addFirst(DoublyNode node){
			node.prev = head;
			node.next = head.next;
			head.next.prev = node;
			head.next = node;
		}

		public DoublyNode remove(DoublyNode node){
			node.prev.next = node.next;
			node.next.prev = node.prev;
			node.next = null;
			node.prev = null;
			return node;
		}

		public DoublyNode removeLast(){
			return remove(tail.prev);
		}
	}
	public static void main(String[] args) {
		LRUCache lru = new LRUCache(2);

		lru.put(1,2);
		lru.put(2,3);
		System.out.println(lru.get(2));
		lru.put(3,4);
		System.out.println(lru.get(1));
	}
}
