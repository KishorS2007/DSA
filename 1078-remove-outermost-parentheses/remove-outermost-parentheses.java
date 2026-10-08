class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int level = 0;

        for(char i : s.toCharArray()){
            if(i == '('){
                level++;
                if(level != 1) sb.append(i);
            }
            else {
                if(level != 1) sb.append(i);
                level--;
            }

        }

        return sb.toString();
    }
}