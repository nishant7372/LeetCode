class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i,j,pairs;
        i=j=pairs=0;
        while(i<players.length&&j<trainers.length)
        {
            if(players[i]<=trainers[j])
            {
                i++;
                j++;
                pairs++;
            }
            else if(players[i]>trainers[i])
            {
                j++;
            }
        }
        return pairs;
    }
}
