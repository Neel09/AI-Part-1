package dynamicconnectivity;

/**
 * Quick Union
 * 
 * @author ngupta
 *
 */

class Node {
	private int value;
	private Node parent;

	Node(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

}

public class LazyApproach {

	public static Node findRoot(Node node) {
		System.out.print("\nRoot of " + node.getValue() + " is : ");
		while (node!=null) {
			if (node.getParent() != null) {
				node = node.getParent();
				continue;
			}
			break;
		}
		System.out.print(node.getValue());
		return node;
	}

	public static void union(Node p, Node q) {
		Node pRoot = findRoot(p);
		Node qRoot = findRoot(q);
		pRoot.setParent(qRoot);
		
		/**
		 * comment above code and uncomment below line. This will slow findRoot()
		 * as it makes tree more deeper that affects findRoot to get slow but this will fast the union() operation
		 */
		// p.setParent(q); 
		
	}

	public static boolean isConnected(Node p, Node q) {
		return findRoot(p) == findRoot(q);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size = 10;
		Node[] nodes = new Node[size];
		for (int i = 0; i < size; i++) {
			nodes[i] = new Node(i);
		}

		union(nodes[4], nodes[3]);
		union(nodes[3], nodes[8]);
		union(nodes[6], nodes[5]);
		union(nodes[9], nodes[4]);
		union(nodes[2], nodes[1]);
		union(nodes[5], nodes[0]);
		union(nodes[7], nodes[2]);

		System.out.println("\nAre Nodes 1 and 7 connected? : "
				+ isConnected(nodes[1], nodes[7]));
		System.out.println("\nAre Nodes 6 and 1 connected? : "
				+ isConnected(nodes[1], nodes[6]));

		findRoot(nodes[6]);
		findRoot(nodes[5]);
		findRoot(nodes[0]);
		findRoot(nodes[9]);
		findRoot(nodes[4]);
		findRoot(nodes[3]);
		findRoot(nodes[8]);
		findRoot(nodes[7]);
		findRoot(nodes[2]);
		findRoot(nodes[1]);

	}

}
