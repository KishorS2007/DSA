class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int smallCount = 0 , targetCount = 0;
        for(int num : nums) {
            if(num == target) targetCount++;
            else if(num < target) smallCount++;
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < targetCount ; i++){
            ans.add(smallCount + i);
        }

        return ans;
    }
}