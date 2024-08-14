class Solution {
public:
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */

    vector<int> p;
    vector<vector<vector<int>>> dp;

    int call(int day, int turn, int k){ //day where we can buy a stock
        if(day == p.size() || k==0)  return 0;
        
        if(dp[day][turn][k]!=-1)  return dp[day][turn][k]; //using memorized value
        
        int maxi = call(day+1, turn, k); //don't have transaction on this day
        
        int profit = turn ? p[day] : -p[day];
        maxi = max(maxi, profit + call(day+1, 1-turn, k-1)); //have transaction on this day
    
        return dp[day][turn][k] = maxi; //memorizing value 
    }

    int maxProfit(vector<int> &prices) {
        // write your code here
        p = prices;
        int n = prices.size();
        dp = vector<vector<vector<int>>> (n, vector<vector<int>> (2,vector<int>(5,-1)));
        
        return call(0,0,4);
    }
};
