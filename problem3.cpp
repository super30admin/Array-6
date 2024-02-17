#include<iostream>
#include<vector>

using namespace std;

// the one with memorization 
/*
// Time Complexity : O(N*K)
// Space Complexity : O(N*K)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
*/

class Solution {
public:
    int foo(int idx,int transaction,int n,int k,vector<int>& prices,vector<vector<int>>& dp_arr){
        if(idx == n || transaction == 2*k) return 0;
        if(dp_arr[idx][transaction]!=-1) return dp_arr[idx][transaction];
        //buy
        if(transaction%2 == 0){
            return dp_arr[idx][transaction] = max(-prices.at(idx) + foo(idx+1,transaction+1,n,k,prices,dp_arr),0 + foo(idx+1,transaction,n,k,prices,dp_arr));
        }
        //sell
            return dp_arr[idx][transaction] = max(foo(idx+1,transaction,n,k,prices,dp_arr),prices.at(idx)+foo(idx+1,transaction+1,n,k,prices,dp_arr));
    }
    int maxProfit(int k, vector<int>& prices) {
        size_t sz = prices.size();
        vector<vector<int>> dp_arr(sz,vector<int>(2*k,-1));
        return foo(0,0,sz,k,prices,dp_arr);
    }
};

// the one with tabulation
/*
// Time Complexity : O(N*K)
// Space Complexity : O(N*K)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
*/


class Solution {
public:

    int maxProfit(int k, vector<int>& prices){
        size_t sz = prices.size();
        vector<vector<int>> dp_arr(sz+1,vector<int>(2*k+1,0));
        for(int i = sz-1;i>=0;i--){
            for(int j = 2*k-1;j>=0;j--){
                //buy
                if(j%2 == 0){
                    dp_arr[i][j] = max(-prices.at(i)+dp_arr[i+1][j+1],dp_arr[i+1][j]);
                }
                //sell
                else{
                    dp_arr[i][j] = max(0 + dp_arr[i+1][j],prices.at(i)+dp_arr[i+1][j+1]);
                }
            }
        }
        return dp_arr[0][0];
    }
};