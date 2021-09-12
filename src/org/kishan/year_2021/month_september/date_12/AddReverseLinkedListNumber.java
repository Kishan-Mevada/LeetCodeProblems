package org.kishan.year_2021.month_september.date_12;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example
 * 	Input: l1 = [3,4,2], l2 = [4,6,5]
 *  Output: [8,0,7]
 *  Explanation: 342 + 465 = 807.
 */
public class AddReverseLinkedListNumber {

	static Node head = null;

	static class Node{
		int val;
		Node next;
		public Node(int val) {
			this.val = val;
		}
		public Node(int val, Node next) {
			this.val = val;
			this.next = next;
		}
		public Node() {
		}
		@Override
		public String toString() {
			return "[" +convertToString() + "]";
		}
		String convertToString(){
			StringBuilder output = new StringBuilder();
			Node temp = this;
			while(temp != null){
				output.append(temp.val);
				temp = temp.next;
				if(temp != null){
					output.append(",");
				}
			}
			return output.toString();
		}
	}

	static Node addLLNumber(Node l1,Node l2){
	 	 l1 = reverseLL(l1);
		 l2 = reverseLL(l2);

		 Node head = null;
		 int carry = 0;

		 while(l1 != null || l2 != null){
			 int n1 = l1 != null ? l1.val: 0;
			 int n2 = l2 != null ? l2.val: 0;

			 int sum = n1 + n2 + carry;
			 Node node = new Node(sum % 10);
			 node.next = head;
			 head = node;
			 carry = sum / 10;

			 if(l1 != null) l1 = l1.next;
			 if(l2 != null) l2 = l2.next;
		 }
		 if(carry > 0){
			 Node node = new Node(carry);
			 node.next = head;
			 head = node;
		}
		 return head;
	}
	private static Node reverseLL(Node node) {
	 	Node head = null;
		while(node != null){
			Node next = node.next;
			node.next = head;
			head = node;
			node = next;
		}
		return head;
	}

	static Node addLLNumberConstSpace(Node l1,Node l2){
		head = null;
		int carry = addRecursive(l1,l2);
		if(carry > 0) appendNode(carry);
		return head;
	}
	private static int addRecursive(Node l1, Node l2) {
		if(l1 == null && l2 == null) return 0;
		int n1 = l1 != null ? l1.val : 0;
		int n2 = l2 != null ? l2.val : 0;

		if(l1 != null) l1 = l1.next;
		if(l2 != null) l2 = l2.next;
		int sum = n1 + n2 + addRecursive(l1,l2);
		appendNode(sum % 10);
		return sum / 10;
	}

	private static void appendNode(int val){
		 Node node = new Node(val);
		 node.next = head;
		 head = node;
	}

	public static void main(String[] args) {
		//case 1
		Node l1 = new Node(3,new Node(4,new Node(2)));
		Node l2 = new Node(4,new Node(6,new Node(5)));
		System.out.println("Case 1 -> " + l1 + " + " + l2 + " = "  + addLLNumber(l1,l2));
		//System.out.println("Case 1 (Recursive)-> " + l1 + " + " + l2 + " = "  + addLLNumberConstSpace(l1,l2));
		System.out.println("=================");
		//case 2
		l1 = new Node(2,new Node(6,new Node(3,new Node(4))));
		l2 = new Node(5,new Node(6,new Node(4)));
		//System.out.println("Case 2 -> " + l1 + " + " + l2 + " = "  + addLLNumber(l1,l2));
		System.out.println("Case 2 (Recursive)-> " + l1 + " + " + l2 + " = "  + addLLNumberConstSpace(l1,l2));
		System.out.println("=================");
		//case 3
		l1 = new Node(0);
		l2 = new Node(0);
		//System.out.println("Case 3 -> " + l1 + " + " + l2 + " = "  + addLLNumber(l1,l2));
		System.out.println("Case 3 (Recursive)-> " + l1 + " + " + l2 + " = "  + addLLNumberConstSpace(l1,l2));
		System.out.println("=================");
		//case 4
		l1 = new Node(9);
		l2 = new Node(1);
		//System.out.println("Case 4 -> " + l1 + " + " + l2 + " = "  + addLLNumber(l1,l2));
		System.out.println("Case 4 (Recursive)-> " + l1 + " + " + l2 + " = "  + addLLNumberConstSpace(l1,l2));
		System.out.println("=================");
	}

}

