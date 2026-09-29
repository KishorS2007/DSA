class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";

        int[] freq = new int[128];
        for(char i : t.toCharArray()) freq[i]++;
        int[] lr = new int[]{0,s.length()};

        int l = 0 , needed = t.length();
        for(int r = 0 ; r < s.length() ; r++){
            char c = s.charAt(r);

            if(freq[c] > 0) needed--;
            freq[c]--;

            if(needed == 0){
                while(true){
                    char startC = s.charAt(l);
                    if(freq[startC] == 0) break;

                    freq[startC]++;
                    l++;
                }

                if(r - l < lr[1] - lr[0]){
                    lr[0] = l;
                    lr[1] = r;
                }
            }
        }

        return lr[1] == s.length() ? "" : s.substring(lr[0],lr[1]+1);
    }
}