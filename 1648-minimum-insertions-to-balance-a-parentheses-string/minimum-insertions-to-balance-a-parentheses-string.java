import java.util.*;
class Solution {
    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0 , closeCount = 0 , insertions = 0;

        while(i < s.length()){
            char c = s.charAt(i);
            if(c == '('){
                if(closeCount != 0){
                    if(stack.isEmpty()){
                        insertions += 2;
                    } else {
                        insertions++;
                        stack.pop();
                    }
                    
                    closeCount = 0;
                }

                stack.push(c);
            } else {
                closeCount++;
                if(closeCount == 2){
                    if(stack.isEmpty()){
                        insertions++;
                    } else {
                        stack.pop();
                    }

                    closeCount = 0;
                }
            }
            i++;
        }

        if(closeCount != 0 && !stack.isEmpty()){
            stack.pop();
            insertions++;
        
        } else if(closeCount != 0){
            insertions += 2 ;
        }

        while(!stack.isEmpty()){
            insertions += 2;
            stack.pop();
        }

        return insertions;
    }
}