package org.kishan.year_2021.month_august.date_30;

import org.kishan.utils.Node;

/**
 *  Time : O(n)
 *  Space : O(1)
 */
public class ReverseNodeInKGroup {

	static Node reverseKGroup(Node head,int k){
		Node sHead = new Node(), sTail = sHead;
		Node n1 = head,n2 = head;
		int count = 0;

		while(n2 != null){
			Node next = n2.getNext();
			count++;

			if(count == k){
				n2.setNext(null);
				Node[] reverse = reversed(n1);
				sTail.setNext(reverse[0]);
				sTail = reverse[1];
				n1 = next;
				count = 0;
			}
			else if( next == null){
				sTail.setNext(n1);
			}

			n2 = next;
		}
		return sHead.getNext();
	}
	private static Node[] reversed(Node n1) {
		Node rHead = null,rTail = null;
		while(n1 != null){
			Node next = n1.getNext();
			n1.setNext(rHead);
			rHead = n1;
			n1 = next;
			if(rTail == null) rTail = rHead;
		}
		return new Node[] {rHead,rTail};
	}
	public static void main(String[] args) {
		Node head = new Node(1,new Node(2,new Node(3,new Node(4,new Node(5)))));
		head.print();
		System.out.println();
		Node node = reverseKGroup(head, 3);
		node.print();
	}
}
