// problem link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
// time complex : O(n)
// space Complex : O(n)

class Solution {
    int[] memo;
    int n ;
    int[] prices;
    public int maxProfit(int[] prices) {
        this.prices = prices;
        this.n = prices.length;
        this.memo = new int[n];
        Arrays.fill(memo, -1);
        return helper(0);
    }

    private int helper(int start){
        // base case
        if(start>=n)
            return 0;
        if(memo[start] != -1)
            return memo[start];

        // otherwise
        int currMax = 0 ; 
        int result = helper(start+1) ;
        for(int i = start; i<n ; i++){
            currMax = Math.max(currMax, prices[i]-prices[start]);
            result = Math.max(result, currMax + helper(i+2));
        }
        memo[start] = result;
        return result;
    }
}
