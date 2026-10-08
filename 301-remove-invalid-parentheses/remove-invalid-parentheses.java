class Solution {
    Set<String> valid = new HashSet<>();
    int maxLen = 0;
    String s;

    public List<String> removeInvalidParentheses(String s) {
        this.s = s;
        /* int open = 0 , close = 0;

        for(char i : s.toCharArray()){
            if(i == '(') open++;
            else close++;
        }

        char target = '\0';

        if(open > close) target = '(';
        else if(open < close) target = ')'; */

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
        solve(i+1 , sb , open);
    }
    /* private void solve(int i , StringBuilder sb , char target , int open){
        if(open < 0) return;
        if(i == s.length()){
            if(open == 0) valid.add(sb.toString());
            return;
        }

        char c = s.charAt(i);

        // take;
        sb.append(c);
        int newOpen = c == '(' ? 1 : c == ')' ? -1 : 0;
        solve(i+1,sb,target,open + newOpen);
        sb.setLength(sb.length()-1);


        // dont take;
        if(c == target){
            solve(i+1 , sb , target , open);
        }

        // remove invalids
        if(open + newOpen < 0 && c != target){
            solve(i+1 , sb , target , open);
        }
    } */
}