package common.test.quicksort;

public class QuickSortTest {

	public static void main(String[] args) {
		int[] items = new int[] {4,2,6,1,3,5,7} ; 
		DeScanSwapSort _deScanSwapSortTest = new DeScanSwapSort() ;
		_deScanSwapSortTest.deScanSwapSort(items);
		for (int i : items) {
			System.out.println(i);
		}
	}

}
