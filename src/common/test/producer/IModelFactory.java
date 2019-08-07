package common.test.producer;

import java.util.ArrayList;
import java.util.List;

/**
 * 生产 消费 工厂
 * 
 * @author aihui.huang
 *
 */
public abstract class IModelFactory {

	private List<Object> products ;
	
	/** 最大容量 */
	private int maxCount ;
	
	public IModelFactory(int maxCount) {
		this.products = new ArrayList<Object>() ;
		this.maxCount = maxCount ;
	}
	
	
	public List<Object> getProducts() {
		return products;
	}

	public int getMaxCount() {
		return maxCount;
	}

	public int getSize() {
		return products.size() ;
	}
	
	public boolean isFull() {
		return getSize() >= maxCount ;
	}

	public abstract void produce() ;
	
	public abstract void consume() ;
	
}
