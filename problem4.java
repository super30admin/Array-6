import java.util.Arrays;
// Time Complexity:O(n)
// Space Complexity:O(1)
public class problem4 {
    int[][] memo;
    public int maxProfit(int[] prices) {
        int n= prices.length;
        memo=new int[n][2];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(memo[i],-1);
        }
        return helper(prices, 0, 0);
    }
    public int helper(int[] prices, int idx,int state)
    {
        if(idx>=prices.length)
        {
            return 0;
        }
        if(memo[idx][state] !=-1){
            return memo[idx][state];
        }
        int result=0;
        if(state==0)
        {
            result= Math.max(helper(prices,idx+1, 0),helper(prices, idx+1, 1) -prices[idx]);
        }
        else{
            result= Math.max(helper(prices,idx+1, 1),helper(prices, idx+2, 0) +prices[idx]);
        }

        memo[idx][state] = result;
        return result;
    }
}
