//Approach 1 --> Greedy
class Solution {
    public boolean isPossible(int[] nums) {
        int[][] freq = new int[2004][2];
        int shift =1001;
        for(int x:nums)
        {
            freq[x+shift][0]++;
        }
        for(int x:nums)
        {
            if(freq[x+shift][0]==0)
                continue;
            freq[x+shift][0]--;
            if(freq[x+shift-1][1]>0)
            {
                freq[x+shift-1][1]--;
                freq[x+shift][1]++;
            }
            else if(freq[x+shift+1][0]>0&&freq[x+shift+2][0]>0)
            {
                freq[x+shift+1][0]--;
                freq[x+shift+2][0]--;
                freq[x+shift+2][1]++;
            }
            else
                return false;
        }
        return true;
    }
}


//Approach 2 - Brute Force
class Solution {
    public boolean isPossible(int[] nums) {
        List<int[]> lists = new ArrayList<>();
        
        for(int x:nums)
        {
            int i;
            for(i=lists.size()-1;i>=0;i--){
                if(lists.get(i)[1]==x-1){
                    break;
                }
            }
            if(i!=-1){
                lists.get(i)[0]++;
                lists.get(i)[1]=x;
            }
            else{
                int[] temp = new int[2];
                temp[0]=1;
                temp[1]=x;
                lists.add(temp);
            }  
        }
        for(int[] list: lists)
        {
            if(list[0]<3)
                return false;
        }
        return true;
    }
}
