package snap;

import java.util.Collections;
import java.util.PriorityQueue;

// https://leetcode.com/problems/minimum-number-of-refueling-stops/description/
public class MinimumNumberOfRefuelingStops {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
    	// DP: O(n2)
        int n = stations.length;
        // max reach on each position
        int[] dp = new int[n + 1];
        dp[0] = startFuel;
        // each time there is a new gas station, update max miles considering current max with adding gas at that station 
        for (int i = 0; i < n; i++) {
            for (int j = i; j >=0; j--) {
            	if (dp[j] >= stations[i][0]) {
            		dp[j+1] = Math.max(dp[j+1], dp[j] + stations[i][1]);
            	}
            }
        }
        for (int i = 0; i <= n; i++) {
            if (dp[i] >= target) {
            	return i;
            }
        }
        return -1;

    }
    
    
    public int minRefuelStopsPQ(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> stationsInRange = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;
        int range = startFuel;
        int stops = 0;
        while (range < target) {
            while (i < stations.length && stations[i][0] <= range) {
                stationsInRange.offer(stations[i++][1]);
            }
            if (stationsInRange.isEmpty()) {
                return -1;
            }
            range += stationsInRange.poll();
            stops++;
        }
        return stops;
    }
    
	
	public static void main(String[] args) {
		System.out.println(new MinimumNumberOfRefuelingStops().minRefuelStopsPQ(100, 10, new int[][] {{10,60},{20,30},{30,30},{60,40}}));

	}

}
