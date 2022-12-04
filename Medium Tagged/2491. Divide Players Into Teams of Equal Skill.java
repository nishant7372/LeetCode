class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        long ans=0;
        int i=0;
        int j=skill.length-1;
        Set<Integer> set = new HashSet<>();
        while(i<j)
        {
            set.add(skill[i]+skill[j]);
            if(set.size()>1)
                return -1;
            ans+=(skill[i]*skill[j]);
            i++;
            j--;
        }
        return ans;
        
    }
}
