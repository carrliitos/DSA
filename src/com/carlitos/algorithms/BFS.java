public class BFS extends Graph {

	public int level[];

	public BFS(String filePath) throws Exception {
		readUnweightedGraph(filePath);
		level = new int[numVertices];
	}

	public void executeBFS(int s) throws Exception {
		// Create a Queue vertexQ of size numVertices by calling 
		// the Queue constructor with numVertices as argument
		Queue vertexQ = new Queue(numVertices);
		// Use a loop to initialize all cells of level[] to infinity
		for(int i = 0; i < numVertices; i++) {
			level[i] = Integer.MAX_VALUE;
		}
		// Enqueue s to vertexQ
		vertexQ.enqueue(s);
		// Set level[s] = 0
		level[s] = 0;
		// start the while loop
		while(vertexQ.size() > 0) {
			// let v be the vertex obtained by dequeueing vetexQ
			int v = vertexQ.dequeue();
			// for( j = 0 to outDegree[v]), do the following
			for(int j = 0; j < outDegree[v]; j++) {
				// let adjEdge be the ith outgoing edge of v
				Edge adjEdge = adjList.get(v).get(j);
				// let w be the destination of adjEdge
				int w = adjEdge.dest;
				// if(level[w] eqauls infinity), then...
				if(level[w] == Integer.MAX_VALUE) {
					// set level[w] to level[v] + 1
					level[w] = level[v] + 1;
					// enqueue w to vertexQ
					vertexQ.enqueue(w);
				}
			}
		}
	}
}
