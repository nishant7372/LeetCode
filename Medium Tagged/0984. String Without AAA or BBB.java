class Solution {
    public String strWithout3a3b(int a, int b) {
       StringBuffer sb = new StringBuffer();
       if(a>=b)
       while(a!=0&&b!=0)
       {
           sb.append("ab");
           a--;
           b--;
       }
       if(b>a)
       while(a!=0&&b!=0)
       {
          sb.append("ba");
           a--;
           b--;
       }
       if(a>0)
       {
           sb.insert(0,'a');
           a--;
           for(int i=0;i<sb.length();i++)
           {
               if(sb.charAt(i)=='b')
               {
               sb.insert(i+1,'a');
                   a--;
                   i++;
               }
               if(a==0)
                   break;
           }
           if(a>0)
           {
           sb.insert(sb.length()-1,'a');
           a--;
           }
       }
       
       if(b>0)
       {
           sb.insert(0,'b');
           b--;
           for(int i=0;i<sb.length();i++)
           {
               if(sb.charAt(i)=='a')
               {
               sb.insert(i+1,'b');
                   b--;
                   i++;
               }
               if(b==0)
               break;
           }
           if(b>0)
           {
           sb.insert(sb.length()-1,'b');
           b--;
           }
       }     
        return sb.toString();
    }
}
