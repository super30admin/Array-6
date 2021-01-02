class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int buy1=INT_MAX,buy2=INT_MAX,sell1=0,sell2=0;
        for (int i=0;i<prices.size();i++) {
            buy1=min(buy1,prices[i]);
            sell1=max(prices[i]-buy1,sell1);
            buy2=min(buy2,prices[i]-sell1);
            sell2=max(prices[i]-buy2,sell2);
        }
        return sell2;
    }
};