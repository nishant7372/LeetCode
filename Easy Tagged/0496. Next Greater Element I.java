// 1ms runtime Beats 100% (HashTable and Search)

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        int[] index = new int[10001];
        int i=0;
        for(int x:nums2)
            index[x]=i++;
        i=0;
        for(int x:nums1)
            res[i++] = nextGreaterElement(x,index[x],nums2);
        return res;
    }

    private int nextGreaterElement(int target,int idx,int[] nums) {
        for(int j=idx+1;j<nums.length;j++)
        {
            if(nums[j]>target){
                return nums[j];
            }
        }
        return -1;
    }
}


//2ms runtime Beats 97% (HashTable and Stack)

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        int[] nextGreater = nextGreaterElement(nums2);
        int[] index = new int[10001];
        int i=0;
        for(int x:nums2)
            index[x]=i++;
        i=0;
        for(int x:nums1)
            res[i++] = nextGreater[index[x]];
        return res;
    }

    private int[] nextGreaterElement(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n=nums.length;
        int[] res = new int[n];
        Arrays.fill(res,-1);

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                res[st.pop()]=nums[i];
            }
            st.push(i);
        }
        return res;
    }
}


// 3ms runtime Beats 89% --> Naive Approach (Only Searching)

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        int target =0;
        int j;
        for(int i=0;i<nums1.length;i++)
        {
            res[i]=-1;
            for(j=0;j<nums2.length;j++)
            {
                if(nums1[i]==nums2[j])
                    break;
            }
            for(int k=j+1;k<nums2.length;k++)
            {
                if(nums2[k]>nums1[i])
                {
                    res[i]=nums2[k];
                    break;
                }
            }
        }
        return res;
    }
}
