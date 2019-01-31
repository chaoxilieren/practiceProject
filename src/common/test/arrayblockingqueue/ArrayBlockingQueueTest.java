package common.test.arrayblockingqueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 如果删除一个中间数据，后面的数据会往前移动
 * 
 * @author aihui.huang
 *
 */
public class ArrayBlockingQueueTest {

	public static void main(String[] args) {
		ArrayBlockingQueue<Integer> a = new ArrayBlockingQueue<>(3) ;
		
		a.add(1) ;
		a.add(2) ;
		a.add(3) ;
		
		a.remove(2) ;
		
		for (Integer integer : a) {
			System.out.print(integer+",");
		}
		
		System.out.println();
		
		a.add(4) ;
		
		for (Integer integer : a) {
			System.out.print(integer+",");
		}
		
		System.out.println();
		
		a.remove(1) ;
		a.add(5) ;
		for (Integer integer : a) {
			System.out.print(integer+",");
		}
		
		System.out.println();
		
	}

}
