class Solution {
    public int countVowelPermutation(int n) {
        long[] dp1 = new long[5];  //Previous
        long[] dp2 = new long[5];  //Current 
        
        Arrays.fill(dp1,1);
        
        long prevSum=4;
        long sum=0;
        
        for(int i=2;i<=n;i++)
        {
            sum+=dp2[0]=dp1[1];
            sum+=dp2[1]=(dp1[0]+dp1[2])%1000000007;
            dp2[2]=prevSum;
            sum+=dp2[3]=(dp1[2]+dp1[4])%1000000007;
            sum+=dp2[4]=dp1[0];
            
            for(int j=0;j<5;j++)
                dp1[j]=dp2[j];
            
            prevSum=sum%1000000007;
            sum=0;
        }
        return (int)((prevSum+dp1[2])%1000000007);
    }
}
