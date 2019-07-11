package common.test.myhashmap;

public class MyHashMap<K, V> implements IMap<K, V> {

	/** 默认的负载因子 */
	private static final float DEFAULT_RESIZE_FACTOR = 0.75f ;
	/** 默认的容量 */
	private static final int DEFAULT_INIT_CAPACITY = 16 ;
	
	/** 指定的负载因子 */
	private float resizeFactor ;
	/** 扩容阈值 */
	private int resizeThreshold ;
	/** 元素个数 */
	private int size ;
	/** 容量， 2的指数幂 */
	private int capacity  ;
	/** 桶集合 */
	private Entry<K,V>[] table;
	
	public MyHashMap() {
		this(DEFAULT_INIT_CAPACITY, DEFAULT_RESIZE_FACTOR) ;
	}
	
	public MyHashMap(int initCapactiy, float resizeFactor) {
		if (initCapactiy <= 0) {
			throw new IllegalArgumentException("initCapactiy is error") ;
		}
		
		if(resizeFactor <= 0f) {
			throw new IllegalArgumentException("resizeFactor is error") ;
		}
		
		capacity = 1 ;
		// 初始化capacity
		while(capacity < initCapactiy) {
			capacity = capacity << 1 ;
		}
		this.resizeFactor = resizeFactor ;
		this.resizeThreshold = (int)(capacity * resizeFactor) ;
		table = new Entry[capacity] ;
	}
	
	
	@Override
	public V get(Object key) {
		if(null == key) {
			return getForNullKey() ;
		}
		
		int hash = hash(key) ;
		int tableIndex = getTableIndex(hash) ;
		
		for(Entry<K,V> e = table[tableIndex] ; e != null ; e = e.next) {
			Object k;
			if(e.hash == hash && ((k = e.getKey()) == key || key.equals(k))) {
				return e.getValue() ;
			}
		}
		
		return null;
	}
	
	@Override
	public V put(K key, V value) {
		if (null == key) {
			return putNullKey(value) ;
		}
		
		// 先找原来是否有相同key的
		int hash = hash(key) ;
		int tableIndex = getTableIndex(hash) ;

		for(Entry<K,V> e = table[tableIndex] ; e != null ; e = e.next) {
			Object k ;
			if(e.hash == hash && ((k = e.getKey()) == key || key.equals(k))) {
				V old = e.value ;
				e.value = value ;
				
				return old ;
			}
				
		}
		
		addEntry(tableIndex, hash, key, value);
		
		return null;
	}
	
	public int size() {
		return size ;
	}
	
	private V getForNullKey() {
		// null key 放在第一个table
		Entry<K, V> e = table[0] ;
		
		while(e != null) {
			if(null == e.getKey()) {
				return e.getValue() ;
			}
			e = e.next ;
		}
		
		return null ;
	}
	
	private V putNullKey(V value) {
		// 放之前先检查是否有null key
		Entry<K, V> e = table[0] ;
		
		while(e != null) {
			if(null == e.getKey()) {
				V old = e.getValue() ;
				e.value = value ;
				return old ;
			}
			e = e.next ;
		}
		
		addEntry(0, 0, null, value);
		
		return null ;
	}
	
	private void addEntry(int tableIndex, int hash, K key, V value) {
		if(size >= resizeThreshold && table[tableIndex] != null) {
			// 扩容
			resize();
			// 重新计算要放到哪个tableindex
			tableIndex = getTableIndex(hash) ;
		}
		
		createEntry(tableIndex, hash, key, value);
	}
	
	private void createEntry(int tableIndex, int hash, K key, V value) {
		Entry<K,V> old = table[tableIndex] ;
		table[tableIndex] = new Entry<K, V>(hash, key, value, old) ;
				
		size ++ ;
	}
	
	private void resize() {
		// 翻倍
		this.capacity = capacity * 2 ;
		Entry<K,V>[] newTable = new Entry[capacity] ;
		this.resizeThreshold = (int)(this.capacity * resizeFactor) ;
		
		// 数据复制
		for(int i = 0; i < table.length; i++) {
			for(Entry<K,V> e = table[i] ; e != null ; e = e.next) {
				int hash = hash(e.getKey()) ;
				
				int tableIndex = getTableIndex(hash) ;
				Entry<K,V> old = newTable[tableIndex] ;
				newTable[tableIndex] = new Entry<K, V>(hash, e.getKey(), e.getValue(), old) ;
			}
		}
		
		table = newTable ;
	}
	
	private int hash(Object key) {
		int h ;
		return key == null ? 0 :(h = key.hashCode()) ^ h >>> 16 ; 
	}
	
	private int getTableIndex(int hash) {
		return hash & (capacity - 1) ;
	}
	
	static class Entry<K,V> implements IEntry<K, V>{

		private int hash ;
		
		private K key ;
		
		private V value ;
		
		private Entry<K,V> next ;
		
		public Entry(int hash, K key, V value, Entry<K,V> next) {
			this.hash = hash ;
			this.key = key ;
			this.value = value ;
			this.next = next ;
		}
		
		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}

		public int getHash() {
			return hash;
		}

		public Entry<K,V> getNext() {
			return next;
		}
		
	}

}
