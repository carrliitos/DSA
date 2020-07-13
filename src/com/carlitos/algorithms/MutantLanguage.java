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

	// Creating the file
	private void readLanguage(String filePath) throws FileNotFoundException {
		// create a scanner object fileReader on filePath.
		Scanner fileReader = new Scanner(new FileInputStream("x.txt"));
		// read the number of distinct characters in the class-variable numVertices
		// Java: Syntax to read a value into an integer variable x is: x = fileReader.nextInt();
		numVertices = fileReader.nextInt();
		// Now, read the number of words in the language into the class-variable numWords
		numWords = fileReader.nextInt();
		// Allocate numWords cells for the class-array words. Note that words is a string array.
		words = new String[numWords];
		// Run a for loop from i = 0 to i < numWords. Within the for-loop, use fileReader to read the line into the array cell words[i].
		// Java: Syntax to read into a string variable y is: y = fileReader.next();
		for(int i = 0; i < numWords; i++) {
			words[i] = fileReader.next();	
		}
		// After the loop, close fileReader.
		fileReader.close();

	}

	private void makeGraph() {
		// Allocate numVertices cells for outDegree and inDegree arrays. 
		inDegree = new int[numVertices];
		outDegree = new int[numVertices];
		// Allocate numVertices rows for adjList.
		// C++ syntax: adjList.reserve(numVertices);
		// Java syntax: adjList = new ArrayList<ArrayList<Edge>>(numVertices);
		adjList = new ArrayList<ArrayList<Edge>>(numVertices);
		// for (i = 0 to i < numVertices), do the following:
		for(int i = 0; i < numVertices; i++) {			
		// 	set outDegree[i] to 0
			outDegree[i] = 0;
		// 	add a blank row to adjList
		// 	C++ syntax: adjList.push back(vector<Edge>());
		// 	Java syntax: adjList.add(new ArrayList<Edge>());
			adjList.add(new ArrayList<Edge>());
		}
		// for (i = 0 to i < numWords − 1), do the following:
		for (int i = 0; i < numWords - 1; i++) {
		// 	let currentWord = words[i] and nextWord = words[i + 1]
			String currentWord = words[i];
			String nextWord = words[i + 1];
		// 	let minLength be the minimum of the lengths of currentWord and nextWord
		// 	C++/Java syntax for length of a string named str: str.length()
			int minLength = currentWord.length();
			int minLengths = nextWord.length();
		// 	for (j = 0 to j < minLength), do the following:
			for(int j = 0; j < minLength; j++){
		// 		let x be the jth character of currentWord
		// 		C++ syntax: char x = currentWord.at(j);
		// 		Java syntax: char x = currentWord.charAt(j);
				int x = currentWord.charAt(j);
		// 		let y be the jth character of nextWord
				int y = nextWord.charAt(j);
		// 		if (x != y), then:
				if(x != y){
		// 			let int src = x − 97
					int src = x - 97;
		// 			let int dest = y − 97
					int dest = y - 97;
		// 			create an edge e by calling the Edge constructor with arguments src and dest respectively
					Edge e = new Edge(src, dest);
		// 			add the edge e to the end of adjList[src]
		// 			C++ syntax: adjList.at(src).push back(e);
		// 			Java syntax: adjList.get(src).add(e);
					adjList.get(src).add(e);
		// 			increment outDegree[src] by 1
					outDegree[src]++;
		// 			break;
					break;
				}
			}
		}
	}

	public char[] getOrder() throws Exception {
		// Use a loop to initialize all cells of inDegree[] to 0
		for(int i = 0; i < inDegree.length; i++) {
			inDegree[i] = 0;
		}
		// Create a char array topoOrder[] having length numVertices
		// C++ programmers must use dynamic allocation. So, if you want to return a char array x of length 10, it must be declared as char *x = new char[10];
		char topoOrder[] = new char[numVertices];
		// for (i = 0 to i < numVertices), do the following:
		for(int i = 0; i < numVertices; i++){
		// 	for (j = 0 to j < outDegree[i]), do the following:
			for(int j = 0; j < outDegree[i]; j++){
		// 		Let adjEdge be the jth outgoing edge of vertex i
				Edge adjEdge = adjList.get(i).get(j);
		// 		increment inDegree[adjEdge's destination] by 1
				inDegree[adjEdge.dest]++;
			}
		}
		// Create a Queue vertexQ of size numVertices
		Queue vertexQ = new Queue(numVertices);
		// Initialize an integer variable topoLevel = 0
		int topoLevel = 0;
		// for (i = 0 to i < numVertices), do the following:
		for(int i = 0; i< numVertices; i++){
		// 	if (inDegree[i] equals 0), enqueue i into the vertexQ
			if(inDegree[i] == 0)
				vertexQ.enqueue(i);
		}
		// while (vertexQ's size > 0), do the following:
		while(vertexQ.size() > 0) {
		//	let v be the vertex obtained by dequeue-ing vertexQ
			int v = vertexQ.dequeue();
		//	assign topoOrder[topoLevel] = (char) (v + 97)
			topoOrder[topoLevel] = (char) (v + 97);
		//	increment topoLevel by 1
			topoLevel++;
		//	for (j = 0 to j < outDegree[v]), do the following:
			for(int j = 0; j < outDegree[v]; j++){
		//		let adjEdge be the jth outgoing edge of the vertex v
				Edge adjEdge = adjList.get(v).get(j);
		//		let adjVertex be the destination of adjEdge
				int adjVertex = adjEdge.dest;
		//		decrement inDegree[adjVertex] by 1
				inDegree[adjVertex]--;
		//		if (inDegree[adjVertex] equals 0), then enqueue adjVertex to vertexQ
				if(inDegree[adjVertex] == 0)
					vertexQ.enqueue(adjVertex);
			}
		}
		// if (topoLevel != numVertices), return null, else return topoOrder
		if(topoLevel != numVertices){
			return null;
		}
		else
			return topoOrder;
	}
}
