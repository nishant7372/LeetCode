// 24ms runtime Beats 64%, Two Pointers

class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String max="";
        for(String x:dictionary){
            if(canBeFormed(x,s)){
                if(x.length()>max.length() || (x.length()==max.length() && x.compareTo(max)<0)) 
                   max=x;
            }
        }
        return max;
    }

    private boolean canBeFormed(String x,String s){
        int i=0, j=0;
        while(i<s.length() && j<x.length()){
            if(s.charAt(i)==x.charAt(j))
               j++;
            i++;
        }
        return j==x.length();
    }
}
