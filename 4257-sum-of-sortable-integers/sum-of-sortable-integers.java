class Solution {
    public int sortableIntegers(int[] nums) {
        int sum = 0;
        for(int k = 1 ; k <= nums.length; k++){
            if(nums.length % k == 0 && sortable(nums,k)) sum += k;
        }

        return sum;
    }

    private int pivot(int a , int b){
        return a > b ? 1 : 0;
    }

    private boolean sortable(int[] nums , int k){
        int prevMin = Integer.MIN_VALUE , prevMax = prevMin;

        for(int i = 0 ; i < nums.length ; i += k){
            int currMin = Integer.MAX_VALUE , currMax = Integer.MIN_VALUE;
            int pivotCount = 0;

            for(int j = i ; j < i + k ; j++){
                if(nums[j] < currMin) currMin = nums[j];
                if(nums[j] > currMax) currMax = nums[j];

                if(j != i) pivotCount += pivot(nums[j-1] , nums[j]);
            }

            pivotCount += pivot(nums[i+k-1],nums[i]);

            if(prevMax > currMin || pivotCount > 1) return false;
            prevMin = currMin;
            prevMax = currMax;
        }

        return true;
    }
}