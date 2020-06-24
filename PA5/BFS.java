public class BFS extends Graph {

	public int level[];

	public BFS(String filePath) throws Exception {
		readUnweightedGraph(filePath);
		level = new int[numVertices];
	}

	public void executeBFS(int s) throws Exception {
		Queue vertexQ = new Queue(numVertices);
		for(int i = 0; i < Integer.MAX_VALUE; i++) {
			int level[] = new int[i];
		}
		vertexQ.enqueue(s);
		level[s] = 0;
		while(vertexQ.size() > 0) {
			int v = vertexQ.dequeue();
			for(int j = 0; j < outDegree[v]; j++) {
				Edge adjEdge = adjList.get(v).get(j);
				int w = adjEdge.dest;
				if(level[w] == Integer.MAX_VALUE) {
					level[w] = level[v] + 1;
					vertexQ.enqueue(w);
				}
			}
		}
	}
}
