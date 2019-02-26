package common.test.findmedian;

/**
 * 最大回文子串，动态回归法
 * 
 * @author aihui.huang
 *
 */
class LongestPalindrome {
	
	public String longestPalindrome(String s) {
        if(s == null || s.equals("")){
            return "" ;
        }
        
        int len = s.length() ;
        
        if(len == 1)
            return s ;
        
        // 记录最大的回文左右index
        int left = 0 , right = 0 ;
        
        // dp[i][j] 记录的是索引从i到j的串是否是回文串
        boolean[][] dp = new boolean[len][len] ;
        
        for(int i = len - 2; i >= 0; i--) {
        	dp[i][i] = true ;
        	for(int j = i + 1 ; j < len; j++) {
        		int _i = i + 1 ;
        		int _j = j - 1;
        		
        		if (s.charAt(i) == s.charAt(j) && ((_j > _i && dp[_i][_j]) || _i >= _j)) {
					dp[i][j] = true ;
					
					// 更新left right
					if (j - i > right - left) {
						left = i ;
						right = j ;
					}
				}
        		
        	}
        }
        
        return s.substring(left, right + 1) ;
    }
    
    
    public static void main(String[] args) {
    	LongestPalindrome solution = new LongestPalindrome() ;
		System.out.println(solution.longestPalindrome("babad"));
	}
    
    
}