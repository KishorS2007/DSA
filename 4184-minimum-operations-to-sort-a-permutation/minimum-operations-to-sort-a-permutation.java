class Solution {
    public int minOperations(int[] nums) {
        final int n = nums.length;
        if(n == 1) return 0;
        
        // forward pivot check;
        int forwardPivotCount = 0 , pivotIdx = -1;
        
        if(nums[n-1] > nums[0]){
            forwardPivotCount++;
            pivotIdx = n-1; 
        }

        for(int i = 0 ; i < n - 1 ; i++){
            if(nums[i] > nums[i+1]){
                forwardPivotCount++;
                if(forwardPivotCount > 1) break;
                pivotIdx = i;
            }
        }

        if(forwardPivotCount == 1){
            if(pivotIdx == n-1) return 0;

            int leftElements = pivotIdx + 1;
            return Math.min(
                leftElements , // left rotate
                n - leftElements + 2 // n - leftElements -> right most elements
                                    // +2 -> two rotations
            );
        }
    

        // reverse pivot check;
        int reversePivotCount = 0 , rpivotIdx = -1;
        if(nums[0] > nums[n-1]){
            reversePivotCount++;
            rpivotIdx = 0;
        }

        for(int i = n-1 ; i > 0 ; i--){
            if(nums[i] > nums[i-1]){
                reversePivotCount++;
                if(reversePivotCount > 1) break;
                rpivotIdx = i;
            }
        }

        // System.out.println(forwardPivotCount+" "+reversePivotCount);
        // System.out.println(pivotIdx+" "+rpivotIdx);

        if(reversePivotCount == 1){
            if(rpivotIdx == 0) return 1; // reversing cost

            int rightElements = n - rpivotIdx;
            return Math.min(
                rightElements, 
                rpivotIdx
            ) + 1; // +1 for reversing cost
        }

        return -1; // no solution
    }
}