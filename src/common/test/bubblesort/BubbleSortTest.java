package common.test.bubblesort;

import java.util.Arrays;

public class BubbleSortTest {

	/**
	 * 冒泡排序原始版
	 * 
	 * @param array
	 */
	public static void bubbleSort(int[] array) {
		if (array == null || array.length == 0) {
			return ;
		}
		
		int temp = 0 ;
		for (int i = 0; i < array.length; i++) {
			
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j+1]) {
					// 交换
					temp = array[j] ;
					array[j] = array[j+1] ;
					array[j+1] = temp ;
				}
			}
		}
		
	}
	
	/**
	 * 优化第一版
	 * 每轮冒泡之后检测数组是否已是有序
	 * 
	 * @param array
	 */
	public void bubbleSort1(int[] array) {
		if (array == null || array.length == 0) {
			return ;
		}
		
		int temp = 0 ;
		for (int i = 0; i < array.length; i++) {

			boolean isSort = true ;
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j+1]) {
					// 交换
					temp = array[j] ;
					array[j] = array[j+1] ;
					array[j+1] = temp ;
				}
				
				isSort = false ;
			}
			
			if (isSort) {
				break ;
			}
		}
	}
	
	/**
	 * 优化第二版
	 * 去除已有序的遍历
	 * 
	 * @param array
	 */
	public void bubbleSort2(int[] array) {
		if (array == null || array.length == 0) {
			return ;
		}
		
		int temp = 0 ;
		int lastSwapIndex = 0 ;
		int sortBorder = array.length - 1 ;
		for (int i = 0; i < array.length; i++) {

			boolean isSort = true ;
			for (int j = 0; j < sortBorder; j++) {
				if (array[j] > array[j+1]) {
					// 交换
					temp = array[j] ;
					array[j] = array[j+1] ;
					array[j+1] = temp ;
					
					lastSwapIndex = j ;
				}
				
				isSort = false ;
			}
			
			sortBorder = lastSwapIndex ;
			
			if (isSort) {
				break ;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {3,5,6,1,9,0} ;
		bubbleSort(a);
		System.out.println(Arrays.toString(a));
	}

}
