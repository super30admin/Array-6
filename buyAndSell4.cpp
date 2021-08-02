//Time: O(kN) where k is the number of transactions and N is the size of the prices
//Space : O(k)
class Solution {
public:
    int maxProfit(int k, vector<int>& prices) {
        if(k > prices.size()/2){
            int profit = 0;
            for(int i = 1; i < prices.size();i++){
                if(prices[i] > prices[i-1]) profit += (prices[i] - prices[i-1]);
            }
            return profit;
        }
        vector<int> costArray(k+1,INT_MAX);
        vector<int> profitArray(k+1,0);
        for(auto &price : prices){
            for(int i = 1; i <= k; i++){
                costArray[i] = min(costArray[i],price - profitArray[i-1]);
                profitArray[i] = max(profitArray[i],price - costArray[i]);
            }
        }
        return profitArray[k];
    }
};