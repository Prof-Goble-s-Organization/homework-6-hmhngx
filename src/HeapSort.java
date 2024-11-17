import java.util.Arrays;

public class HeapSort {

	public static void heapSort(Integer[] values) {
		int n = values.length;

		heapify(values, n);

		for (int i = n - 1; i > 0; i--) {
			swap(values, 0, i);
			trickleDown(values, i, 0);
		}
	}

	private static void heapify(Integer[] values, int heapSize) {
		for (int i = heapSize / 2 - 1; i >= 0; i--) {
			trickleDown(values, heapSize, i);
		}
	}

	private static void trickleDown(Integer[] values, int heapSize, int rootIndex) {
		int smallest = rootIndex;
		int leftChild = 2 * rootIndex + 1;
		int rightChild = 2 * rootIndex + 2;

		if (leftChild < heapSize && values[leftChild] < values[smallest]) {
			smallest = leftChild;
		}

		if (rightChild < heapSize && values[rightChild] < values[smallest]) {
			smallest = rightChild;
		}

		if (smallest != rootIndex) {
			swap(values, rootIndex, smallest);
			trickleDown(values, heapSize, smallest);
		}
	}

	private static void swap(Integer[] values, int i, int j) {
		int temp = values[i];
		values[i] = values[j];
		values[j] = temp;
	}

	public static void main(String[] args) {
		int size = 20;
		Integer[] list = new Integer[size];

		for (int i = 0; i < list.length; i++) {
			list[i] = i;
		}

		System.out.println("Unsorted List: " + Arrays.toString(list));
		heapSort(list);
		System.out.println("  Sorted List:" + Arrays.toString(list));
	}
}
