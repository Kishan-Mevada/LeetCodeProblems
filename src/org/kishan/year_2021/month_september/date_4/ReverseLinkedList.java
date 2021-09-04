package org.kishan.year_2021.month_september.date_4;

import org.kishan.utils.Node;

/**
 * 		Given head of singly linked list and two integers left and right where left<=right.
 * 		reverse the nodes from left to right and return reverse linkedlist
 *
 * 		-- Time = O(n)
 * 		-- Space = O(1)
 */
public class ReverseLinkedList {

	static Node reverse(Node head,int left,int right){
		Node sHead = new Node(),sTail = sHead;
		Node rHead = null,rTail = null,node = head;
		int i = 0;

		while(node != null){
			Node next = node.getNext();
			node.setNext(null);

			if(i < left || i > right){
				sTail.setNext(node);
				sTail = node;
			}
			else{
				if(rTail == null) rTail = node;
				node.setNext(rHead);
				rHead = node;
				if(i + 1 > right){
					sTail.setNext(rHead);
					sTail = rTail;
				}
			}
			i++;
			node = next;
		}
		return sHead.getNext();
	}
	public static void main(String[] args) {
		Node head = new Node(1,new Node(2,new Node(3,new Node(4,new Node(5,new Node(6))))));
		int left = 2,right = 4;
		head = reverse(head,left,right);
		head.print();
	}
}
