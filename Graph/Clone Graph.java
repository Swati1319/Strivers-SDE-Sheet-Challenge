import java.util.HashMap;

public class Solution {
	public static graphNode cloneGraphHelper(graphNode node, HashMap<graphNode, graphNode> copies) {
		
		// If the current node is NULL.
		if (node == null) {
			return null;
		}

		// If HashMap doesn't contain the node.
		if (copies.containsKey(node) == false) {
			graphNode copy = new graphNode(node.data);

			// Update the HashMap.
			copies.put(node, copy);

			// Go through all the neighbors.
			for (graphNode neighbour : node.neighbours) {
				graphNode temp = copies.get(node);
				temp.neighbours.add(cloneGraphHelper(neighbour, copies));
				copies.put(node, temp);
			}
		}

		return copies.get(node);
	}

	public static graphNode cloneGraph(graphNode node) {
		
		// Create a HashMap.
		HashMap<graphNode, graphNode> copies = new HashMap<>();

		// Return the source node of cloned graph.
		return cloneGraphHelper(node, copies);
	}
}
