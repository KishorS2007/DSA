import java.util.*;
class Solution {
    public long maxAlternatingSum(int[] nums) {
        final int n = nums.length;
        for(int i = 0 ; i < n ; i++) if(nums[i] < 0) nums[i] *= -1;

        Arrays.sort(nums);
        int l = 0 , r = n - 1;

        long ans = 0;
        while(l <= r){
            ans += nums[r] * nums[r];
            r--;

            if(r >= l){
                ans -= nums[l] * nums[l];
                l++;
            }
        }

        return ans;
    }
}