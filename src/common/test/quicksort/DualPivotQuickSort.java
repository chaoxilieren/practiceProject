package common.test.quicksort;

/**
 * 双轴快排，思想跟三分单向扫描有点像 {@link Div3ScanSort}
 * 
 * 大致思路：
 * 取2个轴点pivot1, pivot2，一般取第一个元素和最后一个元素，如果第一个元素大于第二个，须交换
 * 然后将数据分为三段，<pivot1, >=pivot1并且<=pivot2,>pivot2.然后三个分别递归快排
 * 
 * @author aihui.huang
 *
 */
public class DualPivotQuickSort {

	public void dualPivotQuickSort(int[] items) {
		dualPivotQuickSort(items, 0, items.length - 1);
	}
	
	public void dualPivotQuickSort(int[] items, int start, int end) {
		if (start < end) {
			int i = start, j = end, k = start + 1 ;
			
			// 保证第一个轴点小于第二个轴点
			if (items[start] > items[end]) {
				Utils.swap(items, start, end);
			}
			
			int pivot1 = items[start] ;
			int pivot2 = items[end] ;
			
			// 只有k在扫描
			while(k < j) {
				
				if (items[k] < pivot1) {
					i++ ;
					Utils.swap(items, k, i);
					k++ ;
				}else if(items[k] >= pivot1 && items[k] <= pivot2) {
					k++ ;
				}else {
					Utils.swap(items, k, j);
					j-- ;
				}
				
			}
			
			Utils.swap(items, start, i); 
			Utils.swap(items, k, end);
			
			dualPivotQuickSort(items, start, i - 1);
			dualPivotQuickSort(items, i + 1, j - 1);
			dualPivotQuickSort(items, j + 1, end);
		}
	}
}
