class Solution {
    public int numberOfSubstrings(String s) {
        int[] map = new int[3];
        map[0] = map[1] = map[2] = -1;
        char[] arr = s.toCharArray();
        int total = 0;

        for(int i = 0 ; i < arr.length ; i++){
            map[arr[i]-'a'] = i;

            int min = Math.min(map[0] , Math.min(map[1] , map[2]));
            total += min + 1;
        }

        return total;
    }
}