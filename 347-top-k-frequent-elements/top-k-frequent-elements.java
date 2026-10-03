import java.util.*;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums) map.merge(i,1,Integer::sum);

        int[] ans = new int[k];
        PriorityQueue<Map.Entry<Integer,Integer>> q = new PriorityQueue<Map.Entry<Integer,Integer>>(
            (a,b) -> Integer.compare(a.getValue() , b.getValue())
        );

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            q.offer(entry);
            if(q.size() > k) q.poll();
        }
        
        for(int i = 0 ; i < k ; i++){
            ans[i] = q.poll().getKey();
        }

        return ans;
    }
}