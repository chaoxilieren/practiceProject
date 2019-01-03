package common.test.quicksort;

/**
 * 单向扫描划分方式
 * 
 * @author aihui.huang
 *
 */
public class ForwardScanSort {

	public void forwardScanSort(int[] items) {
		forwardScanSort(items, 0, items.length - 1);
	}
	
	public void forwardScanSort(int[] items, int start, int end) {
		if (start < end) {
			int i = start, j = start + 1 ;
			int pivot = items[start] ;
			
			while(j <= end) {
				
				// 只是j在扫描
				if(items[j] < pivot) {
					i ++ ;
					Utils.swap(items, i, j);
				}
				
				j ++ ;
			}
			
			// 将pivot放到中间
			Utils.swap(items, start, i);
			
			forwardScanSort(items, start, i - 1);
			forwardScanSort(items, i + 1, end);
		}
	}
}
