import java.io.FileNotFoundException;

public class Dijkstra extends DijkstraGraph {

	public int distance[], parent[];
	private boolean closed[];

	public Dijkstra(String filePath) throws FileNotFoundException {
		readWeightedGraph(filePath);
		distance = new int[numVertices];
		parent = new int[numVertices];
		closed = new boolean[numVertices];
	}

	public void executeDijkstra(int source) { 
		// for (i = 0 to i < numVertices), do the following:
		for(int i = 0; i < numVertices; i++) {
			// set distance[i] = ∞ (INT MAX in C++ and Integer.MAX VALUE in Java)
			distance[i] = Integer.MAX_VALUE;
			// set parent[i] to −1
			parent[i] = -1;
			// set closed[i] to false
			closed[i] = false;
		}
		// Set distance[source] to 0
		distance[source] = 0;
		// Create an integer variable numOpen and set it to 1
		int numOpen = 1;
		// As long as (numOpen > 0), do the following:
		while(numOpen > 0) {
			// Initialize a variable minDist to ∞ and another variable minVertex to −1. These will be used to expand the open vertex with the minimum distance label.
			int minDist = Integer.MAX_VALUE;
			int minVertex = -1;
			// for (i = 0 to i < numVertices), do the following:
			for(int i = 0; i < numVertices; i++) {
				// if (closed[i] is false and distance[i] < minDist), then:
				if((closed[i] == false) && (distance[i] < minDist)){
					// set minDist to distance[i]
					minDist = distance[i];
					// set minVertex to i
					minVertex = i;
				}
			}
			// set closed[minVertex] to true
			closed[minVertex] = true;
			// decrement numOpen by one
			numOpen--;
			// for (i = 0 to i < outDegree[minVertex]), do the following:
			for(int i = 0; i < outDegree[minVertex]; i++) {
				// let adjEdge be ith adjacent edge of minVertex
				Edge adjEdge = adjList.get(minVertex).get(i);
				// let adjVertex be the destination of adjEdge
				int adjVertex = adjEdge.dest;
				// if (adjVertex is not closed), do the following:
				if(!(closed[adjVertex])){
					// set newDist to distance[minVertex] + adjEdge0s weight
					int newDist = distance[minVertex] + adjEdge.weight;
					// if distance[adjVertex] equals ∞, 
					if(distance[adjVertex] == Integer.MAX_VALUE){
						// then the vertex has not been visited; so, increment numOpen by 1
						numOpen++;
					}
					// if (newDist < distance[adjVertex]), then
					if(newDist < distance[adjVertex]){
						// set distance[adjVertex] to newDist
						distance[adjVertex] = newDist;
						// set parent[adjVertex] to minVertex
						parent[adjVertex] = minVertex;
					}
				}
			}
		}
	}
}