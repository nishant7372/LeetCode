//Method 1--> Using Character Array

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        List<Character> charSet = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        int count=0;
        
        Queue<String> queue = new ArrayDeque<>();
        
        queue.add(beginWord);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            
            while(size-->0)
            {
                String curr = queue.remove();
                if(curr.equals(endWord))
                    return count+1;
                
                char[] a = curr.toCharArray();
                for(int i=0;i<curr.length();i++)
                {
                    for(char ch='a';ch<='z';ch++)
                    {
                        if(a[i]==ch)
                            continue;
                        a[i]=ch;
                        String temp = String.valueOf(a);
                        
                        if(wordSet.contains(temp)){
                            queue.add(temp);
                            wordSet.remove(temp);
                        }
                        a[i]=curr.charAt(i);
                    }
                }
            }
            count++;
        }
        return 0;
    }
}

//Method 2--> Using StringBuffer

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        List<Character> charSet = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        int count=0;
        
        Queue<String> queue = new ArrayDeque<>();
        
        queue.add(beginWord);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            
            while(size-->0)
            {
                String curr = queue.remove();
                if(curr.equals(endWord))
                    return count+1;
                
                StringBuffer sb = new StringBuffer(curr);
                for(int i=0;i<curr.length();i++)
                {
                    for(char ch='a';ch<='z';ch++)
                    {
                        if(sb.charAt(i)==ch)
                            continue;
                        sb.setCharAt(i,ch);
                        String temp = sb.toString();
                        
                        if(wordSet.contains(temp)){
                            queue.add(temp);
                            wordSet.remove(temp);
                        }
                        sb.setCharAt(i,curr.charAt(i));
                    }
                }
            }
            count++;
        }
        return 0;
    }
}
