import java.util.*;
class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        final int n = nums.length;
        if(k == n) return nums;

        int[] ans = new int[k];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            int num = nums[i];
            if(stack.size() == k && num > stack.peek()) continue;

            while(!stack.isEmpty() && (stack.size() + (n - i - 1)) >= k && stack.peek() > num) stack.pop();
            stack.push(num);
        }

        for(int i = k - 1 ; i >= 0 ; i--) ans[i] = stack.pop();

        return ans;
    }
}