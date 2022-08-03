class Solution {
    public int maximumGroups(int[] grades) {
        int sum=0;
        int i=0;
        while(sum<grades.length)
        {
            i++;
            sum=(i*(i+1))/2;
        }
        return sum==grades.length? i:i-1;
    }
}
