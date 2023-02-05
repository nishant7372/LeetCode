// Beats 100% 

class Solution {
    public int minimumOperations(int[] nums) {
        // all odd indixes value should be same
        // all even indices value should be same

        int even_max=0; //Maximum Value at Even Index
        int odd_max=0; //Minimum Value at Even Index
        
        for(int i=0;i<nums.length;i+=2){
            if(nums[i]>even_max)
                even_max=nums[i];
        }
        for(int i=1;i<nums.length;i+=2){
            if(nums[i]>odd_max)
                odd_max=nums[i];
        }
        
        int[] a = new int[even_max+1]; //Even Indices Mapping
        int[] b = new int[odd_max+1]; //Odd Indices Mapping
        
        for(int i=0;i<nums.length;i+=2)
            a[nums[i]]++;
        for(int i=1;i<nums.length;i+=2)
            b[nums[i]]++;
        
        int even_max_count=0; //Even Index Maximum Freq 
        int even_max_value=a[0]; //Value Having Maximum Freq at Even Index 
        int prev_even=0; //Even Index Second Maximum Freq  
        
        for(int i=0;i<a.length;i++)
        {
            if(even_max_count<a[i])
            {
                even_max_count=a[i];
                even_max_value=i;
            }      
        }
        for(int i=0;i<a.length;i++)
        {
           if(prev_even<a[i]&&i!=even_max_value)
                prev_even=a[i];     
        }
        int odd_max_count=0; //Odd Index Maximum Freq 
        int odd_max_value=b[0]; //Value Having Maximum Freq at Odd Index 
        int prev_odd=0; //Odd Index Second Maximum Freq 
        
        for(int i=0;i<b.length;i++)
        {
            if(odd_max_count<b[i])
            {
                 odd_max_count=b[i];
                 odd_max_value=i;
            }  
        }
        for(int i=0;i<b.length;i++)
        {
            if(prev_odd<b[i]&&i!=odd_max_value)
                prev_odd=b[i]; 
        }
        
        if(even_max_value==odd_max_value)
           return Math.min(nums.length-odd_max_count-prev_even,nums.length-even_max_count-prev_odd);
        else
           return nums.length-even_max_count-odd_max_count;
    }
}
