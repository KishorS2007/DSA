import java.util.*;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(
            (a,b) -> Integer.compare(b,a)
        );

        for(int i : nums) q.offer(i);

        while(k-- > 1) q.poll();

        return q.poll();
    }
}