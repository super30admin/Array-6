class Solution {
public:
    int maxProfit(vector<int>& prices) 
    {
        
        int n=prices.size();
        
        if(n==0)
            return 0;
        
        int min_prices=prices[0];
        int profit=0;
        for(int i=0;i<n;i++)
        {
            min_prices=min(min_prices,prices[i]);
            profit=max(profit,(prices[i]-min_prices));
        }
        
        return profit;
    }
};