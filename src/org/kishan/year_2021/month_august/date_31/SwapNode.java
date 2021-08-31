package org.kishan.year_2021.month_august.date_31;

import org.kishan.utils.Node;

/**
 *  Time : O(n)
 *  space : O(1)
 */
public class SwapNode {

	public static Node swapPair(Node head){
		 Node sHead = new Node();
		 Node sTail = sHead;
		 Node node = head;

		 while(node != null){
			 Node next = null;
			 if(node.getNext() != null){
				 next = node.getNext().getNext();
			 }
			 if(node.getNext() == null){
				 sTail.setNext(node);
				 sTail = node;
			 }
			 else{
				 node.getNext().setNext(null);
				 sTail.setNext(node.getNext());
				 sTail = node.getNext();
				 node.setNext(null);
				 sTail.setNext(node);
				 sTail = node;
			 }
			 node = next;
		 }
		 return sHead.getNext();
	}
	public static void main(String[] args) {
		Node head = new Node(1,new Node(2,new Node(3,new Node(4))));
		head.print();
		System.out.println();
		Node node = swapPair(head);
		node.print();
	}
}
