//Approach 1
//Using Multiple Maps and Sortings --> Faster than 96%
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        
        for(String s:words)
        {
            if(map.get(s)==null)
            map.put(s,1);
            else
            map.put(s,map.get(s)+1);
        }
        
        ArrayList<Integer> freq = new ArrayList<>(map.values());
        ArrayList<String> word = new ArrayList<>(map.keySet());
        
        Map<Integer, ArrayList<String>> map2 = new HashMap<>();
        
        int max=0;
        for(int i=0;i<freq.size();i++)
        {
            if(freq.get(i)>max)
                max = freq.get(i);
            if(map2.get(freq.get(i))==null)
            {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(word.get(i));
                map2.put(freq.get(i),temp);
            }
            else
            map2.get(freq.get(i)).add(word.get(i));
        }
        
        freq = new ArrayList<Integer>(map2.keySet());
        
        ArrayList<String>[] a = new ArrayList[max+1];

        for(int x:freq)
        {
            a[x]=map2.get(x);
        }
        
        ArrayList<String> res = new ArrayList<>();
        for(int i=a.length-1;i>=0;i--)
        {
            if(a[i]==null)
                continue;
            Collections.sort(a[i]);
            for(String s: a[i])
            {
                res.add(s);
                k--;
                if(k==0)
                    break;
            } 
            if(k==0)
                break;
        }
        return res;
    }
}


//Approach 2
//Using PriorityQueue and Map.Entry<> Class --> Faster than 50%
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> list = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for(String s:words){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue()==b.getValue()? a.getKey().compareTo(b.getKey()):Integer.compare(b.getValue(),a.getValue()));
        
        for(var entry:map.entrySet()){
            pq.add(entry);
        }

        while(k-->0){
            list.add(pq.remove().getKey());
        }
        return list;
    }
}

//Approach 3
//Using PriorityQueue and Map.Entry<> Class with Pair<String,Integer>--> Faster than 50%
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> list = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for(String s:words){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        PriorityQueue<Pair<String,Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue()==b.getValue()? a.getKey().compareTo(b.getKey()):Integer.compare(b.getValue(),a.getValue()));
        
        for(var entry:map.entrySet()){
            String s = entry.getKey();
            int val = entry.getValue();
            pq.add(new Pair<>(s,val));
        }

        while(k-->0){
            list.add(pq.remove().getKey());
        }
        return list;
    }
}
