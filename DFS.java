public class DFS extends Graph {

	public int level[];
	private boolean closed[];

	public DFS(String filePath) throws Exception {
		readUnweightedGraph(filePath);
		level = new int[numVertices];
		closed = new boolean[numVertices];
	}

	// this is the main DFS function
	public void executeDFS(int s) {
		// use a loop to initialize each cell of closed[] to false
		for(int i = 0; i < closed.length; i++) {
			closed[i] = false;
		} 
		// use a loop to initialize each cell of level[] to infinity
		for(int j = 0; j < Integer.MAX_VALUE; j++) {
			int level[] = new int[j];
		}
		// call DFS Helper method with s as an argument
		helpDFS(s);
	}

	// This is a recursive helper method
	private void helpDFS(int v) {
		// set closed[v] to true
		closed[v] = true;
		// for each adjacent vertex w of v, do the following
		for(int i = 0; i < outDegree[v]; i++) {
			Edge adjEdge = adjList.get(v).get(i);
			int w = adjEdge.dest;
			// if w is not closed, do the following:
			if(!(closed[w])) {
				// set level[w] = level[v] + 1
				level[w] = level[v] + 1;
				helpDFS(w);
			}
		}
	}
}