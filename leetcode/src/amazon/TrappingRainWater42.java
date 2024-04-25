package amazon;

// https://leetcode.com/problems/trapping-rain-water/description/
// O(n) time, O(1) space
// two pointer
public class TrappingRainWater42 {
	
    public int trap(int[] height) {
    	int i = 0, left_max = height[0], sum = 0;
    	int j = height.length - 1, right_max = height[j];
        while(i < j) {
        	if (left_max <= right_max) {
        		sum += left_max - height[i];
        		i++;
        		left_max = Math.max(left_max, height[i]);
        	} else {
        		sum += right_max - height[j];
        		j--;
        		right_max=Math.max(right_max, height[j]);
        	}
        }
        return sum;
    }
    
    public static void main(String[] args) {
    	System.out.println(new TrappingRainWater42().trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
