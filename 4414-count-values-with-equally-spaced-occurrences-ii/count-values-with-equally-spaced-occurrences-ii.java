import java.util.*;
class Solution {
    private class Box{
        int prevIdx , freq , diff;

        public Box(int prevIdx , int freq , int diff){
            this.prevIdx = prevIdx;
            this.freq = freq;
            this.diff = diff;
        }
    }

    public int countSpecialIntegers(int[] nums) {
        Map<Integer,Box> map = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i] , new Box(i,1,0));
                continue;
            }

            Box prevElement = map.get(nums[i]);
            int currDiff = i - prevElement.prevIdx;
            
            if(prevElement.diff == -1) continue; // invalidated

            if(prevElement.diff == 0){
                prevElement.diff = currDiff;
            
            } else if(prevElement.diff != currDiff){
                prevElement.diff = -1;
                continue;
            }

            prevElement.freq++;
            prevElement.prevIdx = i;
        }

        int count = 0;
        for(Box i : map.values()){
            if(i.freq >= 3 && i.diff != -1) count++;
        }

        return count;
    }
}