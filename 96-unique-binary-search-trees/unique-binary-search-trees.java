class Solution {
    static int[] dp = new int[20];
    static{
        dp[0] = dp[1] = 1;

        for(int n = 2 ; n < 20 ; n++){
            int sum = 0;
            
            for(int i = 0 ; i < n ; i++){
                sum += dp[i] * dp[n - i - 1];
            }

            dp[n] = sum;
        }
    }
    public int numTrees(int n) {
        return dp[n];
    }
}