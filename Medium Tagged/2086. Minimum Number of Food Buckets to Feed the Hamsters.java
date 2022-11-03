class Solution {
    public int minimumBuckets(String street) {     
    char[] a = street.toCharArray();
    int c=0;  // number of food buckets
    for(int i=0;i<a.length;i++)
    {
        if(a[i]=='H')
        {
            if(i>0 && a[i-1]=='f')
                continue;
            else if(i<a.length-1 && a[i+1]=='.')
            {
                a[i+1]='f';
                c++;
            }
            else if(i>0 && a[i-1]=='.')
            {
                a[i-1]='f';
                c++;
            }
            else
                return -1;
        }
    }
    return c;
    }
}
