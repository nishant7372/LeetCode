class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        return (int)Math.ceil(Math.log(buckets)/Math.log((minutesToTest/minutesToDie )+1));
    }
}

//Solve for min x such that (t+1)^x>=N
//t = minutesToTest/minutesToDie 
//N = no. of buckets
//x is the min no. of pigs
