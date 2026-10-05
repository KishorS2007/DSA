class Solution {
    String s;
    private int[] solve(int idx){
        int score = 0;
        while(idx < s.length()){
            char c = s.charAt(idx);

            if(c == '('){
                int[] temp = solve(idx+1);
                score += temp[0];
                idx = temp[1];

            } else break;
        }

        return new int[]{score == 0 ? 1 : score * 2 , idx + 1};
    }
    public int scoreOfParentheses(String s) {
        this.s = s;
        int score = 0 , i = 0;
        while(i < s.length()){
            int[] temp = solve(i);
            score += temp[0];
            i = temp[1];
        }

        return score / 2;
    }
}