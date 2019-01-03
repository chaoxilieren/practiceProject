package common.test.quicksort;

public class Utils {

	public static void swap(int[] items, int i, int j) {
		int temp = items[i] ;
		items[i] = items[j] ;
		items[j] = temp ;
	}
}
