class Solution:
    '''
    Accepted on leetcode(123)
    Time - O(N)
    Space - O(1)
    Approach:
    1. Initialize 4 variables(buy1, buy2 as integer max. sell1 and sell2 as 0 to handle edge case of returning 0 if prices list is empty).
    2. Iterate through the prices list and recalculate the 4 variables. buy1 and sell1 are similar to part 1 of this question. But buy2 is calculated here thinking that we are reinvesting the money we are gaining in first transaction(as per the formula applied below).
    3. Finally return the sell2 as final profit.
    '''

    def maxProfit(self, prices) -> int:
        buy1 = float("inf")
        sell1 = 0
        buy2 = float("inf")
        sell2 = 0

        for price in prices:
            buy1 = min(buy1, price)
            sell1 = max(sell1, price - buy1)
            buy2 = min(buy2, price - sell1)
            sell2 = max(sell2, price - buy2)
        return sell2