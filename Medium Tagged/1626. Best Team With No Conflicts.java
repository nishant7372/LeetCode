// O(n^2) time and O(n) space DP Solution with Sorting
// Beats 83% Java


// Approach:

// 1. Sort the Players on the basis of scores(Ascending) and break their ties on the basis of age(Ascending).
// 2. Now, we can select the players from left to right.
// 3. Create a dp array of length n, where dp[i], indicates the sum of scores of selected players on left of ith player + score of ith player.
// 4. For each player i, now search a player j on left which has maximum dp[j] value and age[j]<=age[i].
// 5. Fill dp[i] with searched value(if not found then 0) + curr player score.
// 6. Get the max from dp.
    
class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] players = new int[n][2];

        for(int i=0;i<n;i++){
           players[i][0]=scores[i];
           players[i][1]=ages[i];
        }

        // Sorting Players on the basis of scores(Ascending) and break their ties on the basis of age(Ascending)
        Arrays.sort(players, (p1,p2) -> p1[0]==p2[0]? Integer.compare(p1[1],p2[1]):Integer.compare(p1[0],p2[0]));

        int[] dp = new int[n];
        int max=0;
        for(int i=0;i<n;i++){
            dp[i]=search(dp,players,i)+players[i][0];
            max=Math.max(max,dp[i]);
        }

        return max;
    }

    //For each player i, search a player j on left which has maximum dp[j] and age[j]<=age[i]
    private int search(int[] dp,int[][] players,int i){
        int max=0;
        for(int j=0;j<i;j++){
            if(dp[j]>max && players[j][1]<=players[i][1]){
                max=dp[j];
            }
        }
        return max;
    }
}
