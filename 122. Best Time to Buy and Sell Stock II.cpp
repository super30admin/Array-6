/*
Time: O(n)
Space: O(n)

Use DP
(don't worry abut 'However, you can buy it then immediately sell it on the same day.', it just means skipping the day)
*/

class Solution {
public:
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */

    vector<int> p;
    vector<vector<int>> dp;

    //DP States:
    //Current day
    //If i have to buy or sell in this day
    int call(int day, int turn){ //day where we can buy a stock
        if(day == p.size())  return 0;
        
        if(dp[day][turn]!=-1)  return dp[day][turn]; //using memorized value
        
        int maxi = call(day+1, turn); //don't have transaction on this day
        
        int profit = turn ? p[day] : -p[day];
        maxi = max(maxi, profit + call(day+1, 1-turn)); //have transaction on this day
    
        return dp[day][turn] = maxi; //memorizing value 
    }

    int maxProfit(vector<int> &prices) {
        // write your code here
        p = prices;
        int n = prices.size();
        dp = vector<vector<int>> (n, vector<int> (2,-1) );
        
        return call(0,0);
    }
};