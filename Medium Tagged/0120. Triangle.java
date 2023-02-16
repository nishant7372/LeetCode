// Method 1 -> Memoization -> Top Down Approach, 1ms runtime, Beats 99.9% 

class Solution {
    public int minimumTotal(List<List<Integer>> t) {
        Integer[][] dp = new Integer[t.size()][];
        for(int i=0;i<dp.length;i++){
            dp[i] = new Integer[t.get(i).size()];
        }
        return solve(dp,t,0,0);
    }

    private int solve(Integer[][] dp,List<List<Integer>> t,int i,int j){
        if(i>=dp.length)
           return 0;
        if(j==dp[i].length || j<0)
           return 0;
        if(dp[i][j]!=null)
           return dp[i][j];
        int res1 = solve(dp,t,i+1,j+1);
        int res2 = solve(dp,t,i+1,j);
        return dp[i][j]=t.get(i).get(j)+Math.min(res1,res2);
    }
}



// 5ms runtime Beats 46%
// Method 2 -> Tabulation -> Bottom Up Approach (Converting List<List<>> to Integer[][])

class Solution {
    public int minimumTotal(List<List<Integer>> t) {
        Integer[][] dp = t.stream().map(u -> u.toArray(new Integer[0])).toArray(Integer[][]::new);

        for(int i=1;i<dp.length;i++)
        {
            for(int j=0;j<dp[i].length;j++)
            {
                if(j==0||j==dp[i].length-1)
                    dp[i][j]=dp[i][j]+dp[i-1][j==0? j:j-1];
                else 
                    dp[i][j]=dp[i][j]+Math.min(dp[i-1][j],dp[i-1][j-1]);
            }
        }
        int min=Integer.MAX_VALUE;
        for(int x:dp[dp.length-1]){
            min=Math.min(min,x);
        }
        return min;
    }
}

// Beats 5%
// Method 2 -> Tabulation -> Bottom Up Approach (Using O(1) extra space)

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i=1;i<triangle.size();i++)
        {
            for(int j=0;j<triangle.get(i).size();j++)
            {
                if(j==0 || j==triangle.get(i).size()-1)
                    triangle.get(i).set(j,triangle.get(i).get(j)+triangle.get(i-1).get(j==0? j:j-1));
                else
                    triangle.get(i).set(j,triangle.get(i).get(j)+Math.min(triangle.get(i-1).get(j),triangle.get(i-1).get(j-1)));
            }
        }
        return Collections.min(triangle.get(triangle.size()-1));
    }
}
