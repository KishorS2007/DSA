class Solution {
    public int countStaircase(int[] nums) {
        final int n = nums.length;
        int count = 0;

        for(int i = 0 ; i < n ; i++){
            Map<Integer,Integer> freq = new HashMap<>();
            List<Integer> numbers = new ArrayList<>();            

            for(int j = i ; j < n ; j++){
                if(freq.containsKey(nums[j])){
                    freq.put(nums[j],freq.get(nums[j])+1);
                } else {
                    numbers.add(nums[j]);
                    freq.put(nums[j],1);
                }

                boolean isValid = true;
                for(int k = 0 ; k < numbers.size() ; k++){
                    if(freq.get(numbers.get(k)) != k+1){
                        isValid = false;
                        break;
                    }
                }

                if(isValid) count++;
            }
        }

        return count;
    }
}