/*
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
When trying to take the second array and find the max profit and extract it

// Your code here along with comments explaining your approach
For the profit 1
First go from left to right and find the max profit 
here you will take the  min and subtract the incoming from the current min and update min
For the profit 2
subsequently store the profit at each index.
First go from right to left to find the max profit
here you will take the incoming element and subtract it from the current max and update max
Here also store the profit at each index.
Then you will take the initial gross profit as what would be if you take the whole array . 
it is either equal to profit at last index of profit 1 array or first index of profit 2 array.
Since we have to find the max at each parititon , we will make partitoin and used the stored profit to find the sum of profit. 
Update gross profit with the max profit.
*/

#include<iostream>
#include<vector>

using namespace std;

class Solution {

public:
    int maxProfit(vector<int>& prices) {
        size_t sz = prices.size();
        int res{};
        if(sz == 1) return res; //base case length 1;
        vector<int> profit_1(sz,0);
        vector<int> profit_2(sz,0);
        int min_1{prices.at(0)};
        int max_2{prices.at(sz-1)};
        for(int i = 1;i<sz;++i){
            profit_1.at(i) = max(profit_1.at(i-1),prices.at(i)-min_1);
            min_1 = min(min_1,prices.at(i));
            profit_2.at(sz-i-1) = max(profit_2.at(sz-i),max_2 - prices.at(sz-i-1));
            max_2 = max(max_2,prices.at(sz-i-1)); 
        }
        //cout<<"profit_1\tprofit_2"<<endl;
        res = profit_1.at(0) + profit_2.at(0);
        for(int i=1;i<sz-1;++i){
            //cout<<profit_1.at(i)<<"\t"<<profit_2.at(i)<<endl;
            res = max(res,profit_1.at(i)+profit_2.at(i+1));
        }
        return res;
    }
};