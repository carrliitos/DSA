import java.io.FileNotFoundException;

public class Dijkstra extends Graph {

	public int distance[], parent[];
	private boolean closed[];

	public Dijkstra(String filePath) throws FileNotFoundException {
		readWeightedGraph(filePath);
		distance = new int[numVertices];
		parent = new int[numVertices];
		closed = new boolean[numVertices];
	}

	public void executeDijkstra(int source) { 
		for(int i = 0; i < numVertices; i++) {
			distance[i] = Integer.MAX_VALUE;
			parent[i] = -1;
			closed[i] = false;
		}

		distance[source] = 0;
		int numOpen = 1;

		while(numOpen > 0) {
			int minDist = Integer.MAX_VALUE;
			int minVertex = -1;
			for(int i = 0; i < numVertices; i++) {
				if((closed[i] == false) && (distance[i] < minDist)){
					minDist = distance[i];
					minVertex = i;
				}
			}

			closed[minVertex] = true;
			numOpen--;

			for(int i = 0; i < outDegree[minVertex]; i++) {
				Edge adjEdge = adjList.get(minVertex).get(i);
				int adjVertex = adjEdge.dest;
				if(!(closed[adjVertex])){
					int newDist = distance[minVertex] + adjEdge.weight;
					if(distance[adjVertex] == Integer.MAX_VALUE){
						numOpen++;
					}
					if(newDist < distance[adjVertex]){
						distance[adjVertex] = newDist;
						parent[adjVertex] = minVertex;
					}
				}
			}
		}
	}
}