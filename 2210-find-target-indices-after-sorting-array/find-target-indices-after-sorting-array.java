class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int[] freq = new int[101];
        List<Integer> ans = new ArrayList<>();

        for(int i : nums) freq[i]++;
        
        int sortedIdx = 0;
        for(int i = 1 ; i <= 100 ; i++){
            if(freq[i] == 0) continue;

            if(i == target){
                for(int j = 0 ; j < freq[i] ; j++){
                    ans.add(sortedIdx + j);
                }

                break;
            }

            sortedIdx += freq[i];
        }

        return ans;
    }
}