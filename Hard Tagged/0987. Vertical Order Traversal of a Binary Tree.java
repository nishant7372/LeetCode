class Solution {
    Map<Integer,ArrayList<int[]>> map;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        map = new HashMap<>();
        preOrder(root,0,0);
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for(int key:keys)
        {
            ArrayList<int[]> list = map.get(key);
            Collections.sort(list,new ArrayComparator());
            ArrayList<Integer> a = new ArrayList<>();
            for(int[] x: list)
            {
            a.add(x[0]);
            }
            res.add(a);
        }
        return res;
    }
    
    private void preOrder(TreeNode root,int col,int row)
    {
        if(root==null)
            return;
        if(map.get(col)==null)
        {
            ArrayList<int[]> temp = new ArrayList<>();
            temp.add(new int[]{root.val,row});
            map.put(col,temp);
        }
        else
        {
            map.get(col).add(new int[]{root.val,row});
        }
        preOrder(root.left,col-1,row+1);
        preOrder(root.right,col+1,row+1);
    }
}

class ArrayComparator implements Comparator<int[]>{
    public int compare(int[] a,int[] b)
    {
        if(a[1]<b[1])
        {
            return -1;
        }
        else if(a[1]>b[1])
        {
            return 1;
        }
        else if(a[1]==b[1])
        {
            if(a[0]<b[0])
                return -1;
            else if(a[0]>b[0])
                return 1;
        }
        return 0;
    }
}
