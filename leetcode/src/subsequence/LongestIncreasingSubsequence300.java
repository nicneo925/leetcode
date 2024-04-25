package subsequence;


// https://leetcode.com/problems/longest-increasing-subsequence/description/
public class LongestIncreasingSubsequence300 {

	
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int maxLen = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLen = Math.max(dp[i], maxLen);
                }
            }
        }
        return maxLen;
    }
	
	public static void main(String[] args) {
		System.out.println(new LongestIncreasingSubsequence300().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
	}

}
