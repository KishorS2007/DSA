import java.util.*;
class Solution {
    public int minSwaps(int[] nums) {
        final int n = nums.length;
        Map<Integer,Integer> numToIdx = new HashMap<>();
        int[][] sorted = new int[n][2];

        for(int i = 0 ; i < n ; i++){
            sorted[i][0] = nums[i];
            sorted[i][1] = digitSum(nums[i]);

            numToIdx.put(nums[i] , i);
        }

        Arrays.sort(sorted,(a,b)->{
            if(a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int swaps = 0;
        for(int i = 0 ; i < n ; i++){
            int currentElement = nums[i];
            int actualElement = sorted[i][0];

            if(currentElement == actualElement) continue;
            
            // Element actualElement have to be at index i in nums
            int idx = numToIdx.get(actualElement); // where is it in nums now?
           
            // swap elements
            nums[i] = actualElement;
            nums[idx] = currentElement;

            // update the position of swapped element in map
            numToIdx.put(currentElement , idx); 
            swaps++;
        }

        return swaps;
    }

    private static int digitSum(int n){
        int sum = 0;
        while(n > 0){
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}