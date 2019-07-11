package common.test.myhashmap;

public class MyHashMapTest {

	public static void main(String[] args) {
		MyHashMap<Integer, Integer> map = new MyHashMap<>() ;
		
		for(int i = 0; i < 20; i++) {
			map.put(i, i) ;
		}
		
		map.put(null, 112) ;
		map.put(null, 122) ;
		
		System.out.println(map.get(null));
	}

}
