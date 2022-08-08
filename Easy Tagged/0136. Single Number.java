// Approach 1: Bit-manipulation
// Time Complexity : O(n)
// Space Complexity : O(1)
// 1ms runtime, faster than 100percent

// Logic Used -
// number xor(^) number = 0
// 0 xor(^) number = number
// Since, all the numbers except one are in pair of two, so there xor will be zero(order of xor doesn't matter --> 1^3^2^3^1^2=0), hence the output will be equal to single number.

class Solution {
    public int singleNumber(int[] nums) {
        int xor=0;
        for(int x:nums)
            xor^=x;
        return xor;
    }
}
// Approach 2 : Sorting
// Time Complexity : O(nlogn)+O(n) = O(nlogn)
// Space Complexity : O(1) (Sorting is done In-place)
// 7-8ms runtime, faster than ~40percent

// Logic Used -
// Sort the array and find the unique element using condition nums[i]!=nums[i+1], i+=2

class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if(nums.length==1)
            return nums[0];
        for(int i=0;i<nums.length-1;i+=2)
        {
            if(nums[i]!=nums[i+1])
                return nums[i];
        }
        return nums[nums.length-1];
    }
}


// Approach 3: Hashing

// 1. Using HashMap
// Time Complexity : O(n)
// Space Complexity : O(n)
// ~20ms runtime, faster than ~20percent

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int x:nums)
        {
            if(map.get(x)==null)
                map.put(x,0);
            else
                map.put(x,1);
        }
        for(int x:map.keySet())
            if(map.get(x)==0)
                return x;
        return -1;
    }
}


// 2. Using HashTable
// Time Complexity : O(n)
// Space Complexity : O(maxNumber-minNumber+1)
// ~3ms runtime, faster than ~42percent

class Solution {
    public int singleNumber(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int x:nums)
        {
            if(min>x)
                min=x;
            if(max<x)
                max=x;
        }
        int[] freq = new int[-min+max+1];
        for(int x:nums)
           freq[x-min]++;
        
        int i=min;
        for(int x:freq)
        {
            if(x==1)
                return i;
            i++;
        }
        return -1;
    }
}
