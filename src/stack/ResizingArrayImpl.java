package stack;

/*
 * Using Dynamic Resizing-Array Implementation 
 */
class OptimizedStack<Item> {

	private Item[] items;
	private int N; // no. Of Items

	OptimizedStack() {
		items = (Item[]) new Object[1];
	}

	private void resize(int newCapacity) {
		Item[] copy = (Item[]) new Object[newCapacity];

		for (int i = 0; i < N; i++) {
			copy[i] = items[i];
		}
		items = copy;
	}

	/*
	 * Doubling the size of items[] when it is full
	 */
	public void push(Item value) {
		if (N == items.length) {
			resize(2 * items.length);
		}
		items[N++] = value;
	}

	/*
	 * Halving the size of items[] when it is one-quarter full
	 */
	public Item pop() {
		if (N > 0 && N == items.length / 4) {
			resize(items.length / 2);
		}
		Item value = items[N - 1];
		items[--N] = null;
		return value;
	}

	public void printStack() {
		System.out.print("\n");
		for (int i = 0; i < items.length; i++) {
			System.out.print(" --> " + items[i]);
		}
	}
}

public class ResizingArrayImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OptimizedStack<Integer> stack = new OptimizedStack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		/*
		 * stack.push(1); stack.push(2); stack.push(3); stack.push(3);
		 */

		stack.printStack();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.printStack();
	}

}
