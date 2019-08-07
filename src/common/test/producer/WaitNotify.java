package common.test.producer;

public class WaitNotify {

	private int count ;
	
	private int cap  ;
	
	public WaitNotify(int cap) {
		this.cap = cap ;
	}
	
	public synchronized void produce() {
		while(count >= cap) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		
		count++ ;	
		System.out.println("生产者生产了一个商品，当前库存：" + count);
		
		notifyAll();
	}
	
	public synchronized void consume() {
		
		while(count <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		count -- ;
		System.out.println("消费者消费了一个商品，当前库存：" + count);
		
		notifyAll();
	}
	
	public static void main(String[] args) {
		WaitNotify wait = new WaitNotify(10) ;
		
		
		for(int i = 0; i < 20; i++)
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					wait.produce();
				}
			}).start(); 
		
		for(int i = 0; i < 20; i++)
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					wait.consume();
				}
			}).start(); 
		
	}

}
