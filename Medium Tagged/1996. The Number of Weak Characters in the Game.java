// Beats 46%

class Solution {
    public int numberOfWeakCharacters(int[][] p) {
        int n = p.length;
        // sorted by attack(increasing) and breaking ties by defense(decreasing).
        Arrays.sort(p,(a,b)->a[0]==b[0]? Integer.compare(b[1],a[1]):Integer.compare(a[0],b[0]));

        int max= p[n-1][1];
        int weak=0;
        for(int i=n-2;i>=0;i--)
        {
            if(p[i][1]<max)
                weak++;
            max=Math.max(max,p[i][1]);
        }
        return weak;
    }
}
