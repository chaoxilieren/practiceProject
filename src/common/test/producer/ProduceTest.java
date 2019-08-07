package common.test.producer;

public class ProduceTest {

	public static void main(String[] args) {
//		IModelFactory waitNotifyFactory = new WaitNotifyFactory(10) ;
//		
//		for(int i = 0;  i < 20; i++)
//			new Thread(new Consumer(waitNotifyFactory)).start();
//		for(int i = 0;  i < 20; i++)
//			new Thread(new Producer(waitNotifyFactory)).start(); 
		
		
//		IModelFactory queue = new BlockQueueFactory(10) ;
//		
//		for(int i = 0;  i < 20; i++)
//			new Thread(new Consumer(queue)).start();
//		for(int i = 0;  i < 20; i++)
//			new Thread(new Producer(queue)).start(); 
		
		
		IModelFactory lock = new LockFactory(10) ;
		
		for(int i = 0;  i < 20; i++)
			new Thread(new Consumer(lock)).start();
		for(int i = 0;  i < 20; i++)
			new Thread(new Producer(lock)).start(); 
		
	}

}
