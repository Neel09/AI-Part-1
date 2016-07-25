package dynamicconnectivity;

/**
 * Quick Find
 * @author ngupta
 *
 */
public class EagerApproach {

	private int[] nodes;

	public EagerApproach(int size) {
		nodes = new int[size];

		for (int i = 0; i < size; i++) {
			nodes[i] = i;
		}
	}

	public void union(int p, int q) {
		if(!isConnected(p,q)){
			int pValue = nodes[p];
			int qValue = nodes[q];

			for (int i = 0; i < nodes.length; i++) {
				if (nodes[i] == pValue) {
					nodes[i] = qValue;
				}
			}
		}
	}

	public boolean isConnected(int p, int q) {
		return nodes[p] == nodes[q];
	}
	
	public void printArray(){
		for(int i=0;i<nodes.length;i++){
			System.out.print(nodes[i] + " ");
		}
	}

	public static void main(String[] args) {
		EagerApproach ea = new EagerApproach(10);
		ea.union(4,3);
		ea.union(3,8);
		ea.union(6,5);
		ea.union(9,4);
		ea.union(2,1);
		ea.union(5,0);
		ea.union(7,2);
		//ea.union(6,1);
		
		ea.printArray();
		
		System.out.println("\nAre Nodes 1 and 7 connected? : " + ea.isConnected(1,7));
		System.out.println("Are Nodes 6 and 1 connected? : " + ea.isConnected(1,6));
	}

}
