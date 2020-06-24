public class DFS extends Graph {

	public int level[];
	private boolean closed[];

	public DFS(String filePath) throws Exception {
		readUnweightedGraph(filePath);
		level = new int[numVertices];
		closed = new boolean[numVertices];
	}

	public void executeDFS(int s) {
		for(int i = 0; i < closed.length; i++) {
			closed[i] = false;
		} 

		for(int j = 0; j < Integer.MAX_VALUE; j++) {
			int level[] = new int[j];
		}

		helpDFS(s);
	}

	private void helpDFS(int v) {
		closed[v] = true;
		for(int i = 0; i < outDegree[v]; i++) {
			Edge adjEdge = adjList.get(v).get(i);
			int w = adjEdge.dest;
			if(!(closed[w])) {
				level[w] = level[v] + 1;
				helpDFS(w);
			}
		}
	}
}