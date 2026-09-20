class Solution {
    public int reverseDegree(String s) {
        int total = 0;
        for(int i = 0 ; i < s.length() ; i++){
            total += (26 - (s.charAt(i)-'a')) * (i+1);
        }

        return total;
    }
}