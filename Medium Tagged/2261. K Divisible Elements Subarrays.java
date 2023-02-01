// Method 1 --> O(n^2) time using Trie, Beats 82%

class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        Trie trie = new Trie(); // Trie
        int total=0;  // total distinct subarrays
        for(int i=0;i<nums.length;i++)
        {
            int c=0;  // count
            Trie t = trie; // reference of trie
            for(int j=i;j<nums.length;j++)
            {
                if(nums[j]%p==0)  
                   c++;  // increment count when nums[i] is divisble by p 
                if(c<=k){
                    if(t.a[nums[j]]==null)  
                       t.a[nums[j]]=new Trie();
                    t = t.a[nums[j]];
                    if(!t.stop) // if subarray not Present
                       total++;
                    t.stop = true;   // set stop to true for a subarray
                }
                else 
                   break;
            }
        }
        return total;  // total distinct subarrays
    }
}

// Trie is implemented over HashTable
class Trie{
    Trie[] a;  //HashTable 
    boolean stop;  // stop to indicate stop of a subarray.
    public Trie(){
        a = new Trie[201];
        stop = false;
    }
}


// Method 2 --> O(n^3) time using Trie, Beats 63% (Method 1 is the optimization of this method)

class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        Trie trie = new Trie();
        int total=0;
        for(int i=0;i<nums.length;i++)
        {
            int c=0;
            for(int j=i;j<nums.length;j++)
            {
                if(nums[j]%p==0)
                   c++;
                if(c<=k){
                   if(checkAndStore(nums,i,j,trie))
                      total++;
                }
                else 
                   break;
            }
        }
        return total;
    }
    
    private boolean checkAndStore(int[] nums,int start,int end,Trie trie)
    {
        int i;
        Trie temp = trie;
        for(i=start;i<=end;i++){
            if(temp.a[nums[i]]!=null)
                temp = temp.a[nums[i]];
            else
                break;
        }
        if(i==end+1 && temp.stop)  // if already present in trie
           return false;   // should not be counted

        // store in trie
        for(i=start;i<=end;i++){
            if(trie.a[nums[i]]==null)
                trie.a[nums[i]]=new Trie();
            trie = trie.a[nums[i]];
        }
        return trie.stop=true;  // should be counted
    }
}

// Trie is implemented over HashTable
class Trie{
    Trie[] a;  // HashTable
    boolean stop;  // stop to indicate stop of a subarray.
    public Trie(){
        a = new Trie[201];
        stop = false;
    }
}
