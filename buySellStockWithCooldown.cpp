class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if (prices.size()==0) return 0; 
        vector<int> buys(prices.size()+1,0) ,profit(prices.size()+1,0);
        
        buys[1]=prices[0];
        for (int i=1;i<prices.size();i++) {
            buys[i+1]=min(buys[i],prices[i]-profit[i-1]);
            profit[i+1]=max(profit[i],prices[i]-buys[i+1]);
        }
        return profit[prices.size()];
    }
};