// 1ms runtime Beats 100% --> O(n) time and O(1) space

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        // Here we are minimizing the not selected portion of length cardPoints.length-k
        int total=0, sum=0, minSum=0;
        for(int x:cardPoints){
            total+=x;
        }
        k=cardPoints.length-k;
        for(int i=0;i<k;i++){
            sum+=cardPoints[i];
        }
        minSum=sum;
        for(int i=k;i<cardPoints.length;i++){
            sum+=cardPoints[i];
            sum-=cardPoints[i-k];
            minSum=Math.min(minSum,sum);
        }
        return total-minSum;
    }
}
