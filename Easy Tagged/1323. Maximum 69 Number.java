class Solution {
    public int maximum69Number (int num) {
        StringBuffer sb= new StringBuffer(num+"");
        int i = sb.indexOf("6");
        if(i!=-1){
            sb.setCharAt(i,'9');
            return Integer.parseInt(sb.toString());
        }
        return num;
    }
}
