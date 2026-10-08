class Solution {
    Set<String> valid = new HashSet<>();
    int maxLen = 0;
    String s;

    public List<String> removeInvalidParentheses(String s) {
        this.s = s;
        solve(0 , new StringBuilder() , 0); 

        List<String> ans = new ArrayList<>();
        for(String i : valid){
            if(i.length() == maxLen) ans.add(i);
        }

        if(ans.isEmpty()) ans.add("");
        return ans;
    }
    private void solve(int i , StringBuilder sb , int open){
        if(open < 0) return;
        if(i == s.length()){
            if(open == 0){
                valid.add(sb.toString());
                maxLen = Math.max(maxLen,sb.length());
            }
            return;
        }

        // take
        char c = s.charAt(i);
        sb.append(c);
        int newOpen = c == '(' ? 1 : c == ')' ? -1 : 0;
        solve(i+1,sb,open + newOpen);
        sb.setLength(sb.length()-1);

        // dont take
        if(c == '(' || c == ')')
            solve(i+1 , sb , open);
    }
}