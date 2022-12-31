class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] id, int k) {
        Set<String> pset = new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> nset = new HashSet<>(Arrays.asList(negative_feedback));
    
        int[][] arr2 = new int[report.length][2];
        for(int i=0;i<report.length;i++)
        {
            String[] arr = report[i].split(" ");
            int score=0;
            for(String x:arr)
            {
                if(pset.contains(x))
                    score+=3;
                if(nset.contains(x))
                    score--;
            }
            arr2[i][0]=id[i];
            arr2[i][1]=score;
        }
        
        Arrays.sort(arr2, (a,b) -> a[1]==b[1]? Integer.compare(a[0],b[0]):Integer.compare(b[1],a[1]));
        
        List<Integer> list = new ArrayList<>();
    
        for(int i=0;i<k;i++)
            list.add(arr2[i][0]);
        return list;
    }
}
