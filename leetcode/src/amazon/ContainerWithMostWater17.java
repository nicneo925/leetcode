package amazon;

public class ContainerWithMostWater17 {
	
	
    public int maxArea(int[] height) {
        // brute force: iterate all pairs and calculate max water = len * min(bar1, bar2);
        // one pass with two pointers? 
        int l = 0, r = height.length - 1;
        int maxArea = 0;
        while(l < r) {
        	maxArea = Math.max(maxArea, (r - l) * Math.min(height[l], height[r]));
        	if (height[l] <= height[r]) {
        		l++;
        	} else {
        		r--;
        	}
        }
        return maxArea;
        
    }

	public static void main(String[] args) {
		System.out.println(new ContainerWithMostWater17().maxArea(new int[] {1,8,6,2,5,4,8,3,7}));

	}

}
