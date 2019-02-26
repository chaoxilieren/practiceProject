package common.test.findmedian;

import java.util.Arrays;

import com.sun.org.glassfish.gmbal.AMXMBeanInterface;

public class FindMedian {

	/**
	 * 对于a和b数组总长度为偶数，则取的是第一个中位数
	 * 
	 * @param a
	 * @param b
	 * @param start
	 * @param end
	 * @param c
	 * @return
	 */
	public static int findMedian(int[] a, int[] b, int start, int end, int c) {
		// p是最终的值
		int p ;
		
		int n = b.length ;
		
		int m = a.length ;
		
		p = (start + end) / 2;
		
		if (m == 1 && n == 1) {
			return a[0] ;
		}
		
		if (start > end) {
			return findMedian(b, a, 0, n - 1, c) ;
		}
		
		int cp = c - p ;
		
		if(cp >= 1 && cp - 1 < n && a[p] >= b[cp - 1] && cp < n && a[p] <= b[cp] ) {
			return a[p] ;
		}
		
		if(cp >= 1 && cp - 1 < n && a[p] < b[cp - 1]) {
			return findMedian(a, b, p+1, end, c) ;
		}
		
		return findMedian(a, b, start, p - 1, c) ;
		
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {1, 3} ;
		int[] b = new int[] {2} ;
		
		int lengthAll = a.length + b.length ;
		
		int halfLength1 = (lengthAll - 1 )/ 2 ;
		
		System.err.println(findMedian(a, b, 0, a.length - 1 , halfLength1));
		
		
		System.out.println(findMedianSortedArrays(a, b) );;
		
		
		
	}
	
	public static int findKth(int[] a, int aStart, int[] b, int bStart, int k) {
		if (aStart > a.length - 1) {
			return b[bStart + k - 1] ;
		}
		
		if (bStart > b.length - 1) {
			return a[aStart + k - 1] ;
		}
		
		if (k == 1) {
			return Math.min(a[aStart], b[bStart]) ;
		}
		
		int aMid = Integer.MAX_VALUE ;
		int bMid = Integer.MAX_VALUE ;
		
		if (aStart + k/2 - 1 < a.length) {
			aMid = a[aStart + k/2 - 1] ; 
		}
		
		if (bStart + k/2 - 1 < b.length) {
			bMid = b[bStart + k/2 - 1] ;
		}
		
		if (aMid < bMid) {
			return findKth(a, aStart + k/2, b, bStart, k - k/2) ;
		}else {
			return findKth(a, aStart, b, bStart + k/2, k - k/2) ;
		}
	}
	
	public static double findMedianSortedArrays(int[] a, int[] b) {
		int alen = a.length ;
		int blen = b.length ;
		
		if (alen == 0 && blen == 0) {
			return 0.0  ;
		}
		
		// 从1开始
		int leftM = (alen + blen + 1) / 2 ;
		int rightM = (alen + blen + 2) / 2 ;
				
		if (leftM == rightM) {
			return findKth(a, 0, b, 0, leftM) ;
		}
		
		return (findKth(a, 0, b, 0, leftM) + findKth(a, 0, b, 0, rightM))/2.0 ;
	}

}
