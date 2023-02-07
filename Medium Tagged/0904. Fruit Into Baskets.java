//Beats 97% O(n)time and O(1) space No HashMap

class Solution {
    public int totalFruit(int[] fruits) {
        int b1 = 0, b2 = -1; //initially b1 contains fruit at index 0
        int max=1; //maximum no. of fruits
        int c=1; //count
        int lastChange=0; //lastchange index
        for(int i=1;i<fruits.length;i++)
        {
            if(fruits[i]!=fruits[b1] && b2==-1){
                b2 = i;
            }
            else if(fruits[i]!=fruits[b1] && fruits[i]!=fruits[b2])
            {
                max=Math.max(c,max);
                b1 = lastChange;
                b2 = i;
                c = i-b1;
            }
            if(fruits[i]!=fruits[i-1]){
                lastChange=i;
            }
            c++;
        }
        return Math.max(max,c);
    }
}

// Method 2 --> Beats 97% 6ms runtime 
// Sliding Window + HashTable 
// O(n) time and O(n) space

class Solution {
    public int totalFruit(int[] fruits) {
        int[] freq = new int[fruits.length]; //0 <= fruits[i] < fruits.length

        int j=0, max=0, unique=0;
        for(int i=0;i<fruits.length;i++){
            if(freq[fruits[i]]++==0)
               unique++;

            while(unique>2){
                if(freq[fruits[j++]]--==1)
                   unique--;
            }
            max=Math.max(max,i-j+1);
        }
        return max;
    }
}

// Method 3 -> 61ms runtime Beats 35% Simple Sliding Window
// Logic - Find the length of longest subarray with two distict elements
// Technique used - Sliding window

class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> map = new HashMap<>();
        int j=0, max=0;
        for(int i=0;i<fruits.length;i++){
            map.put(fruits[i],map.getOrDefault(fruits[i],0)+1);

            while(map.keySet().size()>2){
                map.put(fruits[j],map.get(fruits[j])-1);
                if(map.get(fruits[j])==0)
                   map.remove(fruits[j]);
                j++;
            }
            max=Math.max(max,i-j+1);
        }
        return max;
    }
}
