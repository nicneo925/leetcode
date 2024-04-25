package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/plates-between-candles/description/
public class PlatesWithCandles2205 {
	
	public int[] platesBetweenCandles(String s, int[][] queries) {
        int count = 0;
        List<Integer> bars = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();    // could be just array too
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                count++;
            } else if (s.charAt(i) == '|') {
                map.put(i, count);
                bars.add(i);
            }
        }
        if (bars.size() == 0) {
            int[] result = new int[queries.length];
            Arrays.fill(result, 0);
            return result;
        }
        // TLE!
        // List<Integer> list = linear(s, queries, map);
        // BS still slow! O(n) + O(nlogm)
        // List<Integer> list = bs(s, queries, map, bars);
        // best O(n) approach
        // remember the 1st candle after(at)/before(at) each index
        List<Integer> list = mem(s, queries, map);
        int[] result = new int[list.size()];
        int index = 0;
        for (int n : list) {
            result[index++] = n;
        }
        return result;
    }

    private List<Integer> mem(String s, int[][] queries, Map<Integer, Integer> map) {
        int n = s.length();
        // index of first bar after(at) each index
        int[] left = new int[n];
        left[n - 1] = s.charAt(n - 1) == '|' ? 0 : -1;
        for (int i = n - 2; i >= 0; i--) {
            left[i] = s.charAt(i) == '|' ? i : left[i + 1];
        }
        // index of first bar before(at) each index
        int[] right = new int[n];
        right[0] = s.charAt(0) == '|' ? 0 : -1;
        for (int i = 1; i < n; i++) {
            right[i] = s.charAt(i) == '|' ? i : right[i - 1];
        }
        List<Integer> list = new ArrayList<>();
        for (int[] query : queries) {
            int l = left[query[0]];
            int r = right[query[1]];
            Integer start = map.get(l);
            Integer end = map.get(r);
            if (l > r || start == null || end == null) {
                list.add(0);
            } else {
                list.add(map.get(r) - map.get(l));
            }
        }
        return list;
    }

    List<Integer> bs(String s, int[][] queries, Map<Integer, Integer> map, List<Integer> bars) {
        List<Integer> list = new ArrayList<>();
        for (int[] query : queries) {
            int left = findPosLeft(s, query[0], bars);
            int right = findPosRight(s, query[1], bars);
            // System.out.println("left=" + left + ", right=" + right);
            if (right >= left && map.containsKey(left) && map.containsKey(right))
                list.add(map.get(right) - map.get(left));
            else
                list.add(0);
        }
        return list;
    }

    private int findPosLeft(String s, int target, List<Integer> bars) {
        int l = 0, r = bars.size() - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (bars.get(mid) >= target) {
                r = mid;
            } else {
                l = mid;
            }
        }
        if (bars.get(l) >= target) {
            return bars.get(l);
        } else {
            return bars.get(r);
        }
    }

    private int findPosRight(String s, int target, List<Integer> bars) {
        int l = 0, r = bars.size() - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (bars.get(mid) <= target) {
                l = mid;
            } else {
                r = mid;
            }
        }
        if (bars.get(r) <= target) {
            return bars.get(r);
        } else {
            return bars.get(l);
        }
    }

    List<Integer> linear(String s, int[][] queries, Map<Integer, Integer> map) {
        List<Integer> list = new ArrayList<>();
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            while (left < s.length() && s.charAt(left) != '|') {
                left++;
            }
            while (right > left && s.charAt(right) != '|') {
                right--;
            }
            if (right < left)
                list.add(0);
            else
                list.add(map.get(right) - map.get(left));
        }
        return list;
    }
	
	

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new PlatesWithCandles2205().platesBetweenCandles("**|**|***|", new int[][] {{2,5},{5,9}})));

	}

}
