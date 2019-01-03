package common.test.quicksort;

public class DeScanSwapSort {

	public void deScanSwapSort(int[] items) {
		deScanSwapSort(items, 0, items.length - 1);
	}
	
	/**
	 * 双端扫描快排
	 * 
	 * @param items
	 * @param start
	 * @param end
	 */
	public void deScanSwapSort(int[] items, int start, int end) {
		if (start < end) {
			int i = start + 1 , j = end ;
			int pivot = items[start] ;
			
			while(i <= j) {
				// 直到找比轴点大的
				while (i <= j && items[i] < pivot) {
					i++ ;
				}
				
				// 直到找比轴点小的
				while (i <= j && items[j] >= pivot) {
					j-- ;
				}
				
				if (i <= j) {
					// 交换
					Utils.swap(items, i, j);
				}
			}
			
			// 本轮结束了，交换轴点
			Utils.swap(items, start, j);
			
			sysArr(items);
			
			deScanSwapSort(items, start, j - 1);
			deScanSwapSort(items, j + 1, items.length - 1);
		}
	}
	
	public void sysArr(int[] items) {
		for (int i : items) {
			System.out.print(i+",");
		}
		System.out.println();
	}
}
