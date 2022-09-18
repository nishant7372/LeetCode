class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
               
        int[] month = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
        
        String[] alice1 = arriveAlice.split("-");  //Alice Arrival
        String[] alice2 = leaveAlice.split("-");  //Alice Departure
        String[] bob1 = arriveBob.split("-");   //Bob Arrival 
        String[] bob2 = leaveBob.split("-");   //Bob Departure
        
        int d1,d2;
        int ma1 = Integer.parseInt(alice1[0]);  //Alice Arrival Month
        int mb1 = Integer.parseInt(bob1[0]);  //Bob Arrival Month
        int ma2 = Integer.parseInt(alice2[0]);  //Alice Departure Month
        int mb2 = Integer.parseInt(bob2[0]);   //Bob Departure Month
        
        if(ma1 > mb1)
            d1 = Integer.parseInt(alice1[1]);
        else if(ma1 < mb1)
            d1 = Integer.parseInt(bob1[1]);
        else 
            d1 = Math.max(Integer.parseInt(alice1[1]),Integer.parseInt(bob1[1]));
        
        if(ma2 < mb2)
            d2 = Integer.parseInt(alice2[1]);
        else if(ma2> mb2)
            d2 = Integer.parseInt(bob2[1]);
        else 
            d2 = Math.min(Integer.parseInt(alice2[1]),Integer.parseInt(bob2[1]));
    
        int m1  = Math.max(ma1,mb1);
        int m2  = Math.min(ma2,mb2);
     
        return Math.max(0,(month[m2-1]+d2)-(month[m1-1]+d1)+1);
    }
}
