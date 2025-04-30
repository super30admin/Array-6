/*
TC : O(n)
SC : O(1)
*/
class Solution
{
public:
    int maxProfit(vector<int> &prices)
    {
        if (prices.size() == 0)
        {
            return 0;
        }
        int min = INT_MAX;
        int profit = INT_MIN;
        for (int i = 0; i < prices.size(); i++)
        {
            if (prices[i] < min)
            {
                min = prices[i];
            }
            int temp = prices[i] - min;
            if (temp > profit)
            {
                profit = temp;
            }
        }
        return profit;
    }
};