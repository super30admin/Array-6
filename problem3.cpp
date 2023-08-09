
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Time Complexity : O(nk)  
// Space Complexity : O(nk)  (Here we directly max Value so O(10^5) );
// Did this code successfully run on Leetcode : yes


class Solution {
public:
    int dp[1001][101][2];   // for idx, k, buy
    int maxProfit(int k, vector<int>& prices) {
        
        memset(dp,-1,sizeof(dp));
        
        return solve(prices,0,k,1);
    }
    int solve(vector<int>& prices, int idx, int k,bool buy)
    {
        if(k==0 || idx == prices.size())
        {
            return 0;
        }
        if(dp[idx][k][buy]!=-1) return dp[idx][k][buy];
        
        int ans = 0;
        
        if(buy){
            ans = max(ans, ans-prices[idx] + solve(prices,idx+1,k,0));
        }
        else{
            ans = max(ans, ans+prices[idx] + solve(prices,idx+1,k-1,1));
        }
        ans = max(ans, solve(prices,idx+1,k,buy));
        
        return dp[idx][k][buy] = ans;
        
    }
};


// Time Complexity : O(nk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes



class Solution {
public:
    int maxProfit(int k, vector<int>& prices) {
        vector<int>cost(k+1,INT_MAX);
        
        vector<int>profit(k+1,0);
        
        for(int price: prices)
        {
            cost[1] = min(cost[1],price);
            profit[1] = max(profit[1], price - cost[1]);
            
            for(int i = 2;i<=k;i++){
                cost[i] = min(cost[i], price - profit[i-1]);
                profit[i] = max(profit[i], price - cost[i]);
            }
        }
        
        return profit[k];
    }
};