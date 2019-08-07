package common.test.producer;

/**
 * 消费者
 * 
 * @author aihui.huang
 *
 */
public class Consumer implements Runnable{

	private IModelFactory factory;
	
	public Consumer(IModelFactory factory) {
		this.factory = factory ;
	}
	
	@Override
	public void run() {
		this.factory.consume(); 
	}
	
}
