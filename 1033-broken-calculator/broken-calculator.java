class Solution {
    public int brokenCalc(int val, int target) {
        int operations = 0;
        while(val < target){

            if(target % 2 == 0) target /= 2;
            else target++;

            operations++;
        }

        return operations + val - target;
       
    }
}