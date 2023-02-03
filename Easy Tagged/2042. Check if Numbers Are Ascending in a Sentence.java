// Using .split() method 1ms runtime Beats 97%

class Solution {
    public boolean areNumbersAscending(String s) {
        String[] arr = s.split(" ");
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(String t:arr){
            if(Character.isDigit(t.charAt(0))){
               a.add(Integer.parseInt(t));
               if(a.size()>1 && a.get(a.size()-1)<=a.get(a.size()-2))
                  return false;
            }
        }
        return true;
    }
}

// Using Manual Spliting 4ms runtime Beats 42.4%

class Solution {
    public boolean areNumbersAscending(String s) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        int i=0;
        int k=0;
        for(i=0;i<s.length();i++)
        {
            if(s.charAt(i)==' ')
            {
                if(s.substring(k,i).charAt(0)>='0'&&s.substring(k,i).charAt(0)<='9')
                    a.add(Integer.parseInt(s.substring(k,i)));  
                k=i+1;
            }
        }
        if(s.substring(k,i).charAt(0)>='0'&&s.substring(k,i).charAt(0)<='9')
                    a.add(Integer.parseInt(s.substring(k,i)));
        
        for(int j=0;j<a.size()-1;j++)
        {
            if(a.get(j)>=a.get(j+1))
                return false;
        }
        return true;
    }
}
