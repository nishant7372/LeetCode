//Method 1 - Using .contains method 
class Solution {
    public boolean checkIfPangram(String s) {
            if(s.contains("a")&&s.contains("b")&&s.contains("c")&&s.contains("d")&&s.contains("e")&&s.contains("f")&&s.contains("g")&&s.contains("h")&&s.contains("i")&&s.contains("j")&&s.contains("k")&&s.contains("l")&&s.contains("m")&&s.contains("n")&&s.contains("o")&&s.contains("p")&&s.contains("q")&&s.contains("r")&&s.contains("s")&&s.contains("t")&&s.contains("u")&&s.contains("v")&&s.contains("w")&&s.contains("x")&&s.contains("y")&&s.contains("z"))
                return true;
        else
            return false;
    }
}

//Method 2 - Using a HashTable
class Solution {
    public boolean checkIfPangram(String s) {
            int[] a = new int[26];
        
        for(int i=0;i<s.length();i++)
        {
            a[s.charAt(i)-'a']=1;
        }
        for(int x:a)
        {
            if(x==0)
                return false;
        }
        return true;
    }
}
