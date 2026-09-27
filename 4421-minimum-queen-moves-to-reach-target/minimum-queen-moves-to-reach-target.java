class Solution {
    public int minQueenMoves(int[] source, int[] target) {
        int xi = source[0] , yi = source[1];
        int xj = target[0] , yj = target[1];

        if(xi == xj && yi == yj) return 0;
        if( xi == xj || yi == yj) return 1;
        if(Math.abs(xi - xj) == Math.abs(yi-yj)) return 1;
        return 2;
    }
}