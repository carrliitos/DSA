import java.util.ArrayList;

public class Heap {

	ArrayList<String> heapArray;

	public Heap() {
		heapArray = new ArrayList<String>();
	}

	public String getMinimum() {
		return heapArray.get(0);
	}

	public void deleteMinimum() {
		heapArray.set(0, heapArray.get(size() - 1));
		heapArray.remove(size() - 1);
		int currentIndex = 0;
		int leftIndex = 1;
		int rightIndex = 2;

		while(leftIndex < size()) {
			String currentKey = heapArray.get(currentIndex);
			String leftKey = heapArray.get(leftIndex);

			if(rightIndex < size()) {
				String rightKey = heapArray.get(rightIndex);
				if((leftKey.compareTo(currentKey) < 0) 
					&& (leftKey.compareTo(rightKey) < 0)) {
					swap(leftIndex, currentIndex);
					currentIndex = leftIndex;
				}else if(rightKey.compareTo(currentKey) < 0) {
					swap(rightIndex, currentIndex);
					currentIndex = rightIndex;
				}else {
					break;
				}
			}else if(leftKey.compareTo(currentKey) < 0) {
				swap(leftIndex, currentIndex);
				break;
			}else { 
				break;
			}

			leftIndex = 2 * currentIndex + 1;
			rightIndex = leftIndex + 1;
		}
	}

	public void insert(String value) {
		int currentIndex = size();
		int parentIndex = (currentIndex - 1) / 2;
		heapArray.add(size(), value);

		while((currentIndex > 0) && (heapArray.get(parentIndex).compareTo(heapArray.get(currentIndex)) > 0)) {
			swap(parentIndex, currentIndex);
			currentIndex = parentIndex;
			parentIndex = (currentIndex - 1) / 2;
		}
	}

	private void swap(int index1, int index2) {
		String temp = heapArray.get(index1);
		heapArray.set(index1, heapArray.get(index2));
		heapArray.set(index2, temp);
	}

	public int size() {
		return heapArray.size();
	}
}
