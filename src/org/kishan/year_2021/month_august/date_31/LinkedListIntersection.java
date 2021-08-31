package org.kishan.year_2021.month_august.date_31;

import org.kishan.utils.Node;

/**
 *  find the intersection of given 2 linked list
 *
 *  Solution Algorithm
 *
 *  - find the length of both linked list
 *  - determine the shorter and longer list using x and y
 *  - Move forward longer linked list by abs(x-y) steps
 *  - while shorter != null && shorter != longer
 *  	- set shorter = shorter.next
 *  	- set longer = longer.next
 *  - return shorter
 */
public class LinkedListIntersection {

	static Node getIntersectionNode(Node headA,Node headB){
		int x = getLength(headA), y = getLength(headB);
		Node shorter = (x < y) ? headA : headB;
		Node longer = (x < y) ? headB : headA;

		longer = moveForward(longer,Math.abs(x - y));

		while(shorter != null && shorter != longer){
			shorter = shorter.getNext();
			longer = longer.getNext();
		}
		return shorter;
	}
	private static Node moveForward(Node node, int steps) {
		while(steps-- > 0){
			node = node.getNext();
		}
		return node;
	}
	private static int getLength(Node head) {
		int length = 0;
		for(Node node = head; node != null; node= node.getNext()){
			length++;
		}
		return length;
	}
	public static void main(String[] args) {
		Node intersectionNode = new Node(8, new Node(4, new Node(5)));
		Node ll1 = new Node(4,new Node(1, intersectionNode));
		Node ll2 = new Node(5,new Node(6,new Node(1, intersectionNode)));
		System.out.println("Intersection is " + getIntersectionNode(ll1,ll2));
	}
}
