class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        final int n = nums.length;
        long[] prefix = new long[n] , suffix = new long[n];
        int[] ans = new int[n];

        prefix[0] = nums[0];
        for(int i = 1 ; i < n ; i++) prefix[i] = nums[i] + prefix[i-1];

        suffix[n - 1] = nums[n - 1];
        for(int i = n - 2 ; i >= 0 ; i--) suffix[i] = nums[i] + suffix[i + 1];

        for(int i = 0 ; i < nums.length ; i++){
            ans[i] = (int) Math.abs(prefix[i] - (i + 1) * nums[i]);
            ans[i] += (int) (suffix[i] - (n - i) * nums[i]);
        }

        return ans;
    }
}