class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0 , flips = 0 , maxLen = 0;

        for(int r = 0 ; r < nums.length ; r++){
            if(nums[r] == 0){
                nums[r] = -1;
                flips++;
            }

            while(flips > k){
                if(nums[l] == -1){
                    nums[l] = 0;
                    flips--;
                }
                l++;
            }

            maxLen = Math.max(r-l+1,maxLen);
        }

        return maxLen;
    }
}