class Solution {
    int n , m;
    private boolean isword1Largest(String s,int i,String t,int j){
        while(i < n && j < m && s.charAt(i) == t.charAt(j)){
            i++;
            j++;
        }

        // t is big
        if(i == n || (j < m && s.charAt(i) < t.charAt(j))) return false;

        return true; // s is big
    }
    public String largestMerge(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        n = word1.length();
        m = word2.length();

        int i = 0 , j = 0;

        while(i < n && j < m){
            if(isword1Largest(word1,i,word2,j)){
                sb.append(word1.charAt(i));
                i++;
            } else {
                sb.append(word2.charAt(j));
                j++;
            }
        }

        if(i < n) sb.append(word1.substring(i,n));
        else if(j < m) sb.append(word2.substring(j,m));

        return sb.toString();
    }
}