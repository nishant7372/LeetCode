//Method 1--> Using Character Array
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>();
        
        for(String s:bank)
            set.add(s);
        char[] a = new char[]{'A','C','G','T'};
        
        int steps=0;
        
        Queue<String> queue=new ArrayDeque<>();
        
        if(start.equals(end))
            return 0;
        queue.add(start);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                String curr = queue.remove();
                
                if(curr.equals(end))
                    return steps;
                
                char[] arr = curr.toCharArray(); 
                for(int i=0;i<8;i++)
                {
                    for(char ch:a)
                    {
                        if(arr[i]!=ch){
                            arr[i]=ch;
                        String temp = String.valueOf(arr);
                    
                        if(set.contains(temp)){
                            queue.add(temp);
                            set.remove(curr);
                        }
                        arr[i]=curr.charAt(i);
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}

//Method 2--> Using StringBuffer

class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>();
        
        for(String s:bank)
            set.add(s);
        char[] a = new char[]{'A','C','G','T'};
        
        int steps=0;
        
        Queue<String> queue=new ArrayDeque<>();
        
        if(start.equals(end))
            return 0;
        queue.add(start);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                String curr = queue.remove();
                set.remove(curr);
                if(curr.equals(end))
                    return steps;
                StringBuffer sb = new StringBuffer(curr);
                for(int i=0;i<8;i++)
                {
                    for(char ch:a)
                    {
                        if(sb.charAt(i)!=ch){
                        sb.setCharAt(i,ch);
                        String temp = sb.toString();
                    
                        if(set.contains(temp))
                            queue.add(temp);
                        sb.setCharAt(i,curr.charAt(i));
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
