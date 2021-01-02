class Solution {
public:
    int maxProfit(int k, vector<int>& prices) {
        vector<int> profit(k+1,0),buys(k+1,INT_MAX);        
        for (int j=0;j<prices.size();j++) {
            for (int i=1;i<=k;i++) {
                buys[i]=min(buys[i],prices[j]-profit[i-1]);
                profit[i]=max(profit[i],prices[j]-buys[i]);
            }
        } 
       return profit[k];
    }
};