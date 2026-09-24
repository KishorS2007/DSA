class Solution {
    public int minOperations(int[] nums, int x) {
        long target = -x;
        for(int i : nums) target += i;

        if(target < 0) return -1;
        if(target == 0) return nums.length;

        int l = 0 , maxLen = 0, sum = 0;

        for(int r = 0 ; r < nums.length ; r++){
            sum += nums[r];
            while(sum > target) sum -= nums[l++];

            if(sum == target) maxLen = Math.max(maxLen , r - l + 1); 
        }

        return maxLen != 0 ? nums.length - maxLen : -1;
    }
}