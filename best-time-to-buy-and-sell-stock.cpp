//Time - O(n)
//Space - O(1)
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int low = prices[0];
        int profit = INT_MIN;
        for(auto p:prices){
            if(low>p){
                low = p;
            }else{
                profit = max(profit, p-low);
            }
        }
        
        return profit;
    }
};