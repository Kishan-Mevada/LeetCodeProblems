package org.kishan.year_2021.month_september.date_3;

import org.kishan.utils.Node;

/**
 * Remove all duplicates from linked list and each element must be unique
 * input [1,2,3,3,4,4,5]
 * output [1,2,3,4,5]
 * -- Time : O(n)
 * -- Space : O(1)
 */
public class RemoveDuplicateFromLinkedList1 {
	static Node removeDuplicates(Node node) {
		Node sHead = new Node(), sTail = sHead;
		while(node != null) {
			while(node.getNext() != null && node.getValue() == node.getNext().getValue()) {
				node = node.getNext();
			}
			Node temp = node.getNext();
			node.setNext(null);
			sTail.setNext(node);
			sTail = node;
			node = temp;
		}
		return sHead.getNext();
	}
	public static void main(String[] args) {
		Node node = new Node(1, new Node(2, new Node(3, new Node(3, new Node(4, new Node(4, new Node(5)))))));
		node = removeDuplicates(node);
		node.print();
	}
}
