package common.test.quicksort;

/**
 * 一端挖坑，一端填充方式快排
 * 
 * @author aihui.huang
 *
 */
public class FillSort {

	public void fillSort(int[] items) {
		fillSort(items, 0, items.length - 1);
	}
	
	public void fillSort(int[] items, int start, int end) {
		if (start < end) {
			int i = start, j = end ;
			int pivot = items[start] ;
			
			while(i < j) {
				while(i < j && items[j] > pivot) {
					j -- ;
				}
				
				items[i] = items[j] ;
				
				while(i < j && items[i] < pivot) {
					i ++ ;
				}
				
				items[j] = items[i] ;
			}
			
			items[i] = pivot ;
			
			fillSort(items, start, j - 1);
			fillSort(items, j + 1, end);
		}
	}
}
