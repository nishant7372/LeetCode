//Method 1
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(int[] a,int[] b) -> a[0]==b[0]? Integer.compare(a[1],b[1]) : Integer.compare(a[0],b[0]));
            
        ArrayList<int[]> list = new ArrayList<>();
       
        for(int i=0;i<intervals.length;i++)
        {
            int j = i+1;
            int end = intervals[i][1];
			
            while(j<intervals.length && intervals[j][0]<=end)
                end = Math.max(end,intervals[j++][1]);
            
            list.add(new int[]{intervals[i][0],end});
            i=j-1;
        }
        
        int[][] res = new int[list.size()][];
        int i=0;
        for(int[] x:list)
            res[i++]=x;
        return res;
    }
}

//Method 2
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==1)
            return intervals;
        
        Map<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        int maxval=0;
        int maxKey=0;
        
        for(int i=0;i<intervals.length;i++)
        {
            if(map.get(intervals[i][0])!=null)
            map.put(intervals[i][0],Math.max(map.get(intervals[i][0]),intervals[i][1]));
            else
            map.put(intervals[i][0],intervals[i][1]);
            
            if(intervals[i][1]>maxval)
            {
                maxval=intervals[i][1];
                maxKey=intervals[i][0];
            }
        }
        ArrayList<Integer> a = new ArrayList<>(map.keySet());
        Collections.sort(a);
        
        int i=0;
        
        while(i+1<a.size())
        {
           int start = a.get(i);
           int end = map.get(a.get(i));
            
           while(i+1<a.size()&&end>=a.get(i+1))
           {
               end=Math.max(end,map.get(a.get(i+1)));
               i++;
           }
           res.add(start);  
           res.add(end);
           i++;
        }
        
        if(a.size()==1)
        {
            res.add(a.get(0));
            res.add(map.get(a.get(0)));
        }
        
        if(res.size()>0&&res.get(res.size()-1)!=maxval)
        {
            res.add(maxKey);
            res.add(maxval);
        }
        
        int[][] arr = new int[res.size()/2][2];
        
        int k=0;
        for(i=0;i<res.size()/2;i++)
        {
            arr[i][0]=res.get(k++);
            arr[i][1]=res.get(k++);
        }
        return arr;
    }
}
