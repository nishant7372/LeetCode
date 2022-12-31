class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int x:asteroids)
        {
            if(st.isEmpty())
                st.push(x);
            else
            {
                boolean flag=false;
                boolean flag2=true;
                while(!st.isEmpty() && ((x<0 && st.peek()>0)))
                {
                    flag2=false;
                    if(Math.abs(x)>Math.abs(st.peek()))
                    {
                        st.pop();
                        flag=true;
                    }
                    else if(Math.abs(x)==Math.abs(st.peek()))
                    {
                        st.pop();
                        flag=false;
                        break;
                    }
                    else{
                        flag=false;
                        break;
                    }
                }
                if(!st.isEmpty() && flag2){
                    flag=true;
                }
                if(flag)
                    st.push(x);
            }
        }
        int[] a = new int[st.size()];
        
        int i=0;
        for(int x:st)
            a[i++]=x;
        return a;
    }
}
