class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        int n = s.length();
        int[][] res=new int[queries.length][2];
        Map<Integer,int[]> map = new HashMap<>();
        int idx=s.indexOf('0');
        map.put(0,new int[]{idx,idx});
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='0')
               continue;
            for(int j=i;j<n && j-i+1<32;j++)
                map.putIfAbsent(Integer.parseInt(s,i,j+1,2),new int[]{i,j});
        }
        
        int i=0;
        int[] notFound = {-1,-1};
        for(int[] x:queries){
            int val = x[0]^x[1];
            res[i++] = map.get(val)==null? notFound:map.get(val);
        }
        return res;
    }
}
