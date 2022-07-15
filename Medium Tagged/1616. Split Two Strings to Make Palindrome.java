class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        
        return  check1(a,b)||check1(b,a)||check2(a,b)||check2(b,a);
    }
    
    
    private boolean check1(String a,String b)
    {
        int i=0;
        int j=a.length()-1;
      while(i<j)
      {
          if(a.charAt(i)==b.charAt(j))
          {
              i++;
              j--;
          }
          else
          {
              if(b.charAt(i)==b.charAt(j))
              {
                  i++;
                  j--;
              }
              else
                  return false;
          }
      }
        return true;
    }
    
    private boolean check2(String a,String b)
    {
        int i=0;
        int j=a.length()-1;
      while(i<j)
      {
          if(a.charAt(i)==b.charAt(j))
          {
              i++;
              j--;
          }
          else
          {
              if(a.charAt(i)==a.charAt(j))
              {
                  i++;
                  j--;
              }
              else
                  return false;
          }
      }
        return true;
    }
}
