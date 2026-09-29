import java.util.*;
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return count(nums , k) - count(nums , k-1);
    }

    private int count(int[] nums , int k){
        if(k <= 0) return 0;
        int l = 0 , count = 0;
        Map<Integer,Integer> freq = new HashMap<>();

        for(int r = 0 ; r < nums.length ; r++){
            freq.put(nums[r] , freq.getOrDefault(nums[r] , 0) + 1);

            while(freq.size() > k){
                freq.put(nums[l] , freq.get(nums[l]) - 1);
               
                if(freq.get(nums[l]) == 0) freq.remove(nums[l]);
               
                l++;
            }

            count += r - l + 1;
        }

        return count;
    }
}