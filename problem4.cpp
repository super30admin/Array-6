#include<iostream>
#include<vector>

using namespace std;

//brute force

class Solution {
    int foo(int idx,int buy,int n,vector<int>& prices){
        if(idx >= n) return 0;

        if(buy){
            return max(-prices.at(idx)+foo(idx+1,0,n,prices),0 + foo(idx+1,1,n,prices));
        }
        //sell
        return max(prices.at(idx)+foo(idx+2,1,n,prices),0 + foo(idx+1,0,n,prices));

    }
public:
    int maxProfit(vector<int>& prices) {
        size_t sz = prices.size();
        return foo(0,1,sz,prices);
    }
};

//  memorization

/*
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
*/

class Solution {

    int foo(int idx,int buy,int n,vector<int>& prices,vector<vector<int>>& dp_arr){
        if (idx>=n) return 0;
        if(dp_arr[idx][buy]!=-1) return dp_arr[idx][buy];
        if(buy){
            return dp_arr[idx][buy] = max(-prices.at(idx)+foo(idx+1,0,n,prices,dp_arr),0 + foo(idx+1,1,n,prices,dp_arr));
        }
        return dp_arr[idx][buy] = max(prices.at(idx)+foo(idx+2,1,n,prices,dp_arr),0 + foo(idx+1,0,n,prices,dp_arr));
    }

    public:

    int maxProfit(vector<int>& prices) {
        int sz = prices.size();
        vector<vector<int>> dp_arr(sz,vector<int>(2,-1));
        return foo(0,1,sz,prices,dp_arr);
    }
};