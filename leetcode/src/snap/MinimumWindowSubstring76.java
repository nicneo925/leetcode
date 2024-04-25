package snap;

public class MinimumWindowSubstring76 {

    public String minWindow(String s, String t) {
        int[] str = new int[127];
        for (char c : t.toCharArray()) {
            str[c]++;
        }
        int left = 0, right = 0, min = Integer.MAX_VALUE, minStart = 0;
        int size = t.length();
        while (right < s.length()) {
            // form a valid string
            if (str[s.charAt(right)] > 0) {
                size--;
            }
            str[s.charAt(right)]--;
            right++;
            while (size == 0) {
                if (right - left < min) {
                    min = right - left;
                    minStart = left;
                }
                str[s.charAt(left)]++;
                if (str[s.charAt(left)] > 0) {
                    size++;
                }
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + min);
    }
	
	
	public static void main(String[] args) {
		System.out.println(new MinimumWindowSubstring76().minWindow("ADOBECODEBANC", "ABC"));

	}

}
