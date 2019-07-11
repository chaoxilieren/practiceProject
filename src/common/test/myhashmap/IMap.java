package common.test.myhashmap;

public interface IMap<K,V> {

	public V get(Object key) ;
	
	public V put(K key, V value) ;
	
	
	public interface IEntry<K, V>{
		
		public K getKey() ; 
		
		public V getValue() ;
		
	}
}
