//Approach 1
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int c=0;
        for(int i=0;i<stones.length();i++)
        {
            if(jewels.indexOf(stones.charAt(i))>=0)
                c++;
        }
        return c;
    }
}

//Approach 2
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int[] small = new int[26];
        int[] large = new int[26];
        for(int i=0;i<jewels.length();i++)
        {
            if(jewels.charAt(i)>=97)
                small[jewels.charAt(i)-'a']=1;
            else
                large[jewels.charAt(i)-'A']=1;
        }
        int c=0;
        for(int i=0;i<stones.length();i++)
        {
            if(stones.charAt(i)>=97)
            {
            if(small[stones.charAt(i)-'a']==1)
                c++;
            }
            else
            {
                if(large[stones.charAt(i)-'A']==1)
                    c++;
            }
        }
        return c;
    }
}
