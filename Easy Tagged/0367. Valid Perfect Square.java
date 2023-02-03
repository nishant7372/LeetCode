// 0ms runtime Beats 100% (Binary Search)

class Solution {
    public boolean isPerfectSquare(int num) {
        int i=1;
        int j=num;
        while(i<=j)
        {
            int mid = i+(j-i)/2;
            if(mid==num/mid&&num%mid==0)
                return true;
            else if(mid<num/mid)
                i=mid+1;
            else
                j=mid-1;
        }
        return false;  
    }
}


// 0ms runtime Beats 100%

class Solution {
    public boolean isPerfectSquare(int num) {
        if((int)Math.sqrt(num)*(int)Math.sqrt(num)==num)
            return true;
        else
            return false;
    }
}
