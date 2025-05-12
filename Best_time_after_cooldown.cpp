// Time Complexity: O(n)
// Space Complexity: O(n)
// Did you run the code on Leetcode? Yes

// Approach:
// 1. Use memoization to store the results of subproblems.
// 2. Define a helper function that takes the current index, a flag indicating whether we can buy or sell, and the memoization table as arguments.
// 3. If the current index is out of bounds, return 0.
// 4. If the result for the current index and flag is already computed, return it.
// 5. If the flag is 1 (buy state), calculate the maximum profit by either buying or skipping the current price.
// 6. If the flag is 0 (sell state), calculate the maximum profit by either selling or skipping the current price.
// 7. Store the result in the memoization table and return it.

class Solution {
    public:
        int maxProfit(vector<int>& prices) {
            vector<vector<int>> memo (prices.size(), vector<int> (2, -1));
            return helper(prices, 0, 1, memo);
        }
    private: 
        int helper(vector<int>& prices, int i, int flag, vector<vector<int>>& memo){
            //base case
            if(i >= prices.size()){
                return 0;
            }
            if (memo[i][flag] != -1) return memo[i][flag];
            //buy state
            if(flag == 1){
                memo[i][flag] = max(helper(prices, i + 1, 1, memo), -prices[i] + helper(prices, i + 1, 0, memo)); 
            }
            else{//sell state
                memo[i][flag] = max(helper(prices, i + 1, 0, memo), prices[i] + helper(prices, i + 2, 1, memo));
            }
            return memo[i][flag];
        }
    };