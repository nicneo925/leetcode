package amazon;

public class LongestPalindromicSubstring5 {
	
	
    public String longestPalindrome(String s) {
    	if (s == null || s.length() == 0) return "";
        String maxStr = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
        	String center1 = gen(s, i, i);
        	String center2 = gen(s, i, i+1);
        	if (center1.length() > maxStr.length()) {
        		maxStr = center1;
        	}
        	if (center2.length() > maxStr.length()) {
        		maxStr = center2;
        	} 
        }
        return maxStr;
        
        
    }
	

	private String gen(String s, int l, int r) {
		while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		return s.substring(l+1, r);
	}


	public static void main(String[] args) {
		System.out.println(new LongestPalindromicSubstring5().longestPalindrome("babad"));

	}

}
