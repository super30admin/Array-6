class Solution {
//Time Complexity:O(n)
//Space Complexity:O(1)
//We keep track of the minimum price we've seen so far while iterating.
//At each day, we calculate the profit if we sold today after buying at the lowest price.
//We keep updating the maximum profit based on that difference.
    public int maxProfit(int[] prices) {
        int left = 0; // points to minimum price position
        int right = 1;
        int maxprofit = 0;
        while(right<prices.length)
        {   
            if(maxprofit<prices[right]-prices[left])
            {
                maxprofit = prices[right]-prices[left];
            }
            if(prices[left]>prices[right])
            {
                left = right;
            }
            right++;
        }
        return maxprofit;
    }
}