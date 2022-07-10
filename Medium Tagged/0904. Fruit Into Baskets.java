class Solution {
    public int totalFruit(int[] fruits) {
        int a = 0;   //index of first tree
        int b = -1;  //index of second tree
        int max=1;  //maximum count
        int c=1;   //count for each window
        int lastChange=0;  //initializing the last change
        for(int i=1;i<fruits.length;i++)
        {
            if(fruits[i]!=fruits[a] && b==-1)
             b=i;
            if(b!=-1&&(fruits[i]!=fruits[b]&&fruits[i]!=fruits[a]))
            {
                 max=Math.max(c,max);
                 a=lastChange;
                 c=i-a;
                 b = i;
            }
            if(fruits[i]!=fruits[i-1])
                lastChange=i;      //remebering the last change
            c++;
        }
        return Math.max(max,c);
    }
}
