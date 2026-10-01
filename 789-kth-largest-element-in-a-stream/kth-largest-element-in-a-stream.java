import java.util.*;
class KthLargest {
    PriorityQueue<Integer> q = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;

        for(int i : nums){
            q.offer(i);
            if(q.size() > k) q.poll();
        }
    }
    
    public int add(int val) {
        q.offer(val);
        if(q.size() > k) q.poll();

        return q.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */