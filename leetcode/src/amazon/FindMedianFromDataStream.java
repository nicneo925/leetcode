package amazon;

import java.util.PriorityQueue;

public class FindMedianFromDataStream {

	// biggest at head
    private PriorityQueue<Integer> small;
    // smallest at head
    private PriorityQueue<Integer> big;

    public FindMedianFromDataStream() {
        small = new PriorityQueue<>((a, b) -> (b - a));
        big = new PriorityQueue<>((a, b) -> (a - b));
    }

    public void addNum(int num) {
        // small numbers go to maxHeap, big numbers go to minHeap
        // then re-balance
        // always keep that small size is same or +1 of big
        if (small.isEmpty() || num <= small.peek()) {
            small.offer(num);
            if (small.size() > big.size() + 1) {
                big.offer(small.poll());
            }
        } else {
            big.offer(num);
            if (big.size() > small.size()) {
                small.offer(big.poll());
            }
        }
    }

    public double findMedian() {
        // median is the head of both heaps
        if (big.size() == small.size()) {
            return (big.peek() + small.peek()) / 2.0;
        } else {
            return small.peek();
        }
    }
	
	
	public static void main(String[] args) {
		FindMedianFromDataStream f = new FindMedianFromDataStream();
		f.addNum(1);
		f.addNum(2);
		f.addNum(3);
		System.out.println(f.findMedian());
	}

}
