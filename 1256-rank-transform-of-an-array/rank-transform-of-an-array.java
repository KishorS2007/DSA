import java.util.*;
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int prev = Integer.MAX_VALUE , nextRank = 1;

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i:arr) q.offer(i);

        Map<Integer,Integer> map = new HashMap<>();
        while(!q.isEmpty()){
            int curr = q.poll();
        
            if(curr == prev) continue;
        
            map.put(prev = curr,nextRank++);
        }

        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}