/*
TC : O(n)
SC : O(1)
*/
class Solution
{
public:
    int maxProfit(vector<int> &prices)
    {
        if (prices.size() == 0 || prices.size() < 2)
        {
            return 0;
        }
        int buy1 = INT_MAX, sell1 = 0;
        int buy2 = INT_MAX, sell2 = 0;

        for (int i = 0; i < prices.size(); i++)
        {
            buy1 = min(buy1, prices[i]);
            sell1 = max(sell1, prices[i] - buy1);
            // return the profit if any
            buy2 = min(buy2, prices[i] - sell1);
            // stores the
            sell2 = max(sell2, prices[i] - buy2);
        }

        return sell2;
    }
};