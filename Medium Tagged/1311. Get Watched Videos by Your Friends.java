class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[friends.length];
        queue.add(id);
        visited[id]=true;
        Map<String,Integer> map = new HashMap<>();
        while(!queue.isEmpty())
        {
            int len = queue.size();
            while(len-->0){
            int curr = queue.remove();
            if(level==0)
            {
                for(String s:watchedVideos.get(curr))
                map.put(s,map.getOrDefault(s,0)+1);
            }
            for(int x:friends[curr])
            {
                if(!visited[x])
                queue.add(x);
                visited[x]=true;
            }
            }
            level--;
            if(level==-1)
            break;
        }
        Map<Integer,ArrayList<String>> map2 = new TreeMap<>();
        for(var entry:map.entrySet())
        {
            String key = entry.getKey();
            int val = entry.getValue();
            if(map2.get(val)==null)
            map2.put(val,new ArrayList<String>());
            map2.get(val).add(key);
        }
        ArrayList<String> list = new ArrayList<>();
        for(ArrayList<String> temp: map2.values())
        {
            Collections.sort(temp);
            for(String s:temp)
            list.add(s);
        }
        return list;
    }
}
