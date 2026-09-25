import java.util.*;
class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";

        int[] freq = new int[128];
        int count = t.length() ,  l = 0;
        int[] lr = {0,Integer.MAX_VALUE};
        
        for(char i : t.toCharArray()){
            freq[i]++;
        }

        for(int r = 0 ; r < s.length() ; r++){
            char c = s.charAt(r);
            freq[c]--;

            if(freq[c] >= 0) count--;
            
            if(count == 0){
                while(true){
                    char removable = s.charAt(l);
                    if(freq[removable] == 0) break;
                    freq[removable]++;
                    l++;
                }

                if(r - l < lr[1] - lr[0]){
                    lr[0] = l;
                    lr[1] = r;
                }

                freq[s.charAt(l)]++;
                l++;
                count++;
            }
        }

        return lr[1] >= s.length() ?  "" : s.substring(lr[0],lr[1]+1);
    }
}