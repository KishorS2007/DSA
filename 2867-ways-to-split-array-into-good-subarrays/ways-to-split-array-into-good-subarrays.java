class Solution {
    private final int MOD = (int) 1e9 + 7;
    public int numberOfGoodSubarraySplits(int[] nums) {
        final int n = nums.length;
        int l = 0;
        long cnt = 0 , ans = 1;

        while(l < n && nums[l] == 0) l++;

        if(l < n) cnt++;
        else return 0;

        for(int r = l+1 ; r < n ; r++){
            while(r < n && nums[r] == 0) r++;

            if(r < n && nums[r] == 1){
                ans = ((ans % MOD) * (r - l) % MOD) % MOD;
                l = r;
            }
        }

        return (int)ans;
    }
}