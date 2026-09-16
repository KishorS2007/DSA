import java.util.*;
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0 , cnt = 0;

        for(int r = 0 ; r < nums.length ; r++){
            sum += nums[r];

            cnt += map.getOrDefault(sum - goal , 0);

            map.put(sum , map.getOrDefault(sum,0)+1);
        }

        return cnt;
    }
}