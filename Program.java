import java.io.IOException;
import java.util.Map.Entry;

public class Program {

	public static void main(String[] args) throws IOException{

		Graph graph = new Graph();

		Parser parser = new Parser("words.txt", ":", graph);

		parser.parse();

		//Enter here the search node
		String nodeName = "beginner";

		if (graph.getNodes().containsKey(nodeName)) {

			Node node = graph.getNodes().get(nodeName);

			if (node.iSterminationNode())
				System.out.println("The node is Termination Node! nothing to check");

			else {

				Dijkstra.calculateShortestPathFromSource(graph, node);

				calculateSumOfTerminationNodes(node, graph);

				printProbability(node, graph);	
			}
		}

		else 
			System.out.println("Error: No such node in the graph !");
	}

	private static void printProbability(Node node, Graph graph) {

		for (Entry<String, Node> adjacencyPair : graph.getNodes().entrySet()) {

			Node n = adjacencyPair.getValue();

			if (n.iSterminationNode() && n.getFinalDistance() != -1) {
				if (n.getShortestPath().size() > 0) {
					if (n.getShortestPath().get(0).equals(node)) {

						System.out.print("Probability of Node " + n.getName() + " is ");
						float p = ((float)n.getDistance() / node.getSumOfTerminationNodes());
						System.out.println(p * 100 + "%");
					}
				}
			}
		}
	}

	private static void calculateSumOfTerminationNodes(Node node, Graph graph) {

		for (Entry<String, Node> adjacencyPair : graph.getNodes().entrySet()) {

			Node n = adjacencyPair.getValue();

			if (n.iSterminationNode() && n.getFinalDistance() != -1)
				if (n.getShortestPath().size() > 0)
					if (n.getShortestPath().get(0).equals(node))
						node.setSumOfTerminationNodes(node.getSumOfTerminationNodes() + n.getFinalDistance());
		}
	}
}