package org.kishan.year_2021.month_september.date_4;

import org.kishan.utils.Node;

/**
 * 		-- Time = O(n)
 * 		-- Space = O(1)
 */

public class ReverseLinkedList1 {

	static Node reverse(Node head){
		Node rHead = null,node = head;

		while(node != null){
			Node next = node.getNext();
			node.setNext(rHead);
			rHead = node;
			node = next;
		}
		return rHead;
	}

	public static void main(String[] args) {
		Node head = new Node(1,new Node(2,new Node(3,new Node(4,new Node(5,new Node(6))))));
		System.out.println("Before");
		head.print();
		System.out.println();
		head = reverse(head);
		System.out.println("After");
		head.print();
	}
}
