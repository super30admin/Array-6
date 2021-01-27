# STEPS:
# Iterate the prices array.
# Consider every day as stock selling day. Find the minimum profit by comparing the current profit and selling price - cost price.
# Update the cost price after the profit has been updated. 
# Cost price will be minimum of previous cost price and current price from the prices array.

# Time complexity - O(n)
# Space complexity - O(1)
# Did this code run on leetcode? - yes
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices: return 0
        profit = 0
        
        cp = float('inf')
        for price in prices:
            # update the profit
            if price-cp > profit:
                profit = max(profit, price-cp)
            # update the cost price
            cp = min(price, cp)
        
        return profit


# Brute force solution
# Consider every position as the cost price and compute the profit by comparing it with the price of the stock after the current day.
# Find the maximum profit.
# Time complexity - O(n^2)
# Space complexity - O(1)
# Did this code run on leetcode? - no (TLE)
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)     # length of prices array
        profit = 0
        for i in range(n-1):
            for j in range(i+1, n):
                cp, sp = prices[i], prices[j]
                # update the profit
                profit = max(profit, sp-cp)
        
        return profit