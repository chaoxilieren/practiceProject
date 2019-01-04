package common.test.insertsort;

/**
 * 插入排序， 有数据的移动
 * 
 * @author aihui.huang
 *
 */
public class InsertSort {

	/**
	 * 使用了一个辅助数组
	 * 
	 * @param items
	 * @return
	 */
	public int[] insertSortWithArray(int[] items) {
		
		if (items == null || items.length == 0) {
			return items;
		}
		
		// 初始都是0的数组
		int[] sorts = new int[items.length] ;
		
		// 当前插到第几个了
		int index = 0 ;
		
		for (int i : items) {
			
			int _insertIndex = -1 ;
			for(int j = 0; j < sorts.length; j++) {
				if (i <= sorts[j]) {
					// 插入j这个位置，j以及j之后得往后移动
					for(int k = index ; j < k; k--) {
						sorts[k] = sorts[k - 1] ;
					}
					
					_insertIndex = j ;
					break ;
				}
			}
			
			if (_insertIndex != -1) {
				sorts[_insertIndex] = i ;
			}else {
				sorts[index] = i ;
			}
			
			index++ ;
		}
		
		return sorts ;
	}
	
	
	/**
	 * 不使用其他辅助数组
	 * 
	 * @param items
	 */
	public void insertSort(int[] items) {
		if (items == null || items.length == 0) {
			return ;
		}
		
		//当前已经插入到的索引
		int index = 0 ;
		
		for(int i = 0; i < items.length; i++) {
			
			int needInsertItem = items[i] ;
			int insertIndex = -1 ;
			for(int j = 0; j < index; j++) {
				if (needInsertItem < items[j]) {
					// 找到插入位置
					insertIndex = j ;
					// j以及j~index之间要往后移动
					for(int k = index ; j < k; k--) {
						items[k] = items[k - 1] ;
					}
					
					break ;
				}
			}
			
			if (insertIndex != -1) {
				items[insertIndex] = needInsertItem ;
			}else {
				items[index] = needInsertItem ; 
			}
					
			index++ ;
		}
		
	}
	
	public void insertSortWithWhile(int[] items) {
		if (items == null || items.length == 0) {
			return ;
		}
		
		for(int i = 1; i < items.length; i++) {
			int j = i - 1 ;
			
			int current = items[i] ;
			
			while(j >= 0) {
				if (current < items[j]) {
					items[j+1] = items[j] ; 
				}else {
					break ;
				}
				
				j -- ;
			}
			
			items[j + 1] = current ;
		}
	}
	
	public static void main(String[] args) {
		InsertSort insertSort = new InsertSort() ;
		
		int[] items = new int[] {5,6,3,1,8,7,2,4} ;
		
		for (int i : insertSort.insertSortWithArray(items)) {
			System.out.print(i+",");
		};
		
		
		System.out.println();
		
		int[] items1 = new int[] {5,6,3,1,8,7,2,4} ;
		insertSort.insertSort(items1);
		for (int i : items1) {
			System.out.print(i+",");
		}
		
		System.out.println();
		
		int[] items2 = new int[] {5,6,3,1,8,7,2,4} ;
		insertSort.insertSortWithWhile(items2);
		for (int i : items2) {
			System.out.print(i+",");
		}
		
	}
}
