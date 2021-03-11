//Time-O(n)
//Space - O(n)
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if(prices.size()<2) return 0;
        
        vector<int> buy (prices.size());
        vector<int> sell (prices.size());
        
        buy[0] = -prices[0];
        buy[1] = max(buy[0], 0-prices[1]);
        sell[0] = 0;
        sell[1] = max(sell[0], buy[1]+prices[1]);
        
        for(int i = 2;i<prices.size();i++){
            buy[i] = max(buy[i-1], sell[i-2]-prices[i]);
            sell[i] = max(sell[i-1], buy[i-1]+prices[i]);
        }
        
        return sell[prices.size()-1];
        
    }
};