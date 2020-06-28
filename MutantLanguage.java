import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MutantLanguage extends Graph {

	private String words[];
	private int numWords;
	private int inDegree[];

	// public MutantLanguage(String filePath) throws FileNotFoundException {
	// 	readLanguage(filePath);
	// 	makeGraph();
	// }

	// Creating the file
	private void readLanguage(String filePath) throws FileNotFoundException {
		// create a scanner object fileReader on filePath.
		// read the number of distinct characters in the class-variable numVertices
		// Java: Syntax to read a value into an integer variable x is: x = fileReader.nextInt();
		// Now, read the number of words in the language into the class-variable numWords
		// Allocate numWords cells for the class-array words. Note that words is a string array.
		// Run a for loop from i = 0 to i < numWords. Within the for-loop, use fileReader to read the line into the array cell words[i].
		// Java: Syntax to read into a string variable y is: y = fileReader.next();
		// After the loop, close fileReader.
	}

	private void makeGraph() {
		// Allocate numVertices cells for outDegree and inDegree arrays. 
		// Allocate numVertices rows for adjList.
		// C++ syntax: adjList.reserve(numVertices);
		// Java syntax: adjList = new ArrayList<ArrayList<Edge>>(numVertices);
		// for (i = 0 to i < numV ertices), do the following:
		// 	set outDegree[i] to 0
		// 	add a blank row to adjList
		// 	C++ syntax: adjList.push back(vector<Edge>());
		// 	Java syntax: adjList.add(new ArrayList<Edge>());
		// for (i = 0 to i < numW ords − 1), do the following:
		// 	let currentW ord = words[i] and nextW ord = words[i + 1]
		// 	let minLength be the minimum of the lengths of currentW ord and nextW ord
		// 	C++/Java syntax for length of a string named str: str.length()
		// 	for (j = 0 to j < minLength), do the following:
		// 		let x be the jth character of currentW ord
		// 		C++ syntax: char x = currentWord.at(j);
		// 		Java syntax: char x = currentWord.charAt(j);
		// 		let y be the jth character of nextWord
		// 		if (x 6= y), then:
		// 			let int src = x − 97
		// 			let int dest = y − 97
		// 			create an edge e by calling the Edge constructor with arguments src and dest respectively
		// 			add the edge e to the end of adjList[src]
		// 			C++ syntax: adjList.at(src).push back(e);
		// 			Java syntax: adjList.get(src).add(e);
		// 			increment outDegree[src] by 1
		// 			break;
	}

	// public char[] getOrder() throws Exception { // complete this method
	// }
}
