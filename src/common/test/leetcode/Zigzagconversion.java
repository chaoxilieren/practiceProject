package common.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Z形变换
 * 
 * 
 * @author aihui.huang
 *
 */
public class Zigzagconversion {

	/**
	 * 0L       6D         12R
	 * 1E    5O 7E     11I 13I 
	 * 2E 4C    8I 10H     14N 
	 * 3T       9S         15G 
	 * 
	 * @param s
	 * @param numRows
	 * @return
	 */
	public static String convert(String s, int numRows) {
		if(s == null || s.equals(""))
			return "" ;
		
		int len = s.length() ;
		
		if(len <= numRows)
			return s ;
		
		// 2个数之间的跨度
		int d = 2*numRows - 2 ;
		
		if(d <= 0) {
			return s ;
		}
		
		StringBuffer sb = new StringBuffer() ;
		
		for(int i = 0; i < numRows; i++) {
			
			// 首行和尾行只有一个起始点，其他的则有2个
			int st1 = 0, st2 = 0;
			for(int j = i; j < len; j = j + d) {
				// 第一行和最后一行
				if (i == 0 || i == numRows - 1) {
					sb.append(s.charAt(j)) ;
				}else {
					int count = j/d ;
					if(count == 0) {
						st1 = j ;
						st2 = d - j ;
					}
					
					int in1 = st1 + count*d ;
					int in2 = st2 + count*d ;
					
					if (in1 < len) {
						sb.append(s.charAt(in1)) ;
					}
					if(in2 < len) {
						sb.append(s.charAt(in2)) ;
					}
				}
			}
		}
		
		return sb.toString() ;
	}
	
	
	public static String convert1(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(convert1("LEETCODEISHIRING", 3));
	}

}
