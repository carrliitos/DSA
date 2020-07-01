import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DijkstraGraph {

	public int numVertices;
	public int numEdges;
	public int outDegree[];
	public List<ArrayList<Edge>> adjList;

	public void readWeightedGraph(String filePath) throws FileNotFoundException {
		// Java: Create a Scanner object fileReader on filePath.
		Scanner fileReader = new Scanner(new FileInputStream(filePath));
		// Read the number of vertices into the class-variable numVertices.
		numVertices = fileReader.nextInt();
		// Then, read the number of edges into the class-variable numEdges.
		numEdges = fileReader.nextInt();
		// Allocate numVertices cells for outDegree.
		outDegree = new int[numVertices];
		// Allocate numVertices rows for adjList.
		adjList = new ArrayList<ArrayList<Edge>>(numVertices);
		// for (i = 0 to i < numVertices), do the following:
		for(int i = 0; i < numVertices; i++) {
			// set outDegree[i] to 0
			outDegree[i] = 0;
			// add a blank row to adjList
			adjList = new ArrayList<ArrayList<Edge>>();
		}
		// for (i = 0 to i < numEdges), do the following:
		for(int i = 0; i < numEdges; i++) {
			// declare three integer variables src, dest, and weight
			int src, dest, weight;
			// use fileReader to read from the file into these 3 variables respectively
			src = fileReader.nextInt();
			dest = fileReader.nextInt();
			weight = fileReader.nextInt();
			// create an edge e by calling the Edge constructor with arguments src, dest, and weight respectively
			Edge e = new Edge(src, dest, weight);
			// add the edge e to the end of adjList[src]
			adjList.add(adjList.size() - 1, e);
			// increment outDegree[src] by 1
			outDegree[src]++;
		}
		// After the loop, close fileReader.
		fileReader.close();
	}
}
