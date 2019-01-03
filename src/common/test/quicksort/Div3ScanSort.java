package common.test.quicksort;

/**
 * 三分单向扫描， 分成三段，小于轴点的，等于轴点，大于轴点
 * 
 * @author aihui.huang
 *
 */
public class Div3ScanSort {

	public void div3ScanSort(int[] items) {
		div3ScanSort(items, 0, items.length - 1);
	}
	
	public void div3ScanSort(int[] items, int start, int end) {
		if (start < end) {
			int i = start, j = end, k = start + 1 ;
			int pivot = items[start] ;
			
			// 只有k在扫描
			while(k <= j) {
				
				// 处理小于轴点的
				if (items[k] < pivot) {
					Utils.swap(items, i, k);
					i++ ;
					k++ ;
				}else if(items[k] == pivot) {
					// do nothing
					k++ ;
				}else {
					// 处理大于轴点的
					Utils.swap(items, k, j);
					j -- ;
				}
				
			}
			
			div3ScanSort(items, start, i - 1);
			div3ScanSort(items, j + 1, end);
		}
	}
}
