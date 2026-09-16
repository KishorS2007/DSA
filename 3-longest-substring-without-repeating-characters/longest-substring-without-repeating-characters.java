class Solution {
    public int lengthOfLongestSubstring(String s) {
        int mask = 0 , l = 0 , maxLen = 0;
        boolean[] present = new boolean[128];

        for(int r = 0 ; r < s.length() ; r++){
            char c = s.charAt(r);

            while(present[c]){
                present[s.charAt(l)] = false;
                l++;
            }

            present[c] = true;
            maxLen = Math.max(maxLen , r-l+1);
        }

        return maxLen;
    }
}