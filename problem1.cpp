// Time Complexity : O(n) , n = prices.size()
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        
        int min_so_far = INT_MAX;
        int ans = INT_MIN;
        
        for(int i = 0;i<n;i++)
        {
            min_so_far = min(min_so_far, prices[i]);
            ans = max(prices[i] - min_so_far,ans);
        }
        return ans;
    }
};