//Method 1 --> HashTable
class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        int[] a = new int[1000001];

        int i=0; 
        for(int x:nums)
        {
            a[x]=i;
            i++;
        }

        for(int[] x:operations)
        {
            int idx = a[x[0]];
            nums[idx]=x[1];
            a[x[1]]=idx;
        }
        return nums;
    }
}


//Method 2--> HashMap
class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer,Integer> map = new HashMap<>();

        int i=0; 
        for(int x:nums)
        {
            map.put(x,i);
            i++;
        }

        for(int[] x:operations)
        {
            int idx = map.get(x[0]);
            nums[idx]=x[1];
            map.put(x[1],idx);
        }
        return nums;
    }
}
