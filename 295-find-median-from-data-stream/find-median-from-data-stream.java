import java.util.*;
class MedianFinder {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    public MedianFinder() {}
    
    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());

        if(maxHeap.size() > minHeap.size()) minHeap.offer(maxHeap.poll());
    }
    
    public double findMedian() {
        if(minHeap.size() > maxHeap.size()) return minHeap.peek();

        return (minHeap.peek() + maxHeap.peek() * 1.0) / 2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */