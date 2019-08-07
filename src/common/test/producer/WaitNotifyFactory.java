package common.test.producer;

public class WaitNotifyFactory extends IModelFactory {

	public WaitNotifyFactory (int maxCount) {
		super(maxCount) ;
	}
	
	@Override
	public void produce() {
		
		synchronized (this) {
			while (isFull()) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
			}
			
			getProducts().add(new Object()) ;
			System.out.println("生产者 生产了一个产品，库存：" + getSize());
			notifyAll();
		}
	}

	@Override
	public void consume() {
		
		synchronized (this) {
			while (getSize() == 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			getProducts().remove(0) ;
			System.out.println("消费者 消费了一个产品，库存："+ getSize());
			notifyAll();
		}
	}

}
