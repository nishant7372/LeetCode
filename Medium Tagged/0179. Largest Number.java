class Solution {
    public String largestNumber(int[] nums) {
        String[] a = new String[nums.length];

        int i=0;
        for(int x:nums)
        a[i++]=x+"";

        Arrays.sort(a,(s,t) -> Long.parseLong(s+t)>Long.parseLong(t+s)? -1:1);

        StringBuffer sb = new StringBuffer();
        for(String s:a)
        {
            if(sb.toString().equals("0")){
                sb=new StringBuffer(s);
            }
            else
                sb.append(s);
        }
        return sb.toString();
    }
}
