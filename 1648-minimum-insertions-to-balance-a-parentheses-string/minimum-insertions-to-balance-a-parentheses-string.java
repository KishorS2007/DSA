import java.util.*;
class Solution {
    public int minInsertions(String s) {
        int open = 0, close = 0 , insertions = 0;

        for(char c : s.toCharArray()){
            if(c == '('){
                if(close != 0){
                    if(open == 0) insertions += 2;
                    else {
                        insertions++;
                        open--;
                    }
                    close = 0;
                }
                open++;
            } else {
                close++;
                if(close == 2){
                    if(open == 0) insertions++;
                    else open--;
                    close = 0;
                }
            }
        }

        if(close != 0 && open != 0){
            open--;
            insertions++;
        
        } else if(close != 0){
            insertions += 2;
        }

        insertions += (open * 2);
        return insertions;
    }
}