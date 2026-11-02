import java.util.*;
class Solution {
    public int minMoves2(int[] nums) {
        final int n = nums.length;
        Arrays.sort(nums);

        int median = nums[n / 2 + (n % 2 == 0 ? -1 : 0)];

        int moves = 0;
        for(int i : nums) moves += Math.abs(median-i);

        return moves;
    }
}