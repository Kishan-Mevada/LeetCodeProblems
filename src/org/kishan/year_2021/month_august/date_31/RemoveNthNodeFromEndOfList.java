package org.kishan.year_2021.month_august.date_31;

import org.kishan.utils.Node;

/**
 * 	Given the head of a linked list,remove the nth node from end of linkedlist
 *
 * 	Solution Algorithm
 *
 * 	- Create the variables
 * 		- sHead , sentinel head
 * 		- slow, initialize to sHead
 * 		- fast, initialize to sHead
 *
 * - set sHead.next = head
 *
 * 	- Iterate fast pointer from 0 to n
 * 		- set fast = fast.next
 *
 * 	- Iterate the fast pointer till not null
 * 		- set fast = fast.next
 * 		- set slow = slow.next
 *
 * 	- set slow.next = slow.next.next
 *
 * 	return sHead.next;
 *
 */
public class RemoveNthNodeFromEndOfList {

	static Node removeNthFromEnd(Node head,int n){
		Node sHead = new Node(), slow = sHead,fast = sHead;
		sHead.setNext(head);
		for(int i = 0; i <= n && fast != null; i++) {
			fast = fast.getNext();
		}

		if(fast == null){
			 throw new IndexOutOfBoundsException("Given index is out of bound [" + n + "]");
		}

		while(fast != null){
			fast = fast.getNext();
			slow = slow.getNext();
		}

		slow.setNext(slow.getNext().getNext());

		return sHead.getNext();
	}
	public static void main(String[] args) {
		Node head = new Node(1,new Node(2,new Node(3,new Node(4,new Node(5)))));
		int n = 4;
		head.print();
		System.out.println("\nRemove " + n + "node from end of list");
		Node node = removeNthFromEnd(head, n);
		node.print();
	}
}
