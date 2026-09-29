import java.util.*;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(
            (a,b) -> Integer.compare(a,b)
        );

        for(int i : nums){
            q.offer(i);
            if(q.size() > k) q.poll();
        }

        return q.poll();
    }
}