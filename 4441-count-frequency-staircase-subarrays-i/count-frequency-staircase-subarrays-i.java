class Solution {
    public int countStaircase(int[] nums){
        final int n = nums.length;
        int count = 0;

        for(int i = 0 ; i < n ; i++){
            Map<Integer,Integer> freq = new HashMap<>();
            Map<Integer,Integer> index = new HashMap<>();
            int k = 0;
            int validCount = 0;

            for(int j = i ; j < n ; j++){
                if(freq.containsKey(nums[j])){
                    freq.put(nums[j],freq.get(nums[j])+1);
                } else {
                    freq.put(nums[j],1);
                    index.put(nums[j],k++);
                }

                if(freq.get(nums[j]) == index.get(nums[j]) + 1){
                    validCount++;
                } else if(freq.get(nums[j]) > index.get(nums[j]) + 1) break;
                
                if(validCount == k) count++;
            }
        }

        return count;
    }
}