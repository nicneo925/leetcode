package amazon;

import java.util.Arrays;
import java.util.Stack;

// https://leetcode.com/problems/sum-of-total-strength-of-wizards/description/
public class SumOfTotalStrengthOfWizards2281 {

	private static final int MOD = 1_000_000_007;

	public int totalStrength(int[] strength) {
		int n = strength.length;
		long[] preSum = new long[n + 1];
		long[] prePrefix = new long[n + 2];
		for (int i = 0; i < n; i++) {
			preSum[i + 1] = (preSum[i] + strength[i]) % MOD;
		}
		for (int i = 0; i <= n; i++) {
			prePrefix[i + 1] = (prePrefix[i] + preSum[i]) % MOD;
		}
		// mono stack
		Stack<Integer> st = new Stack<>();
		int[] left = new int[n];
		int[] right = new int[n];
		Arrays.fill(left, -1);
		// mono rising stack
		for (int i = 0; i < n; i++) {
			while (!st.isEmpty() && strength[st.peek()] >= strength[i]) {
				st.pop();
			}
			if (st.isEmpty()) {
				left[i] = -1;
			} else {
				left[i] = st.peek();
			}
			st.push(i);
		}
		st.clear();
		Arrays.fill(right, n);
		for (int i = n - 1; i >= 0; i--) {
			while (!st.empty() && strength[st.peek()] > strength[i]) {
				st.pop();
			}
			if (st.empty())
				right[i] = n;
			else
				right[i] = st.peek();

			st.push(i);
		}
		long res = 0;
		for (int i = 0; i < n; i++) {
			int l = left[i];
			int r = right[i];
			long part1 = (prePrefix[r + 1] - prePrefix[i + 1]) * (i - l) % MOD;
			long part2 = (prePrefix[i + 1] - prePrefix[l + 1]) * (r - i) % MOD;
			long product = (part1 - part2) % MOD;
			if (product < 0) {
				product += MOD;
			}
			res = (res + (product * strength[i]) % MOD) % MOD;
		}
		if (res < 0) {
			res += MOD;
		}
		return (int) (res % MOD);
	}

	public static void main(String[] args) {
		System.out.println(new SumOfTotalStrengthOfWizards2281().totalStrength(new int[]{1,3,1,2}));

	}

}
