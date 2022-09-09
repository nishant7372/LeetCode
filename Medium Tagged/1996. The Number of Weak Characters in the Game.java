class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties,new ArrayComparator());

        int max= properties[properties.length-1][1];
        
        int weakCharacters=0;
        for(int i=properties.length-2;i>=0;i--)
        {
            if(properties[i][1]<max)
                weakCharacters++;
            else
                max=properties[i][1];
        }
        return weakCharacters;
    }
}

class ArrayComparator implements Comparator<int[]>{
    @Override
    public int compare(int[] a,int[] b)
    {
        if(a[0]<b[0]){
            return -1;
        }
        if(a[0]>b[0]){
            return 1;
        }
        else{
            return Integer.compare(b[1],a[1]);
        }
    }
}
