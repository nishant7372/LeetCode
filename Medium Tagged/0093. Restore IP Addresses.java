//Approach 1--> Using StringBuilder & List<String>(Converting it to String) (2ms runtime and Faster than 93%)

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();  //result list
        restore(s,0,res,new ArrayList<String>(),0);
        return res;
    }

    private void restore(String s,int i,List<String> res,ArrayList<String> list,int dots)
    {
        //all characters of string included.
        if(i==s.length()){
            if(dots<3) //when no. of dots in restoredIp<3 -> return.
               return;
            res.add(buildString(list)); //adding restoredIp to result
        }
        StringBuilder temp = new StringBuilder();
        for(int idx=i;idx<s.length();idx++){
            temp.append(s.charAt(idx));
            //checking for valid conditions.
            if(dots<=3 && isValid(temp.toString())){
                list.add(temp.toString()); //adding valid string to list
                if(idx==s.length()-1) //dot should not be inserted at last
                    restore(s,idx+1,res,list,dots);
                else{
                    list.add("."); //adding dot to list
                    restore(s,idx+1,res,list,dots+1);//incrementing the count of dots
                    list.remove(list.size()-1);  //removing dot from list
                }
                list.remove(list.size()-1); //removing valid string from list
            }
        }
    }

    private boolean isValid(String s){
        //checking for 1st character to not be '0' when len(s)>1
        if(s.length()>1 && s.charAt(0)=='0') 
           return false;
        //checking for String value to remain between [0,255]
        if(s.length()>0 && s.length()<4 && Integer.parseInt(s)<256)
           return true;
        return false;  //else condition
    }
    
    //building string from ArrayList<String> using StringBuilder
    private String buildString(ArrayList<String> list){
        StringBuilder sb = new StringBuilder();
        for(String s:list)
             sb.append(s);
        return sb.toString();
    }
}

//Approach 2--> Using Temporary String and StringBuilder (6ms runtime Faster than 56.5%)


class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>(); //result list
        restore(s,0,res,"",0);
        return res;
    }

    private void restore(String s,int i,List<String> res,String t,int dots)
    {
       //all characters of string included.
        if(i==s.length()){
            if(dots<3) //when no. of dots in restoredIp<3 -> return.
               return;
            res.add(t); //adding restoredIp to result
        }
        StringBuilder temp = new StringBuilder();
        for(int idx=i;idx<s.length();idx++){
            temp.append(s.charAt(idx)); 
           //checking for valid conditions.
            if(dots<=3 && isValid(temp.toString())){
                if(idx==s.length()-1)
                    restore(s,idx+1,res,t+temp.toString(),dots); //dot should not be inserted at last
                else
                    restore(s,idx+1,res,t+temp.toString()+'.',dots+1); 
            }
        }
    }

    private boolean isValid(String s){
       //checking for 1st character to not be '0' when len(s)>1
        if(s.length()>1 && s.charAt(0)=='0')
           return false;
       //checking for String value to remain between [0,255]
        if(s.length()>0 && s.length()<4 && Integer.parseInt(s)<256)
           return true;
        return false;
    }
}
