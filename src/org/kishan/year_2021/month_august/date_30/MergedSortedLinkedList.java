package org.kishan.year_2021.month_august.date_30;

import org.kishan.utils.Node;

import java.util.LinkedList;

/**
 * 	Solution Algorithm
 *
 * 	- Create Head and Tail
 * 	- while l1 != null or l2 != null
 * 		if l2 == null or (l1 != null && l1.val < l2.val
 * 			tail.next = l1
 * 			tail = l1
 * 			l1 = l1.next
 * 		else
 * 			tail.next = l2
 * 			tail = l2
 * 			l2 = l2.next
 *
 * Time = O(m + n)
 * Space = O(1)
 */

public class MergedSortedLinkedList {
	static Node merge(Node l1,Node l2){
		Node tail = new Node();
		Node head = tail;

		while(l1 != null || l2 != null){
			if(l2 == null || (l1 != null && l1.getValue() < l2.getValue())){
				tail.setNext(l1);
				tail = l1;
				l1 = l1.getNext();
			}
			else{
				tail.setNext(l2);
				tail = l2;
				l2 = l2.getNext();
			}
		}
		return head.getNext();
	}

	public static void main(String[] args){
		Node l1 = new Node(1,new Node(2,new Node(6,null)));
		Node l2 = new Node(3,new Node(5,new Node(7,null)));
		Node merge = merge(l1, l2);
		merge.print();
	}
}
