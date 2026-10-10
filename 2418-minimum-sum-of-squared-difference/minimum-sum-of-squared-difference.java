class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        final int n = nums1.length;
        int[] diff = new int[(int) 1e5 + 1];
        long sum = 0 , k = k1 + k2 , max = 0;

        for(int i = 0 ; i < n ; i++){
            int d = Math.abs(nums1[i]-nums2[i]);
            sum += d;
            max = Math.max(max,d);
            diff[d]++;
        }

        if(sum <= k) return 0;

        int i = (int) max;
        while(i >= 1 && k > 0){
            if(diff[i] == 0) continue;

            if(diff[i] <= k){
                diff[i-1] += diff[i];
                k -= diff[i];
                diff[i] = 0; 
            } else {
                diff[i] -= k;
                diff[i-1] += k;
                break;
            }
            i--;
        }

        long ans = 0;
        while(i >= 0){
            ans += (diff[i] * 1L * i * i); // count * square
            i--;
        }

        return ans;
    }
}