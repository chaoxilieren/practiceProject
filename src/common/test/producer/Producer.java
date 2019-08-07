package common.test.producer;

/**
 * 生产者
 * 
 * @author aihui.huang
 *
 */
public class Producer implements Runnable {
	
	private IModelFactory factory ;
	
	public Producer(IModelFactory factory) {
		this.factory = factory ;
	}
	
	@Override
	public void run() {
		this.factory.produce() ; 
	}
}
