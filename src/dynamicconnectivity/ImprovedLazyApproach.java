package dynamicconnectivity;

/*
 * Weighted Tree - to reduce depth of the tree and make it broader
 */
class ImprovedNode extends Node {

	private int childrenCount;
	private ImprovedNode parent;

	ImprovedNode(int value) {
		super(value);
	}

	public ImprovedNode getParent() {
		return parent;
	}

	public void setParent(ImprovedNode parent) {
		this.parent = parent;
	}

	public int getChildrenCount() {
		return childrenCount;
	}

	public void setChildrenCount(int childrenCount) {
		this.childrenCount = childrenCount;
	}

}

public class ImprovedLazyApproach {

	private static ImprovedNode findRoot(ImprovedNode node) {
		System.out.print("\nRoot of " + node.getValue() + " is : ");
		while (node != null) {
			if (node.getParent() != null) {
				node = node.getParent();
				continue;
			}
			break;
		}
		System.out.print(node.getValue());
		return node;
	}

	public static void union(ImprovedNode p, ImprovedNode q) {
		ImprovedNode pRoot = findRoot(p);
		ImprovedNode qRoot = findRoot(q);

		if (pRoot.getChildrenCount() < qRoot.getChildrenCount()) {
			pRoot.setParent(qRoot);
			qRoot.setChildrenCount(qRoot.getChildrenCount()
					+ pRoot.getChildrenCount());
		} else {
			qRoot.setParent(pRoot);
			pRoot.setChildrenCount(pRoot.getChildrenCount()
					+ qRoot.getChildrenCount());
		}
	}

	public static boolean isConnected(ImprovedNode p, ImprovedNode q) {
		return findRoot(p) == findRoot(q);
	}

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		int size = 10;
		ImprovedNode[] nodes = new ImprovedNode[size];
		for (int i = 0; i < size; i++) {
			nodes[i] = new ImprovedNode(i);
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
