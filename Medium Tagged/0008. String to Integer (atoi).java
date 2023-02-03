class Solution {
    public int myAtoi(String s) {
        s=s.trim(); // remove all trailing wwith spaces
        boolean neg = false; // flag to check whether no. is negative
        if(s.equals(""))
            return 0;
        if(s.charAt(0)=='-')
            neg=true;
        StringBuilder t = new StringBuilder("0");
        for(int i= (s.charAt(0)=='+'||s.charAt(0)=='-')? 1:0;i<s.length();i++)
        {
            if(Character.isDigit(s.charAt(i)))
                t.append(s.charAt(i));
            else
                break;
        }
        try{
            int a = Integer.parseInt(t.toString());
            return neg? -a:a;
        }
        catch(Exception e){
            return neg? Integer.MIN_VALUE: Integer.MAX_VALUE;
        }
    }
}
