package common.test.producer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockFactory extends IModelFactory {

	private ReentrantLock lock = new ReentrantLock() ;
	
	private Condition emptyCondition = lock.newCondition() ;
	
	private Condition fullCondition = lock.newCondition();
	
	public LockFactory(int cap) {
		super(cap) ;
	}
	
	@Override
	public void produce() {
		
		try{
			lock.lock();
			
			while (isFull()) {
				fullCondition.await(); 
			}
			
			getProducts().add(new Object()) ;

			System.out.println("生产者 生产了一个产品，库存：" + getSize());
			
			emptyCondition.signalAll(); 
			
		}catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock(); 
		}
	}

	@Override
	public void consume() {
		try {
			lock.lock(); 
			while (getSize() <= 0) {
				emptyCondition.await(); 
			}
			
			getProducts().remove(0) ;
			
			System.out.println("消费者 消费了一个产品，库存："+ getSize());
			
			fullCondition.signalAll(); 
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock(); 
		}
	}

}
