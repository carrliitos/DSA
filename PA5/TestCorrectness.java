import java.util.Arrays;

public class TestCorrectness {
	static final String UNWEIGHTED_GRAPH1_PATH = "unweighted1.txt";
	static final String UNWEIGHTED_GRAPH2_PATH = "unweighted2.txt";
	static final String DAG1_PATH = "dag1.txt";
	static final String DAG2_PATH = "dag2.txt";
	static final String MUTANT1_PATH = "mutant1.txt";
	static final String MUTANT2_PATH = "mutant2.txt";
	static final String MUTANT3_PATH = "mutant3.txt";

	private static void testBFS() throws Exception {
		String filePaths[] = {UNWEIGHTED_GRAPH1_PATH, UNWEIGHTED_GRAPH2_PATH};
		for (int i = 0; i < filePaths.length; i++) {
			System.out.printf("*** Test BFS on UnweightedGraph %d ***\n\n", i + 1);
			BFS bfs = new BFS(filePaths[i]);
			for (int j = 0; j < bfs.numVertices; j++) {
				bfs.executeBFS(j);
				System.out.println("Level array (from v" + j + "):   "
						+ Arrays.toString(bfs.level).replaceAll("" + Integer.MAX_VALUE, "infty"));
			}
			System.out.println();
		}
	}

	private static void testDFS() throws Exception {
		String filePaths[] = {UNWEIGHTED_GRAPH1_PATH, UNWEIGHTED_GRAPH2_PATH};
		for (int i = 0; i < filePaths.length; i++) {
			System.out.printf("*** Test DFS on UnweightedGraph %d ***\n\n", i + 1);
			DFS dfs = new DFS(filePaths[i]);
			for (int j = 0; j < dfs.numVertices; j++) {
				dfs.executeDFS(j);
				System.out.println("Level array (from v" + j + "):   "
						+ Arrays.toString(dfs.level).replaceAll("" + Integer.MAX_VALUE, "infty"));
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws Exception {
		testBFS();
		testDFS();
	}
}