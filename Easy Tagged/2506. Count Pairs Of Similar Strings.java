class Solution {
    public int similarPairs(String[] words) {
        Map<String,Integer> map = new HashMap<>();
        int sum=0;
        for(String s:words)
        {
            char[] a = new char[26];
            
            for(int i=0;i<s.length();i++)
            {
                a[s.charAt(i)-'a']=1;
            }
            map.put(String.valueOf(a),map.getOrDefault(String.valueOf(a),0)+1);
        }
        
        for(int value:map.values())
        {
            sum+=((value)*(value-1))/2;
        }
        return sum;
    }
}
