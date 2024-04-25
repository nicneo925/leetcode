package amazon;

public class LongestIncreasingSubsequence300 {
	
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
    	return dp(nums);
        
    }
	

    // O(n)
	private int dp(int[] nums) {
		int max = 1;
		// dp[i] == longest subsequence ending with i
		int[] dp = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}


	public static void main(String[] args) {
		System.out.println(new LongestIncreasingSubsequence300().lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));

	}

}
