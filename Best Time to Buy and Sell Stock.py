'''
Time Complexity: O(n)
Space Complexity: O(1)
Did this code successfully run on Leetcode : Yes
Explanation: For each day check if the price is less than the minPrice, if its true then make minPrice the price.
If the price - minPrice > maxProfit so far then update maxProfit  = price - minPrice.
'''
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        minPrice = math.inf
        maxProfit = 0

        for price in prices:
            if price < minPrice:
                minPrice = price
            elif price - minPrice > maxProfit:
                maxProfit = price - minPrice

        return maxProfit