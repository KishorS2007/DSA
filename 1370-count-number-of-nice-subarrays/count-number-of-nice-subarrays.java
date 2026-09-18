class Solution {
    private static int solve(int[] nums,int k){
        if(k < 0) return 0;
        int total = 0 , l = 0, oddCnt = 0;

        for(int r = 0 ; r < nums.length ; r++){
            if(nums[r] % 2 == 1) oddCnt++;

            while(oddCnt > k){
                oddCnt -= nums[l++] % 2 == 0 ? 0 : 1;
            }

            total += r-l+1;
        }

        return total;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return solve(nums,k) - solve(nums,k-1);
    }
}