package amazon;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;

        // 这里注意是遍历到n，因为要保证栈里的元素都被处理一下
        for (int i = 0; i <= n; i++) {
            int curr = i == n ? -1 : heights[i];
            while (!stack.isEmpty() && curr <= heights[stack.peek()]) {
                int h = heights[stack.peek()];
                stack.pop();
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }

        return max;
    }
	
	public static void main(String[] args) {
		new LargestRectangleInHistogram().largestRectangleArea(new int[] {2,1,5,6,2,3});

	}

}
