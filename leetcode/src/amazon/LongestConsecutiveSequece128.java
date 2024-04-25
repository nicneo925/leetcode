package amazon;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-consecutive-sequence/
public class LongestConsecutiveSequece128 {

	// O(n^2)
	public int longestConsecutive(int[] nums) {
		int maxLen = 0;
	  Set<Integer> set = new HashSet<Integer>();
        for (int n : nums) {
            set.add(n);
        }
		for (int n : set) {
			if (!set.contains(n-1)) {
				int len = getMaxLen(n, set);
				maxLen = Math.max(len, maxLen);
			}
		}
		return maxLen;
    }
	
	
	private int getMaxLen(int start, Set<Integer> set) {
		int len = 0;
		while(set.contains(start)) {
			len++;
			start++;
		}
		return len;
	}


	public static void main(String[] args) {
		System.out.println(new LongestConsecutiveSequece128().longestConsecutive(new int[] {9,1,4,7,3,-1,0,5,8,-1,6}));

	}

}
