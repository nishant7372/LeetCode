class Solution {
    public int firstUniqChar(String s) {
        int min= s.length();
        for(int i=97;i<123;i++)
        {
            int idx = s.indexOf((char)i);
            int lIdx = s.lastIndexOf((char)i);
            if(idx==lIdx&&idx!=-1)
            {
                if(min>idx)
                    min=idx;
            }
        }
        if(min==s.length())
            return -1;
        return min;
    }
}
