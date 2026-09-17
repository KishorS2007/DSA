class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        final int n = nums.size();
        int l = 0;
        long sum = 0 , max = 0;
        Map<Integer,Integer> freq = new HashMap<>();

        for(int i = 0 ; i < k ; i++){
            int num = nums.get(i);
            sum += num;
            freq.put(num,freq.getOrDefault(num,0)+1);
        }

        if(freq.size() >= m)max = Math.max(max , sum);

        for(int r = k ; r < n ; r++){
            freq.put(nums.get(l),freq.get(nums.get(l))-1);
            if(freq.get(nums.get(l)) == 0) freq.remove(nums.get(l));
            sum -= nums.get(l);
            l++;

            freq.put(nums.get(r),freq.getOrDefault(nums.get(r),0)+1);
            sum += nums.get(r);
            if(freq.size() >= m)max = Math.max(max , sum);
        }

        return max;
    }
}