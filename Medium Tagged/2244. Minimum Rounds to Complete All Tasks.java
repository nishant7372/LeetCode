//Approach 1 --> Sorting
class Solution {
    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        int rounds=0;
        int c=1;
        for(int i=0;i<tasks.length-1;i++)
        {
            if(tasks[i]==tasks[i+1])
                c++;
            else
            {
                if(c==1)
                    return -1;
                if(c%3==0)
                    rounds+=c/3;
                if(c%3>=1)
                    rounds+=c/3+1;
                c=1;
            }
        }
        if(c==1)
         return -1;
        if(c%3==0)
         rounds+=c/3;
        if(c%3>=1)
         rounds+=c/3+1;
        return rounds;
    }
}


//Approach 2 --> HashMap
class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int x:tasks){
            map.put(x,map.getOrDefault(x,0)+1);
        }

        int rounds=0;
        for(int x:map.values()){
            rounds+=x/3;
            if(x==1)
            return -1;
            if(x%3>=1)
            rounds++;
        }
        return rounds;
    }
}
