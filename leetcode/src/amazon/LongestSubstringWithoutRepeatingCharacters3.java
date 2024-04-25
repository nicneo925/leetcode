package amazon;

public class LongestSubstringWithoutRepeatingCharacters3 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        if (s.length() == 1)
            return 1;
        // sliding window
        boolean[] chars = new boolean[127];
        int l = 0, r = 1;
        chars[s.charAt(0)] = true;
        int max = 1;
        while (r < s.length()) {
            while (r < s.length() && !chars[s.charAt(r)]) {
                max = Math.max(max, r - l + 1);
                chars[s.charAt(r)] = true;
                r++;
            }
            while (r < s.length() && chars[s.charAt(r)]) {
                chars[s.charAt(l)] = false;
                l++;
            }
        }
        return max;
    }
	
	
	public static void main(String[] args) {
		System.out.println(new LongestSubstringWithoutRepeatingCharacters3().lengthOfLongestSubstring("abcabcbb"));
//		assert new LongestSubstringWithoutRepeatingCharacters3().lengthOfLongestSubstring("abcabcbb") == 3;
	}

}
