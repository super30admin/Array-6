# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy1 = float('inf')
        sell1 = float('-inf')
        buy2 = float('inf')
        sell2 = float('-inf')
        
        for price in prices:
            ## transaction 1
            buy1 = min(buy1, price)  # min price of stock 1
            sell1 = max(sell1, price-buy1)
            
            # transaction 2 
            # there may be a case where transaction 2 never happens
            # e.g. [10,9,8,7,20,15]
            buy2 = min(buy2, price-sell1) # effective min price of stock 2
            sell2 = max(sell2, price-buy2)
            
        return sell2