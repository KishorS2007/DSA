class Solution {
    public int repeatedStringMatch(String a, String b) {
        final int n = a.length() , m = b.length();
        int minRepeat = (n+m-1) / n;

        for(int i = 0 ; i < minRepeat + 2 ; i++){
            String repeated = a.repeat(i);
            if(repeated.contains(b)) return i;
        }

        return -1;
    }
}