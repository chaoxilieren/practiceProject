package common.test;

import java.util.ArrayList;
import java.util.List;

public class ArrayListSizeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> _listDef = new ArrayList<String>() ;
		List<String> _listUserDef = new ArrayList<String>(17) ;
		System.out.println(_listDef.size());
		System.out.println(_listUserDef.size());
	}

}
