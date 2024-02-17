#include<iostream>
#include<vector>

using namespace std;

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int res{};
        int sz = prices.size();
        if(sz == 1) return res;
        int min_val = prices.at(sz-1);
        int max_val = prices.at(sz-1);
        for(int i{sz-2};i>=0;--i){
            int curr_val = prices.at(i);
            int diff = max_val - curr_val;
            res = max(res,diff);
            max_val = max(max_val,curr_val);
            min_val = min(min_val,curr_val); 
        }
        return res;
    }
};

// more optimized solution
/*
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
you take a single array 1 and try to expand it. While expanding you find the minimum 
With that minimum find the difference of the next element , which will give you the profit.
*/

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        size_t sz = prices.size();
        if(sz == 1) return 0;
        int min_val{prices.at(0)};
        int profit{};
        for(int i = 1;i<sz;++i){
            profit = max(profit,prices.at(i)-min_val);
            min_val = min(min_val,prices.at(i));
        }
        return profit;
    }
};