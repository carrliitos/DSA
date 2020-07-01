import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph {

	public int numVertices;
	public int numEdges;
	public int outDegree[];
	public List<ArrayList<Edge>> adjList;

	public void readWeightedGraph(String filePath) throws FileNotFoundException {
		Scanner fileReader = new Scanner(new FileInputStream(filePath));
		numVertices = fileReader.nextInt();
		numEdges = fileReader.nextInt();
		outDegree = new int[numVertices];
		adjList = new ArrayList<ArrayList<Edge>>(numVertices);

		for(int i = 0; i < numVertices; i++) {
			outDegree[i] = 0;
			adjList = new ArrayList<ArrayList<Edge>>();
		}

		for(int i = 0; i < numEdges; i++) {
			int src, dest, weight;
			src = fileReader.nextInt();
			dest = fileReader.nextInt();
			weight = fileReader.nextInt();
			Edge e = new Edge(src, dest, weight);
			adjList.add(adjList.size() - 1, e);
			outDegree[src]++;
		}

		fileReader.close();
	}
}
