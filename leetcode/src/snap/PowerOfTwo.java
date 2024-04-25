package snap;

public class PowerOfTwo {

	
	
	
    public boolean isPowerOfTwo(int n) {
//    	int[] store = new int[32];
//    	store[0] = 1;
//    	for (int i = 1; i < 31; i++) {
//    		store[i] = store[i-1] * 2;
//    		if (n == store[i]) return true;
//    		System.out.println(i + ", " + store[i]);
//    	}
//        return false;
        if (n <= 0) return false;
        return (1 << 30) % n == 0;
    }
	
	
	public static void main(String[] args) {
		System.out.println(new PowerOfTwo().isPowerOfTwo(20));

	}

}
