// 6ms runtime Beats 73%

class Solution {
    public String convert(String s, int rows) {
        if(rows==1)
            return s;
        List<StringBuilder> a = new ArrayList<>();
        for(int i=0;i<rows;i++)
            a.add(new StringBuilder());
    
        int j=0, k=0;
        for(char ch:s.toCharArray())
        {
            a.get(j).append(ch);
            j = k%2==0? j+1:j-1;
            if(j==rows-1||j==0)
                k++;
        }
        StringBuilder sb = new StringBuilder();
        for(StringBuilder t:a)
            sb.append(t);
        
        return sb.toString();
    }
}
