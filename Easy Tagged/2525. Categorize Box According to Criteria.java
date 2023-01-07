class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        long vol = (long)length*(long)width*(long)height;
        boolean bulky=false;
        boolean heavy=false;
        if(length>=10000 || width>=10000 || height>=10000 || vol>=1000000000){
            bulky=true;
        }
        if(mass>=100){
            heavy=true;
        }
        if(bulky && heavy){
            return "Both";
        }
        if(bulky){
            return "Bulky";
        }
        if(heavy){
            return "Heavy";
        }
        return "Neither";
    }
}
