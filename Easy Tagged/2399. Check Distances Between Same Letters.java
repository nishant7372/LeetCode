//Method 1
class Solution {
    public boolean checkDistances(String s, int[] distance) {
        int[] list = new int[26];
      
        for(int i=0;i<s.length();i++)
        {
            if(list[s.charAt(i)-'a']==0)
                list[s.charAt(i)-'a']=i+1;
				
            else if(i-list[s.charAt(i)-'a']!=distance[s.charAt(i)-'a'])
                    return false;
        }
        return true;
    }
}

//Method 2
class Solution {
    public boolean checkDistances(String s, int[] distance) {
        ArrayList<Integer>[] list = new ArrayList[26];   //can also use int[26][2]
        for(int i=0;i<26;i++)
            list[i] = new ArrayList<Integer>();
        
        for(int i=0;i<s.length();i++)
        {
            list[s.charAt(i)-'a'].add(i);
        }
        
        int i=0;
        for(ArrayList<Integer> temp: list)
        {
            if(temp.size()==2)
            {
                if(distance[i]!=(temp.get(1)-temp.get(0)-1))
                    return false;
            }
            i++;
        }
        return true;
    }
}
