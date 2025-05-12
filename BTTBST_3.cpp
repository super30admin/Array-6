//Time Complexity: O(n)
//Space Complexity: O(1)
// Did you run the code on Leetcode? Yes

//Approach: 
//1. Buy 1 is the minimum price seen so far.
//2. Sell 1 is the maximum profit seen so far.
//3. Buy 2 is the minimum price seen so far after selling 1.
//4. Sell 2 is the maximum profit seen so far after buying 2.
//5. Iterate through the prices array, updating buy1, sell1, buy2, and sell2 as you go.
//6. Return sell2, which is the maximum profit after two transactions.

class Solution {
    public:
        int maxProfit(vector<int>& prices) {
            int buy1 = INT_MAX, buy2 = INT_MAX;
            int sell1 = INT_MIN, sell2 = INT_MIN;
            for(int i = 0; i < prices.size(); i++){
                buy1 = min(buy1, prices[i]);
                sell1 = max(sell1, prices[i] - buy1);
                buy2 = min(buy2, prices[i] - sell1);
                sell2 = max(sell2, prices[i] - buy2);
            }
            return sell2;
        }
    };