package amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams49 {
	
	// genhash is in theory faster than sort string
	// genhash O(n) = O(n*m)
    public List<List<String>> groupAnagrams(String[] strs) {
    	Map<String, List<String>> map = new HashMap<>();
    	for (String s : strs) {
    		String hash = genHash(s);
    		map.putIfAbsent(hash, new ArrayList<>());
    		map.get(hash).add(s);
    	}
    	List<List<String>> result = new ArrayList<>();
    	for(Map.Entry<String, List<String>> entry : map.entrySet()) {
    		result.add(entry.getValue());
    	}
    	return result;
        
    }
    

	private String genHash(String s) {
		if (s.isEmpty()) return "";				
		int[] hash = new int[127];
		for (char c : s.toCharArray()) {
			hash[c - 'a']++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 127; i++) {
			if (hash[i] > 0) {
				sb.append((char)(i + 'a')).append(hash[i]);
			}
		}
		return sb.toString();
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
