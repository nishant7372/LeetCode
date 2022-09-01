// Method 1
// Using System.arraycopy() --> 0ms runtime faster than 100percent

// arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
// Copies an array from the specified source array, beginning at the specified position, to the specified position of the destination array.
// https://docs.oracle.com/javase/7/docs/api/java/lang/System.html#arraycopy(java.lang.Object, int, java.lang.Object, int, int)

class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        int[] end = Arrays.copyOfRange(nums, nums.length - k, nums.length);
        System.arraycopy(nums, 0, nums, k, nums.length - k);
        System.arraycopy(end, 0, nums, 0, end.length);
    }
}

// Method 2
// InPlace - By Reversing parts of array --> 1ms runtime faster than 87percent

class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        reverse(nums,0,nums.length-k-1);
        reverse(nums,nums.length-k,nums.length-1);
        reverse(nums,0,nums.length-1);
    }
    
    private void reverse(int[] nums,int i,int j)
    {
        while(i<j)
        {
            int temp = nums[i];
            nums[i++]=nums[j];
            nums[j--]=temp;
        }
    }
}

// Method 3 - > 4ms faster than 12.55% (Using another array for storing elements)

class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        int[] temp = new int[nums.length-k];
        for(int i=0;i<nums.length-k;i++)
        {
            temp[i]=nums[i];
        }
        for(int i=nums.length-k;i<nums.length;i++)
        {
            nums[i-(nums.length-k)]=nums[i];
        }
        for(int i=k;i<nums.length;i++)
        {
            nums[i]=temp[i-k];
        }
    }
}

// Method 4 - > 4ms faster than 12.55% (Using arraylist for storing elements)

class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=nums.length-k;i<nums.length;i++)
            temp.add(nums[i]);
        if(temp.size()!=0){
            for(int i=0;i<nums.length-k;i++)
                temp.add(nums[i]);
        }
        int i=0;
        for(int x:temp)
        {
            nums[i++]=x;
        }
    }
}
