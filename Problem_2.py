"""
Time Complexity : O(n) 
Space Complexity : O(1)  
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

The brute force for this solution would have a time complexity of O(n^4). This is because, for every pair of first transaction, 
we have to find out all the pairs of second trasaction in order to calculate the maximum profit. To optimize this, we would
just iterate through the array once. As we can do maximum 2 transactions, so we maintain 4 variables for buying and selling
respectively. While iterating, the buy1 would always be the minimum of current value and any value that has occured in the
array before. So basically, buy1 tells us the minimum value in the array when we can buy if we had to do only 1 transaction. 
Similarly is sell1. It is the maximum selling price if we had to do only 1 transaction. Now if we have to do a second transaction,
buy2 would mak sure that it takes into account the profit from first transaction. It does this buy making the current value decrease
by the selling price earlier, ie, sell1. This inculcates the earlier profit. Similarly we will calculate sell2(like sell1).
So, at the end, sell2 would be having all the profit if it was one or two transactions.
"""


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy1, buy2 = inf, inf
        sell1, sell2 = 0, 0
        for price in prices:
            buy1 = min(buy1, price)
            sell1 = max(sell1, price-buy1)
            buy2 = min(buy2, price-sell1)
            sell2 = max(sell2, price-buy2)
        return sell2
