// Using .split() and .join() method 0ms runtime Beats 100%

class Solution {
    public String sortSentence(String s) {
        String[] arr = s.split(" ");
        String[] a = new String[arr.length];

        for(String x:arr){
            a[x.charAt(x.length()-1)-'1']=x.substring(0,x.length()-1);
        }
        return String.join(" ",a);
    }
}

// Manual Spliting and, 0ms runtime Beats 100%

class Solution {
    public String sortSentence(String s) {
        int k=0;
        ArrayList<String> list= new ArrayList<String>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==' '){
                list.add(s.substring(k,i));
                k=i+1;
            }
        }
        list.add(s.substring(k,s.length()));    
        String[] a = new String[list.size()];
        for(String x:list){
            a[x.charAt(x.length()-1)-'1']=x.substring(0,x.length()-1);
        }
        return String.join(" ",a);
    }
}

// Using .split() and Arrays.sort() with Comparator 1ms runtime Beats 80.45%

class Solution {
    public String sortSentence(String s) {
        String[] arr = s.split(" ");
        Arrays.sort(arr, (a,b) -> Character.compare(a.charAt(a.length()-1),b.charAt(b.length()-1)));
        StringBuilder sb = new StringBuilder();
        for(String x:arr){
            sb.append(x.substring(0,x.length()-1));
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
