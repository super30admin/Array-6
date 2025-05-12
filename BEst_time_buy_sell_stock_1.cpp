//Time Complexity: O(n)
//Space Complexity: O(1)
// Did you run the code on Leetcode? Yes

//Approach: 
//1. Initialize a variable to keep track of the minimum price seen so far.
//2. Initialize a variable to keep track of the maximum profit seen so far.
//3. Iterate through the prices array, updating the minimum price and maximum profit as you go.

class Solution {
    public:
        int maxProfit(vector<int>& prices) {
            int minimum = INT_MAX;
            int maxP = INT_MIN;
            for(int i = 0; i < prices.size(); i++){
                minimum = min(minimum, prices[i]);
                maxP = max(maxP, prices[i] - minimum);
            }
            return maxP;
        }
    };