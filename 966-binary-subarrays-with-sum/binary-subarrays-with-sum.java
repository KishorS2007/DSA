class Solution{
    private static int solve(int[] nums , int k){
        if(k < 0) return 0;
        int l = 0 , cnt = 0 , sum = 0;
        for(int r = 0 ; r < nums.length ; r++){
            sum += nums[r];

            while(sum > k){
                sum -= nums[l++];
            }

            cnt += r-l+1;
        }

        return cnt;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return solve(nums,goal) - solve(nums,goal-1);
    }
}