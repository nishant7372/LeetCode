//Beats 97% O(n)time and O(1) space No HashMap

class Solution {
    public int totalFruit(int[] fruits) {
        int b1 = 0, b2 = -1; //initially b1 contains fruit at index 0
        int max=1; //maximum no. of fruits
        int c=1; //count
        int lastChange=0; //lastchange index
        for(int i=1;i<fruits.length;i++)
        {
            if(fruits[i]!=fruits[b1] && b2==-1){
                b2 = i;
            }
            else if(fruits[i]!=fruits[b1] && fruits[i]!=fruits[b2])
            {
                max=Math.max(c,max);
                b1 = lastChange;
                b2 = i;
                c = i-b1;
            }
            if(fruits[i]!=fruits[i-1]){
                lastChange=i;
            }
            c++;
        }
        return Math.max(max,c);
    }
}
