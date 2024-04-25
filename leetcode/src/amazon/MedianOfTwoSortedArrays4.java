package amazon;

public class MedianOfTwoSortedArrays4 {
	
	
	    public double findMedianSortedArrays(int[] a, int[] b) {
	    	if (a == null || b == null) return 0d;
	    	
	    	int n = a.length + b.length;
	    	return n % 2 == 0 ? (findKth(a, 0, b, 0, n / 2) + findKth(a, 0, b, 0, n / 2 + 1) ) / 2.0 : findKth(a, 0, b, 0, n/2 + 1);
	    }
		
	    // find kth(not index k) kth = index + 1, kth element is the [k-1] element
	    private double findKth(int[] a, int aStart, int[] b, int bStart, int k){
	
	    	// a is exhausted so only check b
	    	// b's kth is index k - 1
	        if(aStart >= a.length){
	            return b[bStart + k - 1];
	        }
	
	    	// b is exhausted so only check a
	    	// a's kth is index k - 1
	        if(bStart >= b.length){
	            return a[aStart + k - 1];
	        }
	        
	        // first element
	        if (k == 1){
	            return Math.min(a[aStart], b[bStart]);
	        }       
	
	        // reduce a by k/2 if possible 
	        int aHalf = (aStart + k/2 > a.length) ? Integer.MAX_VALUE : a[aStart + k/2 -1];
	        // reduce b by k/2 if possible
	        int bHalf = (bStart + k/2 > b.length) ? Integer.MAX_VALUE : b[bStart + k/2 -1];
	
	        // discard k/2 from a
	        if (aHalf < bHalf){
	            return findKth(a, aStart + k/2, b, bStart, k - k/2);
	        }else {
	        	// discard k/2 from b
	        	return findKth(a, aStart, b, bStart + k/2, k - k/2);
	        }
	    }


	public static void main(String[] args) {
		System.out.println(new MedianOfTwoSortedArrays4().findMedianSortedArrays(new int[] {1,3, 5, 7, 9}, new int[] {2, 6}) );

	}

}
