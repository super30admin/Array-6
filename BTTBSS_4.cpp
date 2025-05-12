// Time Complexity: O(n*k)
// Space Complexity: O(k)
// Did you run the code on Leetcode? Yes

// Approach:
// 1. If k is greater than or equal to half the length of prices, we can make as many transactions as we want.
// 2. Initialize two vectors, buy and sell, to keep track of the minimum price and maximum profit for each transaction.
// 3. Iterate through the prices array, updating buy and sell for each transaction.
// 4. Return the maximum profit for k transactions.

class Solution {
    public:
        int maxProfit(int k, vector<int>& prices) {
            if(k >= prices.size() / 2){
                int maxProfit = 0; 
                for(int i = 1; i < prices.size(); i++){
                    if(prices[i] > prices[i - 1]){
                        maxProfit += prices[i] - prices[i - 1];
                    }
                }
                return maxProfit;
            }
    
            vector<int> buy(k + 1, INT_MAX);
            vector<int> sell(k + 1, 0);
    
            for(int price : prices){
                for(int j = 1; j <= k; j++){
                    buy[j] = min(buy[j], price - sell[j - 1]);
                    sell[j] = max(sell[j], price - buy[j]);
                }
            }
            return sell[k];
        }
    };