package stack;

class Stack<Item> {

	private Node first;

	private class Node {
		private Item value;
		private Node next;

		Node(Item value) {
			this.value = value;
		}
	}

	public void push(Item value) {
		Node node = new Node(value);
		if (first != null) {
			node.next = first;
		}
		first = node;
	}

	public Node pop() {
		if (first == null) {
			return null;
		}
		Node temp = first;
		first = first.next;
		return temp;
	}

	public void printStack() {
		Node temp = first;
		System.out.println("\n");
		while (temp != null) {
			System.out.print(" --> " + temp.value);
			temp = temp.next;
		}
	}
}

public class LinkedListImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);

		stack.printStack();
		stack.pop();
		stack.printStack();
	}

}
