//Time - O(n)
//Space - O(1)
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int buy1 = prices[0], buy2 = prices[0], profit1 = INT_MIN, profit2 = INT_MIN;
        
        for(auto p: prices){
            buy1 = min(buy1, p);
            profit1 = max(profit1, p-buy1);
            buy2 = min(buy2, p-profit1);
            profit2 = max(profit2, p-buy2);
        }
        
        return profit2;
    }
};