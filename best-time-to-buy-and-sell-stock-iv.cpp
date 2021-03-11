//Time - O(nxk)
//Space - O(k)
class Solution {
public:
    int maxProfit(int k, vector<int>& prices) {
        vector<int> buy (k+1, INT_MAX);
        vector<int> sell (k+1, 0);
        
        for(auto p:prices){
            for(int i = 1;i<=k;i++){
                buy[i] = min(buy[i], p - sell[i-1]);
                sell[i] = max(sell[i], p - buy[i]);
            }
        }
        
        return sell[k];
    }
};