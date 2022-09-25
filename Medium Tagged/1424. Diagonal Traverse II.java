class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        ArrayList<int[]> queue = new ArrayList<>();
        
        for(int i=0;i<nums.size();i++)
        {
            for(int j=0;j<nums.get(i).size();j++)
            {
                queue.add(new int[]{i+j,i,nums.get(i).get(j)});
            }
        }
        Collections.sort(queue,new NumberComparator());
        int[] res = new int[queue.size()];
        int i=0;
        while(i<res.length)
        {
            res[i] = queue.get(i++)[2];
        }
        return res;
    }
}

class NumberComparator implements Comparator<int[]>{
    public int compare(int[] a,int[] b)
    {
        if(a[0]==b[0])
            return Integer.compare(b[1],a[1]);
        return Integer.compare(a[0],b[0]);
    }
}
