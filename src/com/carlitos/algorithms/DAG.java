import java.io.FileNotFoundException;

public class DAG extends Graph {

	public int topoOrder[];
	public int distance[];
	private int inDegree[];

	public DAG(String filePath) throws FileNotFoundException {
		readWeightedGraph(filePath);
		topoOrder = new int[numVertices];
		distance = new int[numVertices];
		inDegree = new int[numVertices];
	}

	public void longestPaths(int s) throws Exception {
		// use a loop to initialize all cells of inDegree[] to 0
		for(int cells = 0; cells < numVertices; cells++) {
			inDegree[cells] = 0;
		}
		// use a loop to initialize all cells of distance[] to -inf
		for(int cellJ = 0; cellJ < numVertices; cellJ++) {
			distance[cellJ] = Integer.MIN_VALUE;
		}
		// for (i = 0 to i < numVertices) do the following:
		for(int i = 0; i < numVertices; i++) {
			// for(j = 0 to j < outDegree[i]) do the following:
			for(int j = 0; j < outDegree[i]; j++) {
				// Let adjEdge be the jth outgoing edge of i. See BFS pseudo-code for syntax.
				Edge adjEdge = adjList.get(i).get(j);
				// increment inDegree[adjEdge's destination] by 1
				inDegree[adjEdge.dest]++;
			}
		}
		// Create a Queue vertexQ of size numVertices
		Queue vertexQ = new Queue(numVertices);
		// for(i = 0 to i < numVertices), do the following:
		for(int i = 0; i < numVertices; i++) {
			// if(inDegree[i] equals 0), enqueue i into the vertexQ
			if(inDegree[i] == 0)
				vertexQ.enqueue(i);
		}
		// Set distance s equal to 0
		distance[s] = 0;
		// initialize an integer variable topoLevel = 0
		int topoLevel = 0;
		// while(vertexQ's size > 0), do the following:
		while(vertexQ.size() > 0){
			// let v be the vertex obtained by dequeueing vertexQ
			int v = vertexQ.dequeue();
			// assign topoOrder[topoLevel] = v
			topoOrder[topoLevel] = v;
			// increment topoLevel by 1
			topoLevel++;
			// for (j = 0 to j < outDegree[v]), do the following:
			for(int j = 0; j < outDegree[v]; j++){
			// 	let adjEdge be the jth outgoing edge of the vertex v
				Edge adjEdge = adjList.get(v).get(j);
			// 	let adjVertex be the destination of adjEdge
				int adjVertex = adjEdge.dest;
			// 	decrement inDegree[adjVertex] by 1
				inDegree[adjVertex]--;
			// 	if (inDegree[adjVertex] equals 0), then enqueue adjVertex to vertexQ
				if(inDegree[adjVertex] == 0){
					vertexQ.enqueue(adjVertex);
				}
			// 	if (distance[v] != −∞), do the following:
				if(distance[v] != Integer.MIN_VALUE){
			// 		let len = distance[v]+ weight of adjEdge
					int len = distance[v] + adjEdge.weight;
			// 		if (len > distance[adjVertex]), set distance[adjVertex] = len
					if(len > distance[adjVertex]){
						distance[adjVertex] = len;
					}						
				}
			}
		}
	}
}
