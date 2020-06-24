import java.util.Arrays;

public class PA5TestCorrectness {
	static final String UNWEIGHTED_GRAPH1_PATH = "/home/carlitos/Documents/School/git/CS223/txtFiles/unweighted1.txt";
	static final String UNWEIGHTED_GRAPH2_PATH = "/home/carlitos/Documents/School/git/CS223/txtFiles/unweighted2.txt";
	static final String DAG1_PATH = "/home/carlitos/Documents/School/git/CS223/txtFiles/dag1.txt";
	static final String DAG2_PATH = "/home/carlitos/Documents/School/git/CS223/txtFiles/dag2.txt";
	static final String MUTANT1_PATH = "/home/carlitos/Documents/School/git/CS223/txtFiles/mutant1.txt";
	static final String MUTANT2_PATH = "/home/carlitos/Documents/School/git/CS223/txtFiles/mutant2.txt";
	static final String MUTANT3_PATH = "/home/carlitos/Documents/School/git/CS223/txtFiles/mutant3.txt";

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