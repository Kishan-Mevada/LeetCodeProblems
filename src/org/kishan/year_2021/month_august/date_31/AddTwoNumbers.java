package org.kishan.year_2021.month_august.date_31;

import org.kishan.utils.Node;

/**
 *  Given 2 non-empty linked lists representing two non-negative integers.
 *
 *  The digits stored in reverse order, and each of their nodes contains single digit.
 *
 *  Solution Algorithm
 *
 *  - create 2 pointers to keep result of sum
 *  	- head , to keep result of head
 *  	- tail , to keep result at tail, tail = head
 *	- create carry variable to keep carry of sum
 *  - while l1 or l2 is not null
 *  	- if l1 is null then 0 else l1.val to store in num1
 *  	- if l2 is null then 0 else l2.val to store in num2
 *  	- create sum = num1 + num2 + carry
 *  	- append sum % 10 to tail
 *  	- carry = sum > 9 ? 1 : 0
 *  	- if l1 not null then l1 = l1.next
 *  	- if l2 not null then l2 = l2.next
 *	- if carry is greater than 0
 *		- append 1 to tail
 */
public class AddTwoNumbers {

	static Node head = new Node();
	static Node tail = head;

	static Node addTwoNumbers(Node l1,Node l2){
		int carry = 0;
		while(l1 != null || l2 != null){
			int num1 = l1 == null ? 0 : l1.getValue();
			int num2 = l2 == null ? 0 : l2.getValue();
			int sum = num1 + num2 + carry;
			append(sum % 10);
			carry = sum > 9 ? 1 : 0;
			if (l1 != null) l1 = l1.getNext();
			if (l2 != null) l2 = l2.getNext();
		}
		if(carry > 0){
			append(1);
		}
		return head.getNext();
	}

	private static void append(int val){
		Node node = new Node(val);
		tail.setNext(node);
		tail = node;
	}
	public static void main(String[] args) {
		Node l1 = new Node(2,new Node(4,new Node(3)));
		Node l2 = new Node(5,new Node(6,new Node(4)));
		System.out.println("Sum of two linked list");
		Node sum = addTwoNumbers(l1, l2);
		sum.print();
	}
}
