// TC - O(n*2*k) 
//SC - O(2*2*k)

public class sell_4 {
    
class Solution {
    public int maxProfit(int k, int[] prices) {
        
        int n = prices.length;
        int[][][] dp = new int[2][2][k+1]; // for storing curr(ith) and prev((i+1)th) 
        for(int i = n-1; i >= 0; i--){
            for(int buy = 0; buy < 2; buy++){
                for(int cap = 1; cap < k+1; cap++){
                    // if buy = 1 then you can buy, else you can sell
                    if(buy == 1){
                        dp[i%2][buy][cap] = Math.max(-prices[i] + dp[(i+1)%2][0][cap]
                                                            , 0 + dp[(i+1)%2][1][cap]);                     
                        }
                    else{
                        dp[i%2][buy][cap] = Math.max(prices[i] + dp[(i+1)%2][1][cap-1]
                                                            , 0 + dp[(i+1)%2][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][k];
    }
}
}
