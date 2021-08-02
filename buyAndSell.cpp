//Time:O(n) where n is the size of the prices
//Space:O(1)
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int minVal = INT_MAX;
        int currProfit = 0;
        for(int i = 0; i < size;i++){
            minVal = min(minVal,prices[i]);
            currProfit = max(prices[i] - minVal,currProfit);
        }
        return currProfit;
    }
};