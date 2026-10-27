class Solution {
    public List<String> restoreIpAddresses(String s) {
        final int n = s.length();
        List<String> ans = new ArrayList<>();

        for(int i = 1 ; i <= 3 ; i++)
        for(int j = 1 ; j <= 3 ; j++)
        for(int k = 1 ; k <= 3 ; k++)
        for(int l = 1 ; l <= 3 ; l++){

            if(i+j+k+l != n) continue;

            int octet1 = Integer.parseInt(s.substring(0 , i));
            int octet2 = Integer.parseInt(s.substring(i , i+j));
            int octet3 = Integer.parseInt(s.substring(i+j , i+j+k));
            int octet4 = Integer.parseInt(s.substring(i+j+k , n));

            String ip = octet1+"."+octet2+"."+octet3+"."+octet4;
            
            if( octet1 > 255 || octet2 > 255 || octet3 > 255 || 
                octet4 > 255 || ip.length() != n + 3
            ) continue;

            ans.add(ip);
        }

        return ans;
    }
}