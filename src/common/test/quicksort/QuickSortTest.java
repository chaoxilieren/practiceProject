package common.test.quicksort;

public class QuickSortTest {

	public static void main(String[] args) {
		int[] items = new int[] {4,2,6,1,3,5,7} ; 
		DeScanSwapSort _deScanSwapSortTest = new DeScanSwapSort() ;
		_deScanSwapSortTest.deScanSwapSort(items);
		for (int i : items) {
			System.out.print(i+",");
		}
		
		System.out.println();
		
		int[] items1 = new int[] {4,2,6,1,3,5,7} ;
		FillSort fillSort = new FillSort() ;
		fillSort.fillSort(items1);
		for (int i : items1) {
			System.out.print(i+",");
		}
		
		System.out.println();
		
		int[] items2 = new int[] {4,2,6,1,3,5,7} ;
		ForwardScanSort _forwardSort = new ForwardScanSort() ;
		
		_forwardSort.forwardScanSort(items2);
		for (int i : items2) {
			System.out.print(i+",");
		}
		
		System.out.println();
		
		int[] items3 = new int[] {4,2,6,1,3,5,7} ;
		Div3ScanSort _div3ScanSort = new Div3ScanSort() ;
		
		_div3ScanSort.div3ScanSort(items3);
		for (int i : items3) {
			System.out.print(i+",");
		}
		

		System.out.println();
		
		int[] items4 = new int[] {4,2,6,1,3,5,7} ;
		DualPivotQuickSort dualPivot = new DualPivotQuickSort() ;
		
		dualPivot.dualPivotQuickSort(items4);
		for (int i : items4) {
			System.out.print(i+",");
		}
	}

}
