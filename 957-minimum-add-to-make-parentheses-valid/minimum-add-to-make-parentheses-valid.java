import java.util.*;
class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int invalid = 0;

        for(char i : s.toCharArray()){
            if(i == '('){
                stack.push(i);
            } else {
                if(stack.isEmpty()){
                    invalid++;
                }
                else stack.pop();
            }
        }

        return stack.size() + invalid;
    }
}