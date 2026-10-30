import java.util.*;
class Solution {
    private final int original[] , n;
    private static final Random rand = new Random();
    int[] nums;

    public Solution(int[] nums) {
        original = nums;
        this.nums = nums.clone();
        n = nums.length;
    }
    
    public int[] reset() {
        System.arraycopy(original,0,nums,0,n);
        return nums;
    }
    
    public int[] shuffle() {
        for(int i = n - 1 ; i >= 0 ; i--){
            swap(nums , i , rand.nextInt(i+1));
        }

        return nums;
    }

    private static final void swap(int[] nums , int x,int y){
        nums[x] = nums[y] + (nums[y] = nums[x]) - nums[x];
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */