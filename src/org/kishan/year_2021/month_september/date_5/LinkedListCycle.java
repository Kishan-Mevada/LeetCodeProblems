package org.kishan.year_2021.month_september.date_5;

import org.kishan.utils.Node;

/**
 * 	-- Time : O(n)
 * 	-- Space : O(1)
 */
public class LinkedListCycle {

	static boolean hasCycle(Node head){
		Node slow = head,fast = head;

		while(fast != null && fast.getNext() != null){
			slow = slow.getNext();
			fast = fast.getNext().getNext();

			if(slow == fast) return true;
		}

		return false;
	}
	public static void main(String[] args) {
		Node n1 = new Node(3);
		Node n2 = new Node(3);
		Node n3 = new Node(3);
		Node n4 = new Node(3);

		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n2);
		System.out.println("LinkedList has Cycle -> " + hasCycle(n1));
	}
}
