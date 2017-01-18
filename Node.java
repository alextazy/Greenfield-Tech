import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node {

    private String name;
    private LinkedList<Node> shortestPath = new LinkedList<>();
    private Integer distance = Integer.MAX_VALUE;
    private Map<Node, Integer> adjacentNodes = new HashMap<>();
    private int sumOfTerminationNodes = 0;

    public Node(String name) {
        this.name = name;
    }

    public void addDestination(Node destination, int distance) {
        adjacentNodes.put(destination, distance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    public int getSumOfTerminationNodes() {
		return sumOfTerminationNodes;
	}

	public void setSumOfTerminationNodes(int sumOfTerminationNodes) {
		this.sumOfTerminationNodes = sumOfTerminationNodes;
	}

	public Integer getDistance() {
    	return distance;
    }
    
    public Integer getFinalDistance() {
    	
    	if (distance == Integer.MAX_VALUE)
    		return -1;
    	
    	return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public List<Node> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(LinkedList<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }
     
    public boolean iSterminationNode() {
    	return (adjacentNodes.size() == 0);
    }

}