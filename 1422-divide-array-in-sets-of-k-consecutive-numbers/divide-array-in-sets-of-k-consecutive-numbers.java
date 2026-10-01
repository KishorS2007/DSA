class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int i : nums) freq.put(i,freq.getOrDefault(i,0)+1);

        PriorityQueue<int[]> q = new PriorityQueue<int[]>(
            (a,b) -> a[0] - b[0]
        );

        for(Map.Entry<Integer,Integer> entry : freq.entrySet()){
            q.offer(new int[]{entry.getKey() , entry.getValue()});
        }

        while(!q.isEmpty()){
            int size = q.size();
            if(size < k) return false;

            List<int[]> temp = new ArrayList<>();
            int prev = -1;
            for(int i = 0 ; i < k ; i++){
                int[] curr = q.poll();
                curr[1]--;

                if(prev != -1 && prev != curr[0] - 1) return false;
                prev = curr[0];

                if(curr[1] > 0) temp.add(curr);
            }

            for(var i : temp) q.offer(i);
        }

        return true;
    }
}