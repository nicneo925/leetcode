package snap;

public class LongestSubstringWithAtLeastKRepeatingCharacters {

	
	// O(n)
    public int longestSubstring(String s, int k) {
        // write your code here
        if (s == null || s.length() == 0 || k > s.length()) return 0;
    	
        int[] counts = new int[26];
        char[] sArr = s.toCharArray();
        for (char c : sArr) {
            counts[c - 'a']++;
        }
        
        if (valid(counts, k)) return s.length();
        
        int left = 0, res = 0;
        // find the segments positions with freq < k
        for (int right = 0; right < s.length(); ++right) {
            if (counts[sArr[right] - 'a'] < k && counts[sArr[right] - 'a'] > 0) {
            	// max len of string on the left
                res = Math.max(res, longestSubstring(s.substring(left, right), k));
                left = right + 1;
            }
        }
        // last segment
        res = Math.max(res, longestSubstring(s.substring(left, s.length()), k));
        return res;
    }
	
    // O(26)
    private boolean valid(int[] counts, int k) {
        for (int i = 0; i < 26; ++i) {
            if (counts[i] > 0 && counts[i] < k) {
            	return false;
            }
        }
        return true;
    }
    
	
	public static void main(String[] args) {
		System.out.println(new LongestSubstringWithAtLeastKRepeatingCharacters().longestSubstring("bbaaacbd", 3));

	}

}
