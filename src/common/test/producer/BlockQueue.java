package common.test.producer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockQueue {
	
	private BlockingQueue<Integer> queue ;
	
	public BlockQueue(int cap) {
		this.queue = new LinkedBlockingDeque<>(cap) ;
	}
	
	public void produce() {
		int value = (int)(10 * Math.random()) ;
		try {
			queue.put(new Integer(value));
			System.out.println("生产者生产了一个商品:"+value+"，当前库存：" + queue.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void cousume() {
		try {
			int value = queue.take() ;
			System.out.println("消费者消费了一个商品:"+value+"，当前库存：" + queue.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		BlockQueue blockQueue = new BlockQueue(10) ;
		for(int i = 0; i < 20; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					blockQueue.produce();
				}
			}).start();
			
			
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					blockQueue.cousume();
				}
			}).start();
		}
	}

}
