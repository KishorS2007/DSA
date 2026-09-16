import java.util.*;
class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxFreq = 0 , l = 0 , maxLen = 0;

        for(int r = 0 ; r < s.length() ; r++){
            char c = s.charAt(r);
            maxFreq = Math.max(maxFreq,++freq[c-'A']);

            while(r - l + 1 - maxFreq > k){
                freq[s.charAt(l)-'A']--;
                l++;
            }

            maxLen = Math.max(maxLen , r-l+1);
        }

        return maxLen;
    }
}