// 10ms runtime Beats 80%

class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> invalid = new ArrayList<>();
        List<String[]> list = new ArrayList<>();
        Map<String,ArrayList<Transaction>> map = new HashMap<>();
        
        for(String t:transactions){
            String[] arr = t.split(",");
            list.add(arr);
            if(map.get(arr[0])==null)
                map.put(arr[0],new ArrayList<Transaction>());
            map.get(arr[0]).add(new Transaction(arr[3],arr[1]));
        }
       
        int i=0;
        for(String[] arr:list){
            if(Integer.parseInt(arr[2])>1000){
                invalid.add(transactions[i]);
            }
            else{
                for(Transaction tr:map.get(arr[0])){
                    if(!tr.city.equals(arr[3]) && Math.abs(tr.time-Integer.parseInt(arr[1]))<=60){
                       invalid.add(transactions[i]);
                       break;
                    }
                }
            }
            i++;
        }
        return invalid;
    }
}

class Transaction{
    String city;
    int time;
    public Transaction(String city,String time){
        this.city = city;
        this.time = Integer.parseInt(time);
    }
}
