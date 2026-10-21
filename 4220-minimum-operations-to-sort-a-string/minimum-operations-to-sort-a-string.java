class Solution {
    public int minOperations(String s) {
        if(s.length() == 1) return 0;
        
        char min = 'z' , max = 'a';
        char prev = '\0';
        boolean isSorted = true;

        for(char c : s.toCharArray()){
            if(c > max) max = c;
            if(c < min) min = c;
            
            if(isSorted) 
                if(c < prev){
                    isSorted = false;
                } else {
                    prev = c;
                }
        }

        if(isSorted) return 0;
        if(s.charAt(0) == min || s.charAt(s.length() - 1) == max) return 1;
        if(s.length() == 2) return -1;
        
        for(int i = 1 ; i < s.length() - 1 ; i++){
            if(s.charAt(i) == min || s.charAt(i) == max) return 2;
        }

        return 3;
    }
}