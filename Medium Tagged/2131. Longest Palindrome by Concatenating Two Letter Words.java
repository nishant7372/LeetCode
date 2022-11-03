class Solution {
    public int longestPalindrome(String[] words) {
        Map<String,Integer> map = new HashMap<>();
        
        for(String s:words)
            map.put(s,map.getOrDefault(s,0)+1);
        
         int c=0;
        boolean isPresent=false;
        for(String s:map.keySet())
        {
            int a = map.get(s);
            if(s.charAt(0)==s.charAt(1))
            {
                if(a%2==1)
                    isPresent=true;
                c+=a%2==0? a:a-1;
            }
            else
            {
                String t = new StringBuffer(s).reverse().toString();
                int b=map.getOrDefault(t,0);
                c+=(2*Math.min(b,a));
                if(b!=0)
                    map.put(t,0);
                map.put(s,0);
            }
        }
      
        if(isPresent)
            return (c+1)*2;
        else
            return c*2;
    }
}
