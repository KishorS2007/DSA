class Solution {
    public int maxScore(int[] cardPoints, int k) {
        final int n = cardPoints.length;
        int lsum = 0 , rsum = 0 , max = 0;
        int l = k-1 , r = n-1;

        for(int i = 0 ; i < k ; i++) lsum += cardPoints[i];
        
        max = Math.max(lsum,max);

        while(l >= 0){
            lsum -= cardPoints[l--];
            rsum += cardPoints[r--];

            max = Math.max(lsum+rsum,max);
        }

        return max;
    }
}