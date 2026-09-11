import java.util.*;
class Solution {
    Set<List<Integer>> ans = new HashSet<>();

    public int totalNumbers(int[] digits) {
        solve(digits,new ArrayList<>(),0);
        return ans.size();
    }

    private void solve(int[] digits,List<Integer> curr,int mask){
        if(curr.size() == 3){
            ans.add(new ArrayList<>(curr));
            System.out.println(curr);
            return;
        }

        for(int i = 0 ; i < digits.length ; i++){
            int currMask = 1 << i;
            if((mask & currMask) != 0) continue; // already taken
            if(mask == 0 && digits[i] == 0) continue; // leading zero
            if(curr.size() == 2 && digits[i] % 2 != 0) continue; // 3rd digit odd

            curr.add(digits[i]);
            solve(digits,curr,mask | currMask);
            curr.remove(curr.size()-1);
        }

    }
}