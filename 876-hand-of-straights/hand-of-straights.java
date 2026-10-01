class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        Arrays.sort(hand);

        for(int i = 0 ; i < hand.length ; i++){
            if(hand[i] == -1) continue;
            if(!solve(hand , i , groupSize)) return false;
        }

        return true;
    }

    private static final boolean solve(int[] hand , int idx , int size){
        if(hand.length - idx < size) return false;

        int i = idx , prev = -1;
        while(i < hand.length){
            if(hand[i] == -1 || hand[i] == prev){
                i++;
                continue;
            }
            if(prev != -1 && prev != hand[i] - 1) return false;

            prev = hand[i];
            hand[i] = -1;
            i++;
            if(--size == 0) break;
        }

        return size == 0;
    }
}