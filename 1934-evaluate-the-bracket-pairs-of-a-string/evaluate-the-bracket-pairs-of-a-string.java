import java.util.*;
class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> map = new HashMap<>();
        for(var pair : knowledge){
            map.put(pair.get(0),pair.get(1));
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            if(c == '('){
                StringBuilder key = new StringBuilder();
                i++;
                while(s.charAt(i) != ')'){
                    key.append(s.charAt(i));
                    i++;
                }
                sb.append(map.getOrDefault(key.toString(),"?"));
            } else {
                sb.append(c);
            }

            i++;
        }

        return sb.toString();
    }
}