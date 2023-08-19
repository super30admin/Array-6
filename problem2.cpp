
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Time Complexity : O(n)   
// Space Complexity : O(100000) (took max value of n=100000)
// Did this code successfully run on Leetcode : yes

// Approach: Recursion + Memoization

// The idea was to explore all the options of buying and selling and limit the transactions to 2.


class Solution {
public:
    int t[100001][3][2];
    int maxProfit(vector<int>& prices) {
        
        memset(t,-1,sizeof(t));
        
        return solve(prices,0,2,1);
        
  
    }
    int solve(vector<int>&prices, int idx,int k,bool buy)
    {
        if(k==0 || idx==prices.size()){
            return 0;
        }
        
        if(t[idx][k][buy]!=-1) return t[idx][k][buy];
        
        int ans = 0;
        
        if(buy){
            ans = max(ans,ans-prices[idx]+ solve(prices,idx+1,k,!buy));
        }
        else
        {
            ans = max(ans, ans+prices[idx]+solve(prices,idx+1,k-1,!buy));
        }
        ans = max(ans,solve(prices,idx+1,k,buy));
        
        return t[idx][k][buy]=ans;

    }
};

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

// Approach: Bottom-up DP


class Solution {
public:

    int maxProfit(vector<int>& prices) {
        
        int n = prices.size();
        
        vector<vector<vector<int>>>dp(n+1,vector<vector<int>>(3,vector<int>(2,0)));
        
        
        for(int idx = n-1;idx>=0;idx--)
        {
            for(int k = 1;k<=2;k++)
            {
                for(int buy = 0;buy<=1;buy++)
                {
                    if(buy==1)
                    {
                        dp[idx][k][buy] = max(dp[idx][k][buy],dp[idx][k][buy] - prices[idx] + dp[idx+1][k][0]);
                    }
                    else
                    {
                        dp[idx][k][buy] = max(dp[idx][k][buy],dp[idx][k][buy] + prices[idx] + dp[idx+1][k-1][1]);
                    }
                    dp[idx][k][buy] = max(dp[idx][k][buy],dp[idx+1][k][buy]);
                }
            }
        }
        
        return dp[0][2][1];

    }
   
};

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

// ****Approach: Greedy
// this is built on idea by solving problem1.cpp
// Here the main idea is to think in a way so that we get our final answer after selling transaction2.

// so we take 4 variables for 2 transactions.
// for the first transaction, it is a normal case.
// for the second transaction, we compensated the profit value of first transaction in the second transaction.
// so, by doing that, we are able to get our total profit value in the variable t2profit.

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int t1cost = INT_MAX, t2cost = INT_MAX;
        int t1profit = 0, t2profit = 0;
        
        for(int price: prices)
        {
            t1cost = min(t1cost,price);
            t1profit = max(t1profit, price - t1cost);
            
            t2cost = min(t2cost, price - t1profit);
            t2profit = max(t2profit, price - t2cost);
        }
        
        return t2profit;
    }
};