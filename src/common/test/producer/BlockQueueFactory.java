package common.test.producer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockQueueFactory extends IModelFactory {

	private BlockingQueue<Object> queue ;
	
	public BlockQueueFactory(int maxCount) {
		super(maxCount) ;
		queue = new LinkedBlockingDeque<Object>(maxCount) ;
	}
	
	@Override
	public void produce() {
		try {
			queue.put(new Object()) ;
			System.out.println("生产者 生产了一个产品，库存：" + queue.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void consume() {
		try {
			queue.take() ;
			System.out.println("消费者 消费了一个产品，库存："+ getSize());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
