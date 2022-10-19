class Solution {
    public int countTime(String time) {
        int hr=0;
        if(time.charAt(0)=='?')
        {
            if(time.charAt(1)!='?')
            {
                if(time.charAt(1)>'3')
                    hr+=2;
                else
                    hr+=3;
            }
            else
                hr+=24;
        }
        else if(time.charAt(1)=='?')
        {
            if(time.charAt(0)=='2')
                hr+=4;
            else
                hr+=10;
        }
        
        int min = 0;
        if(time.charAt(3)=='?')
            min+=6;
        if(time.charAt(4)=='?')
            min= Math.max(min,1)*10;
        return Math.max(hr,1)*Math.max(1,min);
    }
}
