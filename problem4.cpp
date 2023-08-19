
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Time Complexity : O(n)
// Space Complexity : O(n) // (here we directly initialized with maxVaue of n==> O(5000*2*2))
// Did this code successfully run on Leetcode : yes

// Approach: recurrsion + memoization


class Solution {
public:
    
    int t[5001][2][2]; // for idx, buy, cool
    int maxProfit(vector<int>& prices) {
        
        memset(t,-1,sizeof(t));
        
        return solve(prices, 0, 1,0);
    }
    int solve(vector<int>& prices,int idx, bool buy, bool cool)
    {
        if(idx==prices.size()){
            return 0;
        }
        
        if(t[idx][buy][cool]!=-1) return t[idx][buy][cool];
        
        int ans = 0;
        
        if(buy & !cool){
            ans = max(ans, ans-prices[idx] + solve(prices,idx+1,0,0));
            ans = max(ans, solve(prices,idx+1,buy,cool));
        }
        else if(!buy)
        {
            ans = max(ans, ans+prices[idx] + solve(prices,idx+1,1,1));
            ans = max(ans, solve(prices,idx+1,buy,cool));
        }
        else if(cool){
            ans = max(ans, solve(prices,idx+1,buy,!cool));
        }
        
        
        return t[idx][buy][cool] = ans;
    }
};


// Approach: bottom-up dp 
// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : yes

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if(prices.size()<2) return 0;
        
        int n = prices.size();
        
        vector<int>buy(n,0);
        vector<int>sell(n,0);
        
        buy[0] = -prices[0];
        sell[0] = 0;
        
        buy[1] = max(buy[0], 0 - prices[1]);
        sell[1] = max(sell[0], prices[1] + buy[0]);
        
        for(int i = 2;i<n;i++)
        {
            buy[i] = max(buy[i-1],sell[i-2]-prices[i]);
            sell[i] = max(sell[i-1],prices[i]+ buy[i-1]);
        }
        
        return sell[n-1];
    }
};