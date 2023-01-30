class Solution {
    public int distinctIntegers(int n) {
        return Math.max(1,n-1);
    }
}

// Brute Force
class Solution {
    public int distinctIntegers(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        for(int i=1;i<=n;i++){
            Set<Integer> newSet = new HashSet<>();
            for(int x:set){
                for(int j=1;j<=n;j++){
                    if(x%j==1){
                        newSet.add(j);
                    }
                }
            }
            set.addAll(newSet);
        }
        return set.size();
    }
}
