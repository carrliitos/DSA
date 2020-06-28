import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MutantLanguage extends Graph {

	private String words[];
	private int numWords;
	private int inDegree[];

	public MutantLanguage(String filePath) throws FileNotFoundException {
		readLanguage(filePath);
		makeGraph();
	}

	private void readLanguage(String filePath) throws FileNotFoundException {
		Scanner fileReader = new Scanner(new FileInputStream("x.txt"));
		numVertices = fileReader.nextInt();
		numWords = fileReader.nextInt();
		words = new String[numWords];
		for(int i = 0; i < numWords; i++) {
			words[i] = fileReader.next();	
		}
		fileReader.close();

	}

	private void makeGraph() {
		inDegree = new int[numVertices];
		outDegree = new int[numVertices];
		adjList = new ArrayList<ArrayList<Edge>>(numVertices);
		for(int i = 0; i < numVertices; i++) {			
			outDegree[i] = 0;
			adjList.add(new ArrayList<Edge>());
		}

		for (int i = 0; i < numWords - 1; i++) {
			String currentWord = words[i];
			String nextWord = words[i + 1];

			int minLength = currentWord.length();
			int minLengths = nextWord.length();

			for(int j = 0; j < minLength; j++){
				int x = currentWord.charAt(j);
				int y = nextWord.charAt(j);
				if(x != y){
					int src = x - 97;
					int dest = y - 97;
					Edge e = new Edge(src, dest);
					adjList.get(src).add(e);
					outDegree[src]++;
					break;
				}
			}
		}
	}

	public char[] getOrder() throws Exception {
		for(int i = 0; i < inDegree.length; i++) {
			inDegree[i] = 0;
		}
		char topoOrder[] = new char[numVertices];

		for(int i = 0; i < numVertices; i++){
			for(int j = 0; j < outDegree[i]; j++){
				Edge adjEdge = adjList.get(i).get(j);
				inDegree[adjEdge.dest]++;
			}
		}

		Queue vertexQ = new Queue(numVertices);
		int topoLevel = 0;

		for(int i = 0; i< numVertices; i++){
			if(inDegree[i] == 0)
				vertexQ.enqueue(i);
		}

		while(vertexQ.size() > 0) {
			int v = vertexQ.dequeue();
			topoOrder[topoLevel] = (char) (v + 97);
			topoLevel++;
			for(int j = 0; j < outDegree[v]; j++){
				Edge adjEdge = adjList.get(v).get(j);
				int adjVertex = adjEdge.dest;
				inDegree[adjVertex]--;
				if(inDegree[adjVertex] == 0)
					vertexQ.enqueue(adjVertex);
			}
		}

		if(topoLevel != numVertices){
			return null;
		}
		else
			return topoOrder;
	}
}
