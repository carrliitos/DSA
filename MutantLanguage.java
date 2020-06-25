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
		int x = fileReader.nextInt();
		// Now, read the number of words in the language into the class-variable numWords
		numWords = x.split();
		// Allocate numWords cells for the class-array words. Note that words is a string array.
		String words[] = new words[numWords];
		// Run a for loop from i = 0 to i < numW ords. Within the for-loop, use fileReader to read the line into the array cell words[i].
		// Java: Syntax to read into a string variable y is: y = fileReader.next();
		// After the loop, close fileReader.
	}

	private void makeGraph() { // complete this method
	}

	public char[] getOrder() throws Exception { // complete this method
	}
}
